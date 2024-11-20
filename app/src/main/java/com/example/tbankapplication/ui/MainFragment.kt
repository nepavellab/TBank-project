package com.example.tbankapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.tbankapplication.databinding.MainFragmentBinding
import com.example.tbankapplication.ui.recycler.JokeAdapter
import kotlinx.coroutines.runBlocking

class MainFragment(
    private val viewModel: JokeViewModel
) : Fragment() {
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

        adapter = JokeAdapter { position ->
            val jokeFragment = JokeFragment.newInstance(position)

            parentFragmentManager.popBackStack()

            parentFragmentManager.beginTransaction()
                .add(binding.root.id, jokeFragment)
                .addToBackStack(null)
                .commit()
        }
        binding.recyclerView.adapter = adapter

        binding.btnAddJoke.setOnClickListener {
            val fragment = JokeAddFragment(viewModel)

            if (savedInstanceState == null) {
                parentFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .add(binding.root.id, fragment)
                    .commit()
            }
        }

        viewModel.jokeList.observe(viewLifecycleOwner, Observer { newValue ->
            adapter.setItems(newValue)
            viewModel.jokeList.value?.let { jokeList ->
                if (jokeList.isNotEmpty()) {
                    binding.tvEmptyJokeList.visibility = View.INVISIBLE
                }
            }
        })
    }
}