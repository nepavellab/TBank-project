package com.example.tbankapplication.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Joke::class, Cash::class], version=2)
abstract class JokeDatabase : RoomDatabase() {
    companion object {
        fun getDataBaseInstance(application: Application): JokeDatabase {
            return Room.databaseBuilder(application,
                JokeDatabase::class.java,
                "joke-database")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
    abstract fun getUserJokeDao(): UserJokeDao
    abstract fun getNetworkCashDao(): NetworkCashDao
}