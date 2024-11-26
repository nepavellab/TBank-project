package com.example.tbankapplication.viewmodel

import com.example.tbankapplication.data.Joke

enum class ScreenState {
    LOAD,
    ERROR,
    SHOW_CONTENT
}

enum class LoadType {
    USER,
    NETWORK
}

data class SingleState(
    val jokeList: List<Joke> = emptyList(),
    val loadType: LoadType = LoadType.NETWORK,
    val screenState: ScreenState = ScreenState.SHOW_CONTENT
)
