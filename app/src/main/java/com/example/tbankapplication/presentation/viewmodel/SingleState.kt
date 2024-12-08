package com.example.tbankapplication.presentation.viewmodel

import com.example.tbankapplication.data.repository.JokeRepositoryImpl

enum class ScreenState {
    LOAD,
    ERROR,
    SHOW_CONTENT
}

data class SingleState(
    val jokeRepository: JokeRepositoryImpl,
    val screenState: ScreenState
)
