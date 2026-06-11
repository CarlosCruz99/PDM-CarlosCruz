package com.example.laboratorio_5_carlos_cruz

import android.app.Application
import com.example.laboratorio_5_carlos_cruz.data.local.AppDatabase

class TaskApp : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
}