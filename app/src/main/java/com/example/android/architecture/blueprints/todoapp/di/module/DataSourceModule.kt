package com.example.android.architecture.blueprints.todoapp.di.module

import com.example.android.architecture.blueprints.todoapp.data.FakeTasksRemoteDataSource
import com.example.android.architecture.blueprints.todoapp.data.source.DefaultTasksRepository
import com.example.android.architecture.blueprints.todoapp.data.source.TasksDataSource
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository
import com.example.android.architecture.blueprints.todoapp.data.source.local.TasksLocalDataSource
import com.example.android.architecture.blueprints.todoapp.di.qualifier.LocalDataSource
import com.example.android.architecture.blueprints.todoapp.di.qualifier.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    companion object {
        @Provides
        @RemoteDataSource
        fun provideFakeTasksRemoteDataSource():TasksDataSource = FakeTasksRemoteDataSource
    }

    @Binds
    @LocalDataSource
    abstract fun bindLocalDataSource(impl: TasksLocalDataSource): TasksDataSource

    @Binds
    abstract fun provideTaskRepository(
        defaultTasksRepository: DefaultTasksRepository
    ): TasksRepository
}