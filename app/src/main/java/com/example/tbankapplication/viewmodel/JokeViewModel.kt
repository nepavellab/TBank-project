package com.example.tbankapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tbankapplication.data.Data
import com.example.tbankapplication.data.Joke
import com.example.tbankapplication.server.JokeRepository
import kotlinx.coroutines.launch
import java.io.IOException

class JokeViewModel : ViewModel() {
    private val _modelState = MutableLiveData(SingleState())
    val modelState: LiveData<SingleState> = _modelState

    fun update(joke: Joke) {
        Data.jokes.add(joke)
        _modelState.value = _modelState.value?.copy(
            jokeList = Data.jokes,
            loadType = LoadType.USER,
            ScreenState.SHOW_CONTENT
        )
    }

    fun loadJokes() {
        viewModelScope.launch {
            try {
                _modelState.postValue(_modelState.value?.copy(screenState = ScreenState.LOAD))
                val jokesFromNet = JokeRepository.getJokes()
                Data.jokes.addAll(jokesFromNet)
                _modelState.postValue(_modelState.value?.copy(
                    jokeList = Data.jokes,
                    loadType = LoadType.NETWORK,
                    ScreenState.SHOW_CONTENT
                ))
            } catch (exception: IOException) {
                _modelState.postValue(_modelState.value?.copy(screenState = ScreenState.ERROR))
            }
        }
    }
}
