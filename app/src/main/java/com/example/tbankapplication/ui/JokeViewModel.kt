package com.example.tbankapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tbankapplication.data.Joke

class JokeViewModel : ViewModel() {
    private val _jokeList = MutableLiveData<List<Joke>>()
    val jokeList: LiveData<List<Joke>> = _jokeList

    init {
        _jokeList.value = Data.jokes
    }
}
