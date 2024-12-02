package com.example.tbankapplication.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Query

@Dao
interface JokeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(joke: Joke)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertJokes(jokes: List<Joke>)
    @Update
    suspend fun update(joke: Joke)
    @Delete
    suspend fun delete(joke: Joke)
    @Query("SELECT * FROM jokes")
    suspend fun getJokes(): List<Joke>
}