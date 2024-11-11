package com.example.tbankapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tbankapplication.data.Joke

class JokeViewModel : ViewModel() {
    private val _jokeList = MutableLiveData<List<Joke>>()
    val jokeList: LiveData<List<Joke>> = _jokeList

    init {
        _jokeList.value = listOf(
            Joke(
                id = 1,
                category = "Категория",
                question = "Что сказал слепой, войдя в бар?",
                answer = "Всем привет, кого не видел"
            ),
            Joke(
                id = 2,
                category = "Категория",
                question = "Почему среди фигуристов не бывает цыган?",
                answer = "Никто не верит что это их конёк"
            ),
            Joke(
                id = 3,
                category = "Категория",
                question = "Как называется сборная Белоруссии по футболу?",
                answer = "Тима Белорусских"
            ),
            Joke(
                id = 4,
                category = "Категория",
                question = "Почему в наше время Пушкин не пользовался бы интеренетом?",
                answer = "Он ненавидит переходить по ссылке"
            ),
            Joke(
                id = 5,
                category = "Категория",
                question = "Чем отличается программист от политика?",
                answer = "Программисту платят деньги за работающие программы"
            ),
            Joke(
                id = 6,
                category = "Категория",
                question = "Что делать, если на программиста после беседы с тестировщиком напал тигр?",
                answer = "Сам напал, пусть сам и защищается"
            ),
            Joke(
                id = 7,
                category = "Категория",
                question = "Как называется человек с неоконченным высшим образованием?",
                answer = "Аль денте бакалавр"
            )
        )
    }
}