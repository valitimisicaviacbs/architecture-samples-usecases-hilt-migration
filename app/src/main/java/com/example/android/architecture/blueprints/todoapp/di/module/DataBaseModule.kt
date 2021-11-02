package com.example.android.architecture.blueprints.todoapp.di.module

import com.example.android.architecture.blueprints.todoapp.data.source.local.DataBaseFactory
import com.example.android.architecture.blueprints.todoapp.data.source.local.TasksDao
import com.example.android.architecture.blueprints.todoapp.data.source.local.ToDoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(dataBaseFactory: DataBaseFactory): ToDoDatabase =
        dataBaseFactory.createDataBase()


    @Provides
    @Singleton
    fun provideTasksDao(
        database: ToDoDatabase
    ): TasksDao = database.taskDao()
}