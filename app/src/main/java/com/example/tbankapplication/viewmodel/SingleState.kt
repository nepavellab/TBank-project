package com.example.tbankapplication.viewmodel

import com.example.tbankapplication.database.JokeDatabase

enum class ScreenState {
    LOAD,
    ERROR,
    SHOW_CONTENT
}

data class SingleState(
    val jokeDB: JokeDatabase,
    val screenState: ScreenState
)
