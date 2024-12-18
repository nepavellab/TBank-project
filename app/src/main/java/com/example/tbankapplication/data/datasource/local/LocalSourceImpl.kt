package com.example.tbankapplication.data.datasource.local

import com.example.tbankapplication.data.mapper.Mapper
import com.example.tbankapplication.domain.entity.Joke
import javax.inject.Inject

class LocalSourceImpl @Inject constructor(
    private val databaseInterface: JokeDao
) : LocalSource {
    override suspend fun getAllJokes(): List<Joke> {
        val userJokes = databaseInterface.getUserJokes().map { joke ->
            Mapper.userDBModelToJoke(joke)
        }
        val netCashJokes = databaseInterface.getNetCashJokes().map { joke ->
            Mapper.networkDBModelToJoke(joke)
        }
        return userJokes + netCashJokes
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

    override suspend fun addFavourite(joke: Joke) {
        databaseInterface.addFavourite(Mapper.jokeToFavouriteDBModel(
            joke.copy(isFavourite = true)
        ))
    }

    override suspend fun deleteFavourite(joke: Joke) {
        databaseInterface.deleteFavourite(Mapper.jokeToFavouriteDBModel(
            joke.copy(isFavourite = true)
        ))
    }
}