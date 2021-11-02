package com.example.android.architecture.blueprints.todoapp.data.source.local

import android.content.Context
import androidx.room.Room
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DataBaseFactory @Inject constructor(
    @ApplicationContext private val context: Context
) {

    fun createDataBase(): ToDoDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            ToDoDatabase::class.java, "Tasks.db"
        ).build()
    }
}