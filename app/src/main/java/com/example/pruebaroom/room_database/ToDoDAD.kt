package com.example.pruebaroom.room_database

import androidx.room.*

@Dao public abstract interface ToDoDAD {
    @Query("SELECT * FROM ToDo")
    suspend fun getAllTasks(): List<ToDo>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: ToDo) : Long
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTasks(task: List<ToDo>?) : List<Long>
    @Update
    suspend fun updateTask(task : ToDo)
    @Delete
    suspend fun deleteTask(task: ToDo)

}