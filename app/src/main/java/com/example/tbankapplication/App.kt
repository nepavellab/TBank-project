package com.example.tbankapplication

import android.app.Application
import com.example.tbankapplication.di.ApplicationComponent

class App : Application() {
    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.create()
    }
}