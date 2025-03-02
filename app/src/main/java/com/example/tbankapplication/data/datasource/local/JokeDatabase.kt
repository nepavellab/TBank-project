package com.example.tbankapplication.data.datasource.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tbankapplication.data.entity.FavouriteJokeModel
import com.example.tbankapplication.data.entity.NetworkJokeModel
import com.example.tbankapplication.data.entity.UserJokeModel

@Database(entities = [
        UserJokeModel::class,
        NetworkJokeModel::class,
        FavouriteJokeModel::class
    ], version=3)
abstract class JokeDatabase : RoomDatabase() {
    companion object {
        private const val DATABASE_NAME = "joke-database"

        fun getDataBaseInstance(application: Application): JokeDatabase {
            return Room.databaseBuilder(application,
                JokeDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
    abstract fun getJokeDao(): JokeDao
}