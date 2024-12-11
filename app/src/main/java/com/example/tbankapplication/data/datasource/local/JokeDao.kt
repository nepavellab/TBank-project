package com.example.tbankapplication.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tbankapplication.data.entity.NetworkJokeModel
import com.example.tbankapplication.data.entity.UserJokeModel
import com.example.tbankapplication.domain.entity.Joke

@Dao
interface JokeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addJoke(joke: UserJokeModel)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addJokesToCash(jokes: List<NetworkJokeModel>)
    @Query("SELECT * FROM jokes, network_cash")
    suspend fun getJokes(): List<Joke>
//    @Query("SELECT * FROM network_cash")
//    suspend fun getJokesFromCash(): List<NetworkJokeModel>
    @Query("DELETE FROM network_cash")
    suspend fun clearCash(): Unit
}