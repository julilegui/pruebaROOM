package com.example.pruebaroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.pruebaroom.room_database.ToDo
import com.example.pruebaroom.room_database.ToDoDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class NewTaskActivity : AppCompatActivity() {

    lateinit var editTextTitle: EditText
    lateinit var editTextContent: EditText
    lateinit var editTextPlace: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)

        editTextTitle = findViewById(R.id.editTextTitle)
        editTextContent = findViewById(R.id.editTextContent)
        editTextPlace = findViewById(R.id.editTextPlaces)

    }

    fun onSaveTask(view: View) {

        var title: String = editTextTitle.text.toString()
        var content: String = editTextContent.text.toString()
        var place: String = editTextPlace.text.toString()
        val db = ToDoDatabase.getDatabase(this)
        val todoDao = db.todoDao()
        val task = ToDo(0,title, content, place)
        runBlocking {
            launch {
                var result = todoDao.insertTask(task)
                if (result!=1L){
                    setResult(RESULT_OK)
                    finish()
                }
            }
        }
    }




}