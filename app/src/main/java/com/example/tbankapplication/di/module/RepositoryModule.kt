package com.example.tbankapplication.di.module

import com.example.tbankapplication.data.datasource.local.LocalSource
import com.example.tbankapplication.data.datasource.remote.RemoteSource
import com.example.tbankapplication.data.repository.JokeRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideRepository(
        localSource: LocalSource,
        remoteSource: RemoteSource
    ): JokeRepositoryImpl {
        return JokeRepositoryImpl(localSource, remoteSource)
    }
}