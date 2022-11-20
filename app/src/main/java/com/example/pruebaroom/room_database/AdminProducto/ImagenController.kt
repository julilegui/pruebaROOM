package com.example.pruebaroom.room_database.AdminProducto

import android.app.Activity
import android.content.Intent

object ImagenController {

    fun selectPhoneFromGallery(activity: Activity, code: Int){
        val intent = Intent(Intent(Intent.ACTION_PICK))
        intent.type="image/*"
        activity.startActivityForResult(intent,code)
    }

}