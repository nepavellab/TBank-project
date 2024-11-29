package com.example.tbankapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tbankapplication.data.Joke
import com.example.tbankapplication.databinding.JokeFragmentBinding

class JokeFragment(
    private val joke: Joke
) : Fragment() {
    private lateinit var binding: JokeFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRetainInstance(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = JokeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tvJokeCategory.text = joke.category
            tvQuestion.text = joke.question
            tvAnswer.text = joke.answer
        }
    }
}