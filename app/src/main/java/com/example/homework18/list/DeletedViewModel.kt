package com.example.homework18.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework18.TaskModel

class DeletedViewModel: ViewModel() {
    private val _todoList: MutableLiveData<List<TaskModel>> = MutableLiveData()
    val todoList: LiveData<List<TaskModel>>
        get() = _todoList

    fun loadData(){
        _todoList.value = listOf(
            TaskModel("Make homework 6", "deleted"),
            TaskModel("Make homework 7", "deleted"),
            TaskModel("Make homework 8", "deleted"),
            TaskModel("Make homework 9", "deleted"),
            TaskModel("Make homework 10", "deleted"))
    }
}