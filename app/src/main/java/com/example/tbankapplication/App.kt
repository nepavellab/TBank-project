package com.example.tbankapplication

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerApplicationComponent.create(this)
    }
}