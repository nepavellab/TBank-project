package com.example.tbankapplication.data.datasource.local

import com.example.tbankapplication.domain.entity.Joke

interface LocalSource {
    suspend fun getAllJokes(): List<Joke>

    suspend fun addJoke(joke: Joke)

    suspend fun addJokesToCash(jokes: List<Joke>)

    suspend fun clearCash()
}