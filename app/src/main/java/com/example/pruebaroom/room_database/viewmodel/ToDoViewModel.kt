package com.example.pruebaroom.room_database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebaroom.room_database.ToDo
import com.example.pruebaroom.room_database.ToDoRepository.ToDoRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ToDoViewModel(private var repository: ToDoRepository): ViewModel() {

    var tasks : List<ToDo>?=null
    fun getAllTasks(): Job{

        return viewModelScope.async {
            tasks = repository.getAllTask()
        }

    }

    fun getTheTasks(): List<ToDo>?{

        return tasks
    }

    fun insertTask(toDo: ToDo): Long {

        var idTask: Long = 0
        viewModelScope.launch {
            idTask=repository.insertTask(toDo)

        }
        return idTask
    }

    fun insertTasks(toDo: List<ToDo>?): List<Long>?{

        var idTask : List<Long>?=null
        viewModelScope.launch {
            idTask=repository.insertTasks(toDo)
        }

        return idTask
    }

}