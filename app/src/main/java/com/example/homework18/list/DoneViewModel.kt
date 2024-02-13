package com.example.homework18.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework18.TaskModel

class DoneViewModel: ViewModel() {
    private val _todoList: MutableLiveData<List<TaskModel>> = MutableLiveData()
    val todoList: LiveData<List<TaskModel>>
        get() = _todoList

    fun loadData(){
        _todoList.value = listOf(
            TaskModel("Make homework 11", "done"),
            TaskModel("Make homework 12", "done"),
            TaskModel("Make homework 13", "done"),
            TaskModel("Make homework 14", "done"),
            TaskModel("Make homework 15", "done")
        )
    }
}