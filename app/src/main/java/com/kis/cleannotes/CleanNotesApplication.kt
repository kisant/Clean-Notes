package com.kis.cleannotes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class CleanNotesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}