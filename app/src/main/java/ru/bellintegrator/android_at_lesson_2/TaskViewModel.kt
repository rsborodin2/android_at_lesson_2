package ru.bellintegrator.android_at_lesson_2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.bellintegrator.android_at_lesson_2.database.TaskDatabase

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TaskRepository
    val allTasks: LiveData<List<Task>>

    init {
        val taskDao = TaskDatabase.getInstance(application).taskDao()
        repository = TaskRepository(taskDao, viewModelScope.coroutineContext)
        allTasks = repository.allTasks
    }

    fun insert(task: Task) =
        viewModelScope.launch {
            repository.insert(task)
        }

    fun update(task: Task) =
        viewModelScope.launch {
            repository.update(task)
        }

    fun delete(task: Task) =
        viewModelScope.launch {
            repository.delete(task)
        }
}
