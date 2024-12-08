package com.example.tbankapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tbankapplication.database.Joke
import com.example.tbankapplication.database.JokeDatabase
import com.example.tbankapplication.server.JokeRepository
import kotlinx.coroutines.launch
import java.io.IOException

class JokeViewModel(application: Application) : AndroidViewModel(application) {
    private val _modelState = MutableLiveData(SingleState(
        jokeDB = JokeDatabase.getDataBaseInstance(getApplication()),
        screenState = ScreenState.SHOW_CONTENT))
    val jokeInterface = _modelState.value?.jokeDB?.getUserJokeDao()
    val cashInterface = _modelState.value?.jokeDB?.getNetworkCashDao()
    val modelState: LiveData<SingleState> = _modelState

    fun addJoke(joke: Joke) {
        viewModelScope.launch {
            jokeInterface?.insert(joke)
            _modelState.value = _modelState.value?.copy(
                screenState = ScreenState.SHOW_CONTENT
            )
        }
    }

    fun clearNetCash() {
        viewModelScope.launch {
            cashInterface?.clearCash()
            _modelState.value = _modelState.value?.copy(
                screenState = ScreenState.SHOW_CONTENT
            )
        }
    }

    fun loadJokes() {
        viewModelScope.launch {
            try {
                _modelState.postValue(_modelState.value?.copy(screenState = ScreenState.LOAD))
                val jokesFromNet = JokeRepository.getJokes()
                cashInterface?.addJokesToCash(jokesFromNet)
                _modelState.postValue(_modelState.value?.copy(
                    screenState = ScreenState.SHOW_CONTENT
                ))
            } catch (exception: IOException) {
                _modelState.postValue(_modelState.value?.copy(screenState = ScreenState.ERROR))
            }
        }
    }
}
