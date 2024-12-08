package com.example.tbankapplication.data.repository

import com.example.tbankapplication.data.datasource.local.LocalSourceImpl
import com.example.tbankapplication.data.datasource.remote.RemoteSourceImpl
import com.example.tbankapplication.domain.entity.Joke
import com.example.tbankapplication.domain.repository.JokeRepository

class JokeRepositoryImpl(
    private val localSource: LocalSourceImpl,
    private val remoteSource: RemoteSourceImpl
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
}