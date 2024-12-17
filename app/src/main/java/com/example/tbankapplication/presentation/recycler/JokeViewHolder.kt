package com.example.tbankapplication.presentation.recycler

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.tbankapplication.R
import com.example.tbankapplication.domain.entity.Joke
import com.example.tbankapplication.domain.entity.LoadType
import com.example.tbankapplication.databinding.JokeBinding
import javax.inject.Inject

class JokeViewHolder @Inject constructor(
    private val binding: JokeBinding
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        private const val CATEGORY_TEXT = "Категория: "
        private const val LOAD_TYPE_TEXT = "Тип загрузки: "
        private const val LOAD_BY_USER = "Добавлено пользователем"
        private const val LOAD_FROM_NET = "Загружено по сети"
    }

    @SuppressLint("SetTextI18n")
    fun bind(joke: Joke,
             openJokeCallback: (Joke) -> Unit,
             attachFavourite: (Joke) -> Unit) {
        with(binding) {
            tvCategory.text = CATEGORY_TEXT + joke.category
            tvJokeQuestion.text = joke.question
            tvJokeAnswer.text = joke.answer
            tvLoadType.text = LOAD_TYPE_TEXT + when(joke.loadType) {
                LoadType.USER -> LOAD_BY_USER
                LoadType.NETWORK -> LOAD_FROM_NET
            }
            if (joke.isFavourite) {
                ibFavourite.setImageResource(R.drawable.favor_icon)
            } else {
                ibFavourite.setImageResource(R.drawable.not_favor_icon)
            }
            ibFavourite.setOnClickListener { attachFavourite(joke) }
            root.setOnClickListener { openJokeCallback(joke) }
        }
    }
}