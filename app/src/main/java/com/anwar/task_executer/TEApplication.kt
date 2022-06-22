package com.anwar.task_executer

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class TEApplication : Application() {
    override fun onCreate() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate()
    }
}