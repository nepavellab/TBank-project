package com.example.tbankapplication.data.datasource.remote

import com.example.tbankapplication.data.mapper.Mapper
import com.example.tbankapplication.domain.entity.Joke

class RemoteSourceImpl(
    private val api: JokeNetworkService
) : RemoteSource {
    override suspend fun loadJokes(): List<Joke> {
        val response = api.getJokes().body()!!
        val jokes = List(response.amount) { index ->
            response.jokes[index].let { jokeFromNetwork ->
                Mapper.networkResponseToJoke(jokeFromNetwork)
            }
        }
        return jokes
    }
}