package com.example.tbankapplication.data.repository

import com.example.tbankapplication.data.datasource.local.LocalSource
import com.example.tbankapplication.data.datasource.remote.RemoteSource
import com.example.tbankapplication.domain.entity.Joke
import com.example.tbankapplication.domain.repository.JokeRepository
import javax.inject.Inject

class JokeRepositoryImpl @Inject constructor(
    private val localSource: LocalSource,
    private val remoteSource: RemoteSource
): JokeRepository {
    override suspend fun getJokes(): List<Joke> {
        return localSource.getAllJokes().ifEmpty {
            val netJokes = loadJokes()
            localSource.addJokesToCash(netJokes)
            netJokes
        }
    }

    override suspend fun loadJokes(): List<Joke> {
        return remoteSource.loadJokes()
    }

    override suspend fun clearNetCash() {
        localSource.clearCash()
    }

    override suspend fun addJoke(joke: Joke) {
        localSource.addJoke(joke)
    }

    override suspend fun addJokesToCash(jokes: List<Joke>) {
        localSource.addJokesToCash(jokes)
    }

    override suspend fun addFavourite(joke: Joke) {
        localSource.addFavourite(joke)
    }

    override suspend fun deleteFavourite(joke: Joke) {
        localSource.deleteFavourite(joke)
    }
}