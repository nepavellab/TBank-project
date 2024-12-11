package com.example.tbankapplication.data.datasource.remote

import com.example.tbankapplication.domain.entity.Joke

interface RemoteSource {
    suspend fun loadJokes(): List<Joke>
}