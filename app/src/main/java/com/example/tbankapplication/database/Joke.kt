package com.example.tbankapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

enum class LoadType {
    USER,
    NETWORK
}

@Entity(tableName = "jokes")
data class Joke (
    @PrimaryKey
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("category")
    val category: String,
    @ColumnInfo("question")
    val question: String,
    @ColumnInfo("answer")
    val answer: String,
    @ColumnInfo("loadType")
    val loadType: LoadType
)

@Entity(tableName = "network_cash")
data class Cash(
    @PrimaryKey
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("category")
    val category: String,
    @ColumnInfo("question")
    val question: String,
    @ColumnInfo("answer")
    val answer: String,
    @ColumnInfo("loadType")
    val loadType: LoadType
)