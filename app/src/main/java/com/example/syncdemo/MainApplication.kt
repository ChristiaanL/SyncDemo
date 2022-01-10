package com.example.syncdemo

import android.app.Application
import android.util.Log
import com.example.syncdemo.database.FibRequestRoomDatabase
import com.example.syncdemo.helpers.DBHelper

open class MainApplication : Application() {
    val database by lazy { FibRequestRoomDatabase.getDatabase(this) }

    override fun onCreate() {
        super.onCreate()
        instance  = this
        Log.i("MainApplication", "Inside Main Application")
    }

    companion object {
        lateinit var instance: MainApplication
            private set
    }
}