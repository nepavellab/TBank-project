package com.example.tbankapplication.data.datasource.remote

import com.example.tbankapplication.data.entity.JokeNetworkModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeNetworkService {
    @GET("Any")
    suspend fun getJokes(
        @Query("type") type: String = "twopart",
        @Query("amount") amount: Int = 10
    ): Response<JokeNetworkModel>
}

object ApiBuilder {
    private const val BASE_URL = "https://v2.jokeapi.dev/joke/"

    fun getApiInstance(): JokeNetworkService = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokeNetworkService::class.java)
}