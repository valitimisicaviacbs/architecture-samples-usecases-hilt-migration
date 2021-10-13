package com.example.android.architecture.blueprints.todoapp.domain

import android.util.Log
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository
import com.example.android.architecture.blueprints.todoapp.util.wrapEspressoIdlingResource

class ActivateTaskUseCase(
    private val tasksRepository: TasksRepository
) {
    suspend operator fun invoke(task: Task) {

        Log.d("asdas","s")
        wrapEspressoIdlingResource {
            tasksRepository.activateTask(task)
        }
    }
}