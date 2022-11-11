package com.example.pruebaroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //activity_to_do; antes estaba activity_welcome
        setContentView(R.layout.activity_welcome)

        val fab: View = findViewById(R.id.fab)

        fab.setOnClickListener{view->

            //Acá esta configurado el boton para pasar de WelcomeActivity a
            Snackbar.make(view,"add", Snackbar.LENGTH_LONG).show()

            val intent = Intent (this, ToDoActivity::class.java)
            startActivity(intent)

        }

    }



    }
