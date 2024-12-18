package com.example.tbankapplication.di.module

import com.example.tbankapplication.data.datasource.remote.JokeNetworkService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    private companion object {
        private const val BASE_URL = "https://v2.jokeapi.dev/joke/"
    }

    @Provides
    @Singleton
    fun provideNetworkInterface(): JokeNetworkService {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokeNetworkService::class.java)
    }
}