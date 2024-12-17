package com.example.tbankapplication.di

import com.example.tbankapplication.data.repository.JokeRepositoryImpl
import com.example.tbankapplication.di.module.DatabaseModule
import com.example.tbankapplication.di.module.NetworkModule
import com.example.tbankapplication.di.module.RepositoryModule
import com.example.tbankapplication.di.module.SourceModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        DatabaseModule::class,
        SourceModule::class,
        RepositoryModule::class
    ]
)
interface ApplicationComponent {
    fun getRepository(): JokeRepositoryImpl
}