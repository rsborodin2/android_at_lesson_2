package ru.bellintegrator.android_at_lesson_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.bellintegrator.android_at_lesson_2.databinding.TaskItemBinding

class TaskListAdapter(private val listener: OnTaskClickListener) :
    RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    private var tasks = emptyList<Task>()

    inner class TaskViewHolder(private val binding: TaskItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(task: Task) {
            binding.titleText.text = task.title
            binding.descriptionText.text = task.description
            binding.editButton.setOnClickListener {
                listener.onEditClicked(task)
            }
            binding.deleteButton.setOnClickListener {
                listener.onDeleteClicked(task)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = TaskItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size

    fun setTasks(tasks: List<Task>) {
        this.tasks = tasks
        notifyDataSetChanged()
    }

    interface OnTaskClickListener {
        fun onEditClicked(task: Task)
        fun onDeleteClicked(task: Task)
    }
}