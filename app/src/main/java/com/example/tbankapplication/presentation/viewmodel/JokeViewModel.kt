package com.example.tbankapplication.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tbankapplication.domain.entity.Joke
import com.example.tbankapplication.data.datasource.local.JokeDatabase
import com.example.tbankapplication.data.datasource.local.LocalSourceImpl
import com.example.tbankapplication.data.datasource.remote.ApiBuilder
import com.example.tbankapplication.data.datasource.remote.RemoteSourceImpl
import com.example.tbankapplication.data.repository.JokeRepositoryImpl
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class JokeViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {
    private val _modelState = MutableLiveData(
        SingleState(
            jokeRepository = JokeRepositoryImpl(
                LocalSourceImpl(JokeDatabase.getDataBaseInstance(
                    getApplication()
                ).getJokeDao()),
                RemoteSourceImpl(ApiBuilder.getApiInstance())
            ),
            screenState = ScreenState.SHOW_CONTENT
        )
    )
    val modelState: LiveData<SingleState> = _modelState

    fun addJoke(joke: Joke) {
        viewModelScope.launch {
            _modelState.value?.jokeRepository?.addJoke(joke)
            _modelState.value = _modelState.value?.copy(
                screenState = ScreenState.SHOW_CONTENT
            )
        }
    }

    fun clearNetCash() {
        viewModelScope.launch {
            _modelState.value?.jokeRepository?.clearNetCash()
            _modelState.value = _modelState.value?.copy(
                screenState = ScreenState.SHOW_CONTENT
            )
        }
    }

    fun loadJokes() {
        viewModelScope.launch {
            try {
                _modelState.postValue(_modelState.value?.copy(screenState = ScreenState.LOAD))
                val jokesFromNet = _modelState.value?.jokeRepository?.loadJokes()!!
                _modelState.value?.jokeRepository?.addJokesToCash(jokesFromNet)
                _modelState.postValue(_modelState.value?.copy(
                    screenState = ScreenState.SHOW_CONTENT
                ))
            } catch (exception: IOException) {
                _modelState.postValue(_modelState.value?.copy(screenState = ScreenState.ERROR))
            }
        }
    }

    fun addFavourite(joke: Joke) {
        viewModelScope.launch {
            _modelState.value?.jokeRepository?.addFavourite(joke)
            _modelState.postValue(_modelState.value?.copy(
                screenState = ScreenState.SHOW_CONTENT
            ))
        }
    }

    fun deleteFavourite(joke: Joke) {
        viewModelScope.launch {
            modelState.value?.jokeRepository?.deleteFavourite(joke)
            _modelState.postValue(_modelState.value?.copy(
                screenState = ScreenState.SHOW_CONTENT
            ))
        }
    }
}
