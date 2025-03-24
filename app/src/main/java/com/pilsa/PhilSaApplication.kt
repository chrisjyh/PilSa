package com.pilsa

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PhilSaApplication () : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("Philsa", "entry")
    }
}