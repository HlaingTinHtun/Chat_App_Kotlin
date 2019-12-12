package com.example.guri.Controllers

import android.app.Application
import com.example.guri.Utilities.SharedPrefs

class App : Application() {

    companion object{
        lateinit var  prefs: SharedPrefs
    }

    override fun onCreate() {
        prefs = SharedPrefs(applicationContext)
        super.onCreate()
    }

}