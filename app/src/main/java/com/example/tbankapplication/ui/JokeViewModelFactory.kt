package com.example.tbankapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class JokeViewModelFactory : ViewModelProvider.Factory {
    override fun<T : ViewModel> create(modelClass: Class<T>) : T {
        return when {
            modelClass.isAssignableFrom(JokeViewModel::class.java) -> {
                JokeViewModel() as T
            }
            else -> throw IllegalArgumentException("Неизвестная ViewModel")
        }
    }
}