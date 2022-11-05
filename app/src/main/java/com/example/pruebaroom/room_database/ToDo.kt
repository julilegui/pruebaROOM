package com.example.pruebaroom.room_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
public final data class ToDo(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val title : String,
    val content: String,
    val place: String

)
