package com.example.tbankapplication.presentation.viewmodel

import com.example.tbankapplication.domain.repository.JokeRepository

enum class ScreenState {
    LOAD,
    ERROR,
    SHOW_CONTENT
}

data class SingleState (
    val jokeRepository: JokeRepository,
    val screenState: ScreenState
)
