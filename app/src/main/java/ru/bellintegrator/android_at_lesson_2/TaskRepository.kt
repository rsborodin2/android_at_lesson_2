package ru.bellintegrator.android_at_lesson_2

import androidx.lifecycle.LiveData
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class TaskRepository(private val taskDao: TaskDao, private val ioDispatcher: CoroutineContext) {
    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks()

    suspend fun insert(task: Task) {
        withContext(ioDispatcher) {
            taskDao.insert(task)
        }
    }

    suspend fun update(task: Task) {
        withContext(ioDispatcher) {
            taskDao.update(task)
        }
    }

    suspend fun delete(task: Task) {
        withContext(ioDispatcher) {
            taskDao.delete(task)
        }
    }
}
