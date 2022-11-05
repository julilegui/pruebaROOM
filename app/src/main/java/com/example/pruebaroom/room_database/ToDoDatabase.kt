package com.example.pruebaroom.room_database
import android.content.Context
import android.provider.CalendarContract.Instances
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.internal.synchronized



//Lo creé en la carpeta room_database y nuevo Kotlin class/file

@Database(entities = arrayOf(ToDo::class), version = 1)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun todoDao(): ToDoDAD
    companion object{
        @Volatile
        private var INSTANCE : ToDoDatabase?=null
        fun getDatabase(context: Context) : ToDoDatabase
        {
            //return INSTANCE ?: synchronized(this) no reconoce esta linea
            return INSTANCE ?: kotlin.synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    ToDoDatabase::class.java,"ToDoDatabase").build()
                INSTANCE = instance
                instance
            }

        }
    }
}