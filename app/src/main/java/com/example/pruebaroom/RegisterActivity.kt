package com.example.pruebaroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
    private var edName: EditText?=null
    private var edNit: EditText?=null
    private var edEmail: EditText?=null
    private var edPassword: EditText?=null
    private var chBPolicies: CheckBox?=null
    private val text_Pattern: Pattern = Pattern.compile(
        "[a-zA-Z]*"

    )
    // Patron que debe tener una contraseña
    private val password_Pattern: Pattern = Pattern.compile(

        "^"+
                "(?=.*[0-9])"+
                "(?=.*[a-z])"+
                ".{8,}"+
                "$"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edName=findViewById(R.id.edName)
        edNit=findViewById(R.id.edNit)
        edPassword=findViewById(R.id.edtPasswordR)
        edEmail=findViewById(R.id.edEmail)
        chBPolicies=findViewById(R.id.chb_Policies)



    }

    fun OnRegister(view: View){

        if (ValidateForm())
        {
            Toast.makeText(this,"correcto", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
        }



    }

    private fun ValidateForm():Boolean{
        var validate = true
        val nameInput=edName!!.text.toString()
        val passwordInput= edPassword!!.text.toString()
        val emailInput= edEmail!!.text.toString()

        //Validacion checbox
        if (!chBPolicies!!.isChecked)
        {
            validate=false
        }

        //Validacion del nombre
        if(TextUtils.isEmpty(edName!!.text.toString()))
        {
            edName!!.error="Requerido"
            validate=false
        }
        //Junta los espacios que tengan los nombres para reconocerlos como un unico valor
        else if(!text_Pattern.matcher(nameInput.replace(" ", "")).matches())
        {
            edName!!.error="nombre no valido"
            validate=false
        }

        else edName!!.error=null

        //Validacion del apellido (copiar de la linea 62 a la 72


        if(TextUtils.isEmpty(edPassword!!.text.toString())){
            edPassword!!.error="Requerido"
            validate=false
        } else if (!password_Pattern.matcher(passwordInput).matches())
        {
            edPassword!!.error="no cumple con las politicas"

        } else edPassword!!.error=null

        return validate
    }





}