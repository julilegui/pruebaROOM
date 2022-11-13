package com.example.pruebaroom.room_database.ToDoRepository

import com.example.pruebaroom.room_database.ToDo
import com.example.pruebaroom.room_database.ToDoDAD

class ToDoRepository(private val toDoDao: ToDoDAD) {

    suspend fun getAllTask(): List<ToDo>{
        return toDoDao.getAllTasks()
    }

    suspend fun insertTask(toDo : ToDo): Long{

        return toDoDao.insertTask(toDo)

    }

    suspend fun insertTasks(toDo: List<ToDo>?): List<Long>{
        return toDoDao.insertTasks(toDo)
    }



}