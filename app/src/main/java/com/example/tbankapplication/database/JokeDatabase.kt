package com.example.tbankapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Joke::class], version=1)
abstract class JokeDatabase : RoomDatabase() {
    abstract fun jokeDao(): JokeDao
}