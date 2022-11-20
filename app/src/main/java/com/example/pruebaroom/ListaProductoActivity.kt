package com.example.pruebaroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.pruebaroom.room_database.AdminProducto.Producto
import com.example.pruebaroom.room_database.AdminProducto.ProductoAdapter
import com.example.pruebaroom.room_database.AdminProducto.ProductoDatabase
import kotlinx.android.synthetic.main.activity_lista_producto.*

class ListaProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_producto)

        /*val producto1 = Producto(0,"tv", 100.0F, "HDMI", R.drawable.ic_android_black_24dp)
        val producto2 = Producto(0,"camara", 150.0F, "48mp", R.drawable.ic_android_black_24dp)
        val listaProductos = listOf(producto1, producto2)*/

        var listaProductos= emptyList<Producto>()
        var database= ProductoDatabase.getDatabase(this)
        database.productos().getAll().observe(

            this, Observer { listaProductos=it

                val adapter = ProductoAdapter(this, listaProductos)
                lista.adapter = adapter

            }

        )

        /*val adapter = ProductoAdapter(this, listaProductos)
        lista.adapter = adapter*/
        lista.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(this,ProductoActivity::class.java)

            intent.putExtra("producto", listaProductos[position])

            startActivity(intent)
        }

        floatingbuttonALP.setOnClickListener {
            val intent = Intent(this, NuevoProductoActivity::class.java)
            startActivity(intent)
        }


        /*val producto1 = Producto("tv", 100.0F, "HDMI", R.drawable.ic_android_black_24dp)
        val producto2 = Producto("camara", 100.0F, "48mp", R.drawable.ic_android_black_24dp)
        val listaProducto = listOf(producto1, producto2)
        val adapter = ProductoAdapter(this, listaProductos)
        lista.adapter = adapter
        lista.setOnClickListener (){parent, view, position , id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProducto[position])
            startActivity(intent)
*/
        }


    }
