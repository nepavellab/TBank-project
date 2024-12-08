package com.example.tbankapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserJokeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(joke: Joke)
    @Query("SELECT * FROM jokes ORDER BY loadType DESC")
    suspend fun getAllJokes(): List<Joke>
}

@Dao
interface NetworkCashDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addJokesToCash(jokes: List<Cash>)
    @Query("SELECT * FROM network_cash ORDER BY loadType DESC")
    suspend fun getAllJokesFromCash(): List<Cash>
    @Query("DELETE FROM network_cash")
    suspend fun clearCash(): Unit
}