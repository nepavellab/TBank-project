package com.example.tbankapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tbankapplication.data.Joke

class JokeViewModel : ViewModel() {
    private val _jokeList = MutableLiveData<MutableList<Joke>>(mutableListOf())
    val jokeList: LiveData<MutableList<Joke>> = _jokeList

    fun addItem(joke: Joke) = _jokeList.value?.add(joke)
}
