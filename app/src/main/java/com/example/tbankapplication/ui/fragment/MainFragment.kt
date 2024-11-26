package com.example.tbankapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tbankapplication.R
import com.example.tbankapplication.databinding.MainFragmentBinding
import com.example.tbankapplication.viewmodel.JokeViewModel
import com.example.tbankapplication.ui.recycler.JokeAdapter
import com.example.tbankapplication.viewmodel.ScreenState
import kotlinx.coroutines.runBlocking

class MainFragment(
    private val viewModel: JokeViewModel
) : Fragment() {
    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter: JokeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRetainInstance(true)
    }

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

        adapter = JokeAdapter(viewModel) { position ->
            val jokeFragment = JokeFragment.newInstance(position)

            parentFragmentManager.popBackStack()

            parentFragmentManager.beginTransaction()
                .add(binding.root.id, jokeFragment)
                .addToBackStack(null)
                .commit()
        }
        binding.recyclerView.adapter = adapter

        binding.btnAddJoke.setOnClickListener {
            val fragment = JokeAddFragment { joke -> viewModel.update(joke) }

            parentFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .add(binding.root.id, fragment)
                .commit()
        }
        setObservers()
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
                ScreenState.SHOW_CONTENT -> {
                    if (state.jokeList.isNotEmpty()) {
                        binding.tvEmptyJokeList.visibility = View.INVISIBLE
                        adapter.setItems(state.jokeList)
                    }
                    binding.progressBar.visibility = ProgressBar.GONE
                }
            }
        }
    }
}