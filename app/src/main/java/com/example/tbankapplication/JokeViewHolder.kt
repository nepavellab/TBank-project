package com.example.tbankapplication

import androidx.recyclerview.widget.RecyclerView
import com.example.tbankapplication.databinding.JokeBinding

class JokeViewHolder(
    private val binding: JokeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(joke: Joke) {
        with(binding) {
            tvCategory.text = joke.category
            tvJokeQuestion.text = joke.question
            tvJokeAnswer.text = joke.answer
        }
    }
}