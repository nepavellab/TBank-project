package com.example.tbankapplication.viewmodel

import com.example.tbankapplication.data.Joke

enum class ScreenState {
    LOAD,
    ERROR,
    SHOW_CONTENT
}

data class SingleState(
    val jokeList: List<Joke> = emptyList(),
    val screenState: ScreenState = ScreenState.SHOW_CONTENT
)
