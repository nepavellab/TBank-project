package com.example.tbankapplication.data.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tbankapplication.data.entity.FavouriteJokeModel
import com.example.tbankapplication.data.entity.NetworkJokeModel
import com.example.tbankapplication.data.entity.UserJokeModel

@Dao
interface JokeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addJoke(joke: UserJokeModel)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addJokesToCash(jokes: List<NetworkJokeModel>)
    @Query("SELECT * FROM jokes")
    suspend fun getNetCashJokes(): List<NetworkJokeModel>
    @Query("SELECT * FROM network_cash")
    suspend fun getUserJokes(): List<UserJokeModel>
    @Query("SELECT * FROM favourite")
    suspend fun getFavouriteJokes(): List<FavouriteJokeModel>
    @Query("DELETE FROM network_cash")
    suspend fun clearCash()
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavourite(joke: FavouriteJokeModel)
    @Delete
    suspend fun deleteFavourite(joke: FavouriteJokeModel)
}