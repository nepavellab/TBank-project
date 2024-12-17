package com.example.tbankapplication.di.module

import android.content.Context
import androidx.room.Room
import com.example.tbankapplication.data.datasource.local.JokeDao
import com.example.tbankapplication.data.datasource.local.JokeDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    private companion object {
        private const val DATABASE_NAME = "joke-database"
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): JokeDao {
        return Room.databaseBuilder(context, JokeDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
            .getJokeDao()
    }
}