package ru.bellintegrator.android_at_lesson_2.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import ru.bellintegrator.android_at_lesson_2.Task
import ru.bellintegrator.android_at_lesson_2.TaskListAdapter
import ru.bellintegrator.android_at_lesson_2.TaskViewModel
import ru.bellintegrator.android_at_lesson_2.databinding.ActivityTaskBinding

class TaskActivity : AppCompatActivity(), TaskListAdapter.OnTaskClickListener {
    private lateinit var binding: ActivityTaskBinding
    private lateinit var adapter: TaskListAdapter
    private lateinit var viewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupViewModel()
        setupAddButton()
    }

    private fun setupRecyclerView() {
        adapter = TaskListAdapter(this)
        binding.taskList.layoutManager = LinearLayoutManager(this)
        binding.taskList.adapter = adapter
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[TaskViewModel::class.java]
        viewModel.allTasks.observe(
            this,
            Observer { tasks ->
                Log.d("MainActivity", "Received tasks: $tasks")
                adapter.setTasks(tasks)
            },
        )
    }

    private fun setupAddButton() {
        binding.addButton.setOnClickListener {
            showAddTaskDialog()
        }
    }

    private fun showAddTaskDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Добавить задачу")
            .setPositiveButton("Добавить") { _, _ ->
                addNewTask()
            }
            .setNegativeButton("Отмена", null)
            .show()
    }

    private fun addNewTask() {
        val title = binding.titleInput.text.toString().trim()
        val description = binding.descriptionInput.text.toString().trim()

        if (title.isNotBlank()) {
            val newTask = Task(title = title, description = description)
            viewModel.insert(newTask)
            clearInputs()
        }
    }

    private fun clearInputs() {
        binding.titleInput.text.clear()
        binding.descriptionInput.text.clear()
    }

    override fun onDeleteClicked(task: Task) {
        viewModel.delete(task)
    }

    override fun onEditClicked(task: Task) {
        showEditTaskDialog(task)
    }

    private fun showEditTaskDialog(task: Task) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Редактирование задачи")
            .setMessage("Измените название или описание задачи:")
            .setPositiveButton("Обновить") { _, _ ->
                updateTask(task)
            }
            .setNegativeButton("Отмена", null)
            .show()
    }

    private fun updateTask(task: Task) {
        val updatedTitle = binding.titleInput.text.toString().trim()
        val updatedDescription = binding.descriptionInput.text.toString().trim()

        if (updatedTitle.isNotBlank()) {
            task.title = updatedTitle
            task.description = updatedDescription
            viewModel.update(task)
            clearInputs()
        }
    }
}
