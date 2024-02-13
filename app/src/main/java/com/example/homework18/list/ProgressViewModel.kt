package com.example.homework18.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework18.TaskModel

class ProgressViewModel: ViewModel() {
    private val _todoList: MutableLiveData<List<TaskModel>> = MutableLiveData()
    val todoList: LiveData<List<TaskModel>>
        get() = _todoList

    fun loadData(){
        _todoList.value = listOf(
            TaskModel("Make homework 16", "process"),
            TaskModel("Make homework 17", "process"),
            TaskModel("Make homework 18", "process"),
            TaskModel("Make homework 19", "process"),
            TaskModel("Make homework 20", "process")
        )
    }
}