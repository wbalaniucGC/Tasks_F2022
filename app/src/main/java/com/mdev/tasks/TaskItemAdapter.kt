package com.mdev.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.mdev.tasks.databinding.TaskItemBinding

class TaskItemAdapter : ListAdapter<Task, TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallback()) {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int)
        : TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    // Inner class for my view holder
    class TaskItemViewHolder(val binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            // Create the TaskItemViewHolder (i.e. A single Task View used in the recycler)
            fun inflateFrom(parent: ViewGroup) : TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                // val view = layoutInflater.inflate(R.layout.task_item, parent, false) as CardView
                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)

                return TaskItemViewHolder(binding)
            }
        }

        fun bind(item: Task) {
            binding.task = item
        }
    }
}