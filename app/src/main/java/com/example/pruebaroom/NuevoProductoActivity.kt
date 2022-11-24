package com.example.pruebaroom

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebaroom.room_database.AdminProducto.ImagenController
import com.example.pruebaroom.room_database.AdminProducto.Producto
import com.example.pruebaroom.room_database.AdminProducto.ProductoDatabase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_nuevo_producto.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//No me aparecen los botones de editar y eliminar
class NuevoProductoActivity : AppCompatActivity() {
    private val SELECT_ACTIVITY=50
    private var imagenUri: Uri?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_producto)

        val database = ProductoDatabase.getDatabase(this)
        val dbFirebase = FirebaseFirestore.getInstance()
        var idProducto: Int=0
        if (intent.hasExtra("producto")){
            val producto = intent.extras?.getSerializable("producto")as Producto
            editTextNombreANP.setText(producto.nombre)
            editTextPrecioANP.setText(producto.precio.toString())
            editTextDescripcionANP.setText(producto.descripcion)
            idProducto=producto.idProducto
            val imageUri = ImagenController.getImagenUri(this,producto.idProducto.toLong())
            imageViewSelectANP.setImageURI(imageUri)
        }
        buttonANP.setOnClickListener {
            val nombre = editTextNombreANP.text.toString()
            val precio = editTextPrecioANP.text.toString().toFloat()
            val descripcion = editTextDescripcionANP.text.toString()
            val producto = Producto(idProducto,nombre,precio,descripcion,R.drawable.ic_launcher_background)

            if (idProducto==0) {

                CoroutineScope(Dispatchers.IO).launch {
                    var result = database.productos().insert(producto)

                    dbFirebase.collection("Productos").document(result.toString())
                        .set(
                            hashMapOf(
                                "nombre" to nombre,
                                "precio" to precio,
                                "descripcion" to descripcion
                            )
                        )
                    imagenUri?.let {
                        ImagenController.saveImagen(this@NuevoProductoActivity,result,it)
                    }
                    this@NuevoProductoActivity.finish()
                }
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    database.productos().update(producto)
                    imagenUri?.let {
                        ImagenController.saveImagen(this@NuevoProductoActivity,idProducto.toLong(),it)
                    }
                    dbFirebase.collection("Productos").document(idProducto.toString())
                        .set(
                            hashMapOf(
                                "nombre" to nombre,
                                "precio" to precio,
                                "descripcion" to descripcion
                            )
                        )
                    this@NuevoProductoActivity.finish()
                }

                val principal=Intent(this,ListaProductoActivity::class.java)
                startActivity(principal)
            }

        }

        imageViewSelectANP.setOnClickListener {

            ImagenController.selectPhoneFromGallery(this,SELECT_ACTIVITY)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when{
            requestCode==SELECT_ACTIVITY && resultCode== Activity.RESULT_OK->{
                imagenUri = data!!.data
                imageViewSelectANP.setImageURI(imagenUri)
            }

        }
    }




}