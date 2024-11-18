package com.example.tbankapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tbankapplication.data.Data
import com.example.tbankapplication.data.Joke
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlin.coroutines.EmptyCoroutineContext

class JokeViewModel : ViewModel() {
    val jokeList = MutableLiveData(Data.jokes)

    suspend fun update(joke: Joke) {
        Data.jokes.add(joke)
        val scope = CoroutineScope(EmptyCoroutineContext)

        val deffer = scope.async(Dispatchers.IO) { // имитируем выгрузку данных
            delay(3000L)
            Data.jokes
        }

        jokeList.postValue(deffer.await())
    }
}
