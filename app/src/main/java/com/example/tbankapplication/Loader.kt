package com.example.tbankapplication

import com.example.tbankapplication.data.Joke

interface Loader {
    fun onTapCallback(joke: Joke)
    fun onLoadCallback()
    fun addJokeCallback(joke: Joke)
    fun addJokeScreenCallback()
}