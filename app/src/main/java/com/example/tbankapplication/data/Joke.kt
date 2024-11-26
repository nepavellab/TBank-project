package com.example.tbankapplication.data

enum class LoadType {
    USER,
    NETWORK
}

data class Joke(
    val id: Int,
    val category: String,
    val question: String,
    val answer: String,
    val loadType: LoadType
)