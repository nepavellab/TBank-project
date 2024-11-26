package com.example.tbankapplication.ui.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.tbankapplication.data.Joke
import com.example.tbankapplication.data.LoadType
import com.example.tbankapplication.databinding.JokeBinding

class JokeViewHolder(
    private val binding: JokeBinding
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        private const val LOAD_BY_USER = "Добавлено пользователем"
        private const val LOAD_FROM_NET = "Загружено по сети"
    }

    fun bind(joke: Joke, clickListener: (Int) -> Int, position: Int) {
        with(binding) {
            tvCategory.text = joke.category
            tvJokeQuestion.text = joke.question
            tvJokeAnswer.text = joke.answer
            tvLoadType.text = when(joke.loadType) {
                LoadType.USER -> LOAD_BY_USER
                LoadType.NETWORK -> LOAD_FROM_NET
            }
            root.setOnClickListener {
                clickListener(position)
            }
        }
    }
}