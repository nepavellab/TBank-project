package com.example.tbankapplication.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tbankapplication.domain.entity.LoadType

@Entity(tableName = "jokes")
data class UserJokeModel (
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
data class NetworkJokeModel(
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