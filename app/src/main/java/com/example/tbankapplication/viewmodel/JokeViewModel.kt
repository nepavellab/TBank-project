package com.example.tbankapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.tbankapplication.database.Joke
import com.example.tbankapplication.database.JokeDatabase
import com.example.tbankapplication.server.JokeRepository
import kotlinx.coroutines.launch
import java.io.IOException

class JokeViewModel(application: Application) : AndroidViewModel(application) {
    private val _modelState = MutableLiveData(SingleState(
        jokeDB = Room.databaseBuilder(getApplication(),
            JokeDatabase::class.java,
            "joke-database").build(),
        screenState = ScreenState.SHOW_CONTENT))
    val modelState: LiveData<SingleState> = _modelState

    fun addJoke(joke: Joke) {
        viewModelScope.launch {
            val dao = _modelState.value?.jokeDB?.jokeDao()
            dao?.insert(joke)
            _modelState.value = _modelState.value?.copy(
                screenState = ScreenState.SHOW_CONTENT
            )
        }
    }

    fun loadJokes() {
        viewModelScope.launch {
            try {
                _modelState.postValue(_modelState.value?.copy(screenState = ScreenState.LOAD))
                val dao = _modelState.value?.jokeDB?.jokeDao()
                val jokesFromNet = JokeRepository.getJokes()
                dao?.insertJokes(jokesFromNet)
                _modelState.postValue(_modelState.value?.copy(
                    screenState = ScreenState.SHOW_CONTENT
                ))
            } catch (exception: IOException) {
                _modelState.postValue(_modelState.value?.copy(screenState = ScreenState.ERROR))
            }
        }
    }
}
