package com.example.tbankapplication.di

import android.content.Context
import com.example.tbankapplication.data.datasource.local.JokeDao
import com.example.tbankapplication.data.datasource.local.JokeDatabase
import com.example.tbankapplication.di.module.DatabaseModule
import com.example.tbankapplication.di.module.NetworkModule
import com.example.tbankapplication.presentation.activity.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        DatabaseModule::class
    ]
)
interface ApplicationComponent {
    fun getDatabaseInterface(): JokeDao

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}