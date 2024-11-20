package com.example.tbankapplication.ui.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.tbankapplication.data.Joke
import com.example.tbankapplication.databinding.JokeBinding

class JokeViewHolder(
    private val binding: JokeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(joke: Joke, clickListener: (Int) -> Int, position: Int) {
        with(binding) {
            tvCategory.text = joke.category
            tvJokeQuestion.text = joke.question
            tvJokeAnswer.text = joke.answer
            root.setOnClickListener {
                clickListener(position)
            }
        }
    }
}