package com.example.tbankapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tbankapplication.databinding.JokeBinding

class JokeAdapter() : RecyclerView.Adapter<JokeViewHolder>() {
    private var jokes = listOf(
        Joke(
            category = "Категория",
            question = "Что сказал слепой, войдя в бар?",
            answer = "Всем привет, кого не видел"
        ),
        Joke(
            category = "Категория",
            question = "Почему среди фигуристов не бывает цыган?",
            answer = "Никто не верит что это их конёк"
        ),
        Joke(
            category = "Категория",
            question = "Как называется сборная Белоруссии по футболу?",
            answer = "Тима Белорусских"
        ),
        Joke(
            category = "Категория",
            question = "Почему в наше время Пушкин не пользовался бы интеренетом?",
            answer = "Он ненавидит переходить по ссылке"
        ),
        Joke(
            category = "Категория",
            question = "Чем отличается программист от политика?",
            answer = "Программисту платят деньги за работающие программы"
        ),
        Joke(
            category = "Категория",
            question = "Что делать, если на программиста после беседы с тестировщиком напал тигр?",
            answer = "Сам напал, пусть сам и защищается"
        ),
        Joke(
            category = "Категория",
            question = "Как называется человек с неоконченным высшим образованием?",
            answer = "Аль денте бакалавр"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        return JokeViewHolder(
            JokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = jokes.size

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(jokes[position])
    }
}