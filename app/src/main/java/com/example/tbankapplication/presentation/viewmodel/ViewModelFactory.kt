package com.example.tbankapplication.presentation.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val appContext: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JokeViewModel::class.java)) {
            return JokeViewModel(appContext.applicationContext as Application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
