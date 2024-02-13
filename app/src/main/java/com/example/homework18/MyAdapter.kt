package com.example.homework18

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MyAdapter: ListAdapter<TaskModel, MyAdapter.MyViewHolder>(TaskDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = getItem(position)
        holder.bind(task)
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewTask: TextView = itemView.findViewById(R.id.textViewTask)
        private val textViewStatusTask: TextView = itemView.findViewById(R.id.textViewStatusTask)
        fun bind(task: TaskModel){
            textViewTask.text = "Task: ${task.task}"
            textViewStatusTask.text = "Status: ${task.status}"
        }
    }
    class TaskDiffCallBack: DiffUtil.ItemCallback<TaskModel>(){
        override fun areContentsTheSame(oldItem: TaskModel, newItem: TaskModel): Boolean {
            return oldItem.task == newItem.task && oldItem.status == newItem.status
        }

        override fun areItemsTheSame(oldItem: TaskModel, newItem: TaskModel): Boolean {
            return oldItem == newItem
        }
    }

}
