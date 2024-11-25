package com.example.tbankapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tbankapplication.data.Data
import com.example.tbankapplication.data.Joke
import com.example.tbankapplication.server.JokeRepository
import kotlinx.coroutines.launch
import java.io.IOException

class JokeViewModel : ViewModel() {
    val jokeList = MutableLiveData(Data.jokes)
    val isError = MutableLiveData(false)
    val userAdd = MutableLiveData<Joke>()
    val isLoad = MutableLiveData(false)

    fun update(joke: Joke) {
        Data.jokes.add(joke)
        jokeList.value?.add(joke)
        userAdd.value = joke
    }

    fun loadJokes() {
        viewModelScope.launch {
            try {
                isLoad.postValue(true)
                val jokesFromNet = JokeRepository.getJokes()
                Data.jokes.addAll(jokesFromNet)
                jokeList.value = Data.jokes
            } catch (exception: IOException) {
                isError.postValue(true)
            } finally {
                isLoad.postValue(false)
            }
        }
    }
}
