package com.example.tbankapplication.presentation.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.tbankapplication.R
import com.example.tbankapplication.databinding.MainFragmentBinding
import com.example.tbankapplication.domain.entity.Joke
import com.example.tbankapplication.presentation.viewmodel.JokeViewModel
import com.example.tbankapplication.presentation.recycler.JokeAdapter
import com.example.tbankapplication.presentation.recycler.ScrollListener
import com.example.tbankapplication.presentation.viewmodel.ScreenState
import com.example.tbankapplication.presentation.viewmodel.ViewModelFactory
import kotlinx.coroutines.runBlocking

class MainFragment : Fragment(){
    private val viewModel: JokeViewModel by lazy {
        val factory = ViewModelFactory(requireContext())
        ViewModelProvider(this, factory)[JokeViewModel::class.java]
    }
    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter: JokeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = runBlocking {
        super.onViewCreated(view, savedInstanceState)

        adapter = JokeAdapter(::onTapCallback, ::attachFavourite)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addOnScrollListener(ScrollListener {
            viewModel.loadJokes()
        })

        binding.btnAddJoke.setOnClickListener { addJokeScreen() }
        binding.fabClearCash.setOnClickListener { clearNetCashDialog() }

        setObservers()
    }

    private fun onTapCallback(joke: Joke) {
        val jokeFragment = JokeFragment()
        jokeFragment.injectJoke(joke)

        parentFragmentManager.popBackStack()

        parentFragmentManager.commit {
            add(binding.root.id, jokeFragment)
            addToBackStack(null)
        }
    }

    private fun attachFavourite(joke: Joke) {
        if (joke.isFavourite) {
            viewModel.deleteFavourite(joke)
        } else {
            viewModel.addFavourite(joke)
        }
    }

    private fun addJokeScreen() {
        val fragment = JokeAddFragment()
        fragment.setAddJokeCallback{ joke ->
            viewModel.addJoke(joke)
        }

        parentFragmentManager.popBackStack()

        parentFragmentManager.commit {
            add(R.id.main, fragment)
            addToBackStack(null)
        }
    }

    private fun clearNetCashDialog() {
        val builder = AlertDialog.Builder(this@MainFragment.context)
        builder.setTitle(R.string.cashClearDialogTitle)
        builder.setMessage(R.string.cashClearingConfirmation)

        builder.setPositiveButton("ДА") { _, _ ->
            viewModel.clearNetCash()
        }
        builder.show()
    }

    private fun setObservers() {
        viewModel.modelState.observe(viewLifecycleOwner) { state ->
            when (state.screenState) {
                ScreenState.LOAD -> {
                    binding.progressBar.visibility = ProgressBar.VISIBLE
                }
                ScreenState.ERROR -> {
                    binding.progressBar.visibility = ProgressBar.GONE
                    Toast.makeText(context, R.string.jokeLoadError, Toast.LENGTH_LONG).show()
                }
                ScreenState.SHOW_CONTENT -> runBlocking {
                    val jokes = state.jokeRepository.getJokes()
                    if (jokes.isNotEmpty()) {
                        binding.tvEmptyJokeList.visibility = View.INVISIBLE
                        adapter.setItems(jokes)
                    }
                    binding.progressBar.visibility = ProgressBar.GONE
                }
            }
        }
    }
}