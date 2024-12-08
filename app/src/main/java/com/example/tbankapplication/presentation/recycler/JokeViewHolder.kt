package com.example.tbankapplication.presentation.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.tbankapplication.domain.entity.Joke
import com.example.tbankapplication.domain.entity.LoadType
import com.example.tbankapplication.databinding.JokeBinding

class JokeViewHolder(
    private val binding: JokeBinding
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        private const val LOAD_BY_USER = "Добавлено пользователем"
        private const val LOAD_FROM_NET = "Загружено по сети"
    }

    fun bind(joke: Joke, openJokeCallback: (Joke) -> Unit) {
        with(binding) {
            tvCategory.text = joke.category
            tvJokeQuestion.text = joke.question
            tvJokeAnswer.text = joke.answer
            tvLoadType.text = when(joke.loadType) {
                LoadType.USER -> LOAD_BY_USER
                LoadType.NETWORK -> LOAD_FROM_NET
            }
            root.setOnClickListener { openJokeCallback(joke) }
        }
    }
}