package com.example.tbankapplication.domain.entity

enum class LoadType {
    USER,
    NETWORK
}

data class Joke (
    val id: Int,
    val category: String,
    val question: String,
    val answer: String,
    val loadType: LoadType,
    val isFavourite: Boolean
)