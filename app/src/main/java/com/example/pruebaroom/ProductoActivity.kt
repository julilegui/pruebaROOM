package com.example.pruebaroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.pruebaroom.room_database.AdminProducto.ImagenController
import com.example.pruebaroom.room_database.AdminProducto.Producto
import com.example.pruebaroom.room_database.AdminProducto.ProductoDatabase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_producto.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)
        //No me esta mostrando el detalle del producto, por que?
        val producto = intent.getSerializableExtra("producto")as Producto
        val imageUri = ImagenController.getImagenUri(this,producto.idProducto.toLong())
        textViewNombreAP.text=producto.nombre
        textViewPrecioAP.text="$${producto.precio}"
        textViewDetalleAP.text = producto.descripcion
        //imageViewPerfilAP.setImageResource(producto.imagen)
        imageViewPerfilAP.setImageURI(imageUri)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.producto_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val producto = intent.getSerializableExtra("producto") as Producto
        val database = ProductoDatabase.getDatabase(this)
        val dbFirebase = FirebaseFirestore.getInstance()
        when(item.itemId) {
            R.id.edit_item -> {
                val intent = Intent(this, NuevoProductoActivity::class.java)
                intent.putExtra("producto",producto)
                startActivity(intent)
            }
            R.id.delete_item ->{
                CoroutineScope(Dispatchers.IO).launch {
                    database.productos().delete(producto)
                    dbFirebase.collection("Productos")
                        .document(producto.idProducto.toString()).delete()
                    this@ProductoActivity.finish()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

}