package com.example.tbankapplication.data.datasource.local

import com.example.tbankapplication.data.mapper.Mapper
import com.example.tbankapplication.domain.entity.Joke

class LocalSourceImpl(
    private val databaseInterface: JokeDao
) : LocalSource {
    override suspend fun getAllJokes(): List<Joke> {
        return databaseInterface.getJokes()
    }

    override suspend fun addJoke(joke: Joke) {
        databaseInterface.addJoke(Mapper.jokeToUserDBModel(joke))
    }

    override suspend fun addJokesToCash(jokes: List<Joke>) {
        val netModelJokes = List(jokes.size) { index ->
            Mapper.jokeToNetworkDBModel(jokes[index])
        }
        databaseInterface.addJokesToCash(netModelJokes)
    }

    override suspend fun clearCash() {
        databaseInterface.clearCash()
    }
}