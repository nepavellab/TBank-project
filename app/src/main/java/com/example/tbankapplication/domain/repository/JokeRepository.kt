package com.example.tbankapplication.domain.repository

import com.example.tbankapplication.domain.entity.Joke

interface JokeRepository {
    suspend fun getJokes(): List<Joke>

    suspend fun clearNetCash()

    suspend fun addJoke(joke: Joke)

    suspend fun loadJokes(): List<Joke>

    suspend fun addJokesToCash(jokes: List<Joke>)
}