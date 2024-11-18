package com.example.tbankapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tbankapplication.data.Data
import com.example.tbankapplication.data.Joke

class JokeViewModel : ViewModel() {
    val jokeList = MutableLiveData(Data.jokes)

    fun update(joke: Joke) {
        Data.jokes.add(joke)
        jokeList.value = Data.jokes
    }
}
