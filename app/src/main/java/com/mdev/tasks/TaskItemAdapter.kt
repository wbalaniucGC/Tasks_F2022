package com.mdev.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class TaskItemAdapter : RecyclerView.Adapter<TaskItemAdapter.TaskItemViewHolder>() {
    var data = listOf<Task>()       // List of tasks to be displayed
    set (value) {
        field = value
        notifyDataSetChanged()      // Notify that by list of tasks has changed
    }

    override fun getItemCount() = data.size // Return the number of tasks

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int)
        : TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    // Inner class for my view holder
    class TaskItemViewHolder(val rootView : CardView) : RecyclerView.ViewHolder(rootView) {

        // Reference the layout's textview and checkbox
        val taskName = rootView.findViewById<TextView>(R.id.task_name)
        val taskDone = rootView.findViewById<CheckBox>(R.id.task_done)

        companion object {
            // Create the TaskItemViewHolder (i.e. A single Task View used in the recycler)
            fun inflateFrom(parent: ViewGroup) : TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.task_item, parent, false) as CardView

                return TaskItemViewHolder(view)
            }
        }

        fun bind(item: Task) {
            taskName.text = item.taskName
            taskDone.isChecked = item.taskDone
        }
    }
}