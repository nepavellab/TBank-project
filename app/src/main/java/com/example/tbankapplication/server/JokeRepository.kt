package com.example.tbankapplication.server

import com.example.tbankapplication.database.Cash
import com.example.tbankapplication.database.LoadType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JokeRepository {
    private const val BASE_URL = "https://v2.jokeapi.dev/joke/"
    private val api = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(JokeService::class.java)

    suspend fun getJokes(): List<Cash> {
        val response = api.getJokes()
        val responseBody = response.body()!!
        val jokes = List(responseBody.amount) { index ->
            with (responseBody.jokes[index]) {
                Cash(
                    id = id,
                    category = category,
                    answer = delivery,
                    question = setup,
                    loadType = LoadType.NETWORK
                )
            }
        }
        return jokes
    }
}