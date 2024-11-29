package com.example.tbankapplication.server

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeService {
    @GET("Any")
    suspend fun getJokes(
        @Query("type") type: String = "twopart",
        @Query("amount") amount: Int = 10
    ): Response<JokeResponse>
}