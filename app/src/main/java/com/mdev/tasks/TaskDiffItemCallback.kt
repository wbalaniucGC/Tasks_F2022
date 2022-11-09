package com.mdev.tasks

import androidx.recyclerview.widget.DiffUtil

class TaskDiffItemCallback : DiffUtil.ItemCallback<Task>() {

    override fun areItemsTheSame(oldItem: Task, newItem: Task) = (oldItem.taskID == newItem.taskID)

    override fun areContentsTheSame(oldItem: Task, newItem: Task) = (oldItem == newItem)
}