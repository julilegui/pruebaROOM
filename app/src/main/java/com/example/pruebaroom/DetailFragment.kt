package com.example.pruebaroom

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


//New-add-kotlinClasFile
class DetailFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?)

    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmento = inflater.inflate(R.layout.fragment_detail, container,false)

        //Menus
        //Sacar los dato de forma dinamica
        //var imagen = requireArguments().getString("Imagen")
        var titulo =requireArguments().getString("Titulo")
        var plato =requireArguments().getString("Plato")
        var precio =requireArguments().getString("Precio")
        var id =requireArguments().getString("id")



        //Textos de Bocachico
        //var TituloBocachico =requireArguments().getString("TituloBocahcico")
        //var PlatoBocachico =requireArguments().getString("PlatoBocachico")
        //var PrecioBocachico =requireArguments().getString("PrecioBocachico")
        //var cayeye =requireArguments().getString("cayeye")

        //De donde se sacan los datos
        //var imgPlato: ImageView = fragmento.findViewById(R.id.imgPlato)
        var tvTitulo: TextView = fragmento.findViewById(R.id.tvTitulo)
        var tvPlato: TextView = fragmento.findViewById(R.id.tvPlato)
        var tvPrecio: TextView = fragmento.findViewById(R.id.tvPrecio)
        var tvId: TextView = fragmento.findViewById(R.id.tvId)
        // var tvTituloBocachico: TextView = fragmento.findViewById(R.id.tvBocachico)
        // var tvPlatoBocachico: TextView = fragmento.findViewById(R.id.tvMenuBocachico)
        //var tvPrecioBocachico: TextView = fragmento.findViewById(R.id.tvPrecioBocachico)


        //var tvBocachico: TextView = fragmento.findViewById(R.id.tvBocachico)
        //var tvChicharron: TextView = fragmento.findViewById(R.id.tvChicharron)
        //var tvCazuela: TextView = fragmento.findViewById(R.id.tvCazuela)
        //var tvCayeye: TextView = fragmento.findViewById(R.id.tvCayeye)

        //De donde se envia la informacion

        //imgPlato.setImageResource(getResources().getIdentifier(imagen, "drawable", getPackage.name))
        tvId.text = id
        tvTitulo.text = titulo
        tvPlato.text = plato
        tvPrecio.text = precio
        val btnEdit: Button = fragmento.findViewById(R.id.btnEditfd)
        btnEdit.setOnClickListener {
            val principal = Intent(inflater.context, NewTaskActivity::class.java)
            principal.putExtra("titulo", tvTitulo.text as String)
            principal.putExtra("plato", tvPlato.text as String)
            principal.putExtra("precio", tvPrecio.text as String)
            principal.putExtra("id", tvId.text as String)

            startActivity(principal)
        }

        //tvTituloBocachico.text = TituloBocachico
        //tvPlatoBocachico.text = PlatoBocachico
        //tvPrecioBocachico.text = PrecioBocachico


        //tvBocachico.text = bocachico
        //tvChicharron.text = chicharron
        //tvCazuela.text = cazuela
        //tvCayeye.text = cayeye

        return fragmento
    }

}