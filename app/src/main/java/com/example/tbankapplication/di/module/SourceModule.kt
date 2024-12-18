package com.example.tbankapplication.di.module

import com.example.tbankapplication.data.datasource.local.JokeDao
import com.example.tbankapplication.data.datasource.local.LocalSource
import com.example.tbankapplication.data.datasource.local.LocalSourceImpl
import com.example.tbankapplication.data.datasource.remote.JokeNetworkService
import com.example.tbankapplication.data.datasource.remote.RemoteSource
import com.example.tbankapplication.data.datasource.remote.RemoteSourceImpl
import dagger.Module
import dagger.Provides

@Module
class SourceModule {
    @Provides
    fun provideLocalSource(databaseInterface: JokeDao): LocalSource {
        return LocalSourceImpl(databaseInterface)
    }

    @Provides
    fun provideRemoteSource(api: JokeNetworkService): RemoteSource {
        return RemoteSourceImpl(api)
    }
}