package com.example.tbankapplication.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tbankapplication.databinding.JokeFragmentBinding
import com.example.tbankapplication.domain.entity.Joke

class JokeFragment : Fragment() {
    private lateinit var binding: JokeFragmentBinding
    private var joke: Joke? = null

    fun injectJoke(outerJoke: Joke) {
        joke = outerJoke
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
            tvJokeCategory.text = joke?.category
            tvQuestion.text = joke?.question
            tvAnswer.text = joke?.answer
        }
    }
}