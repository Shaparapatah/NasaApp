package com.shaparapatah.nasaapp.view

import android.app.Application
import com.shaparapatah.nasaapp.R

class App : Application() {


    var currentTheme = R.style.Theme_NasaApp

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: App
    }
}