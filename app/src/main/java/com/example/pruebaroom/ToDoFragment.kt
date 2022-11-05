package com.example.pruebaroom

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class ToDoFragment: Fragment() {

    private lateinit var listRecyclerView: RecyclerView
    private lateinit var myAdapter: RecyclerView.Adapter<MyTaskListAdapter.MyViewHolder>
    var myTaskTitles: ArrayList<String> = ArrayList()
    var myTaskContents: ArrayList<String> = ArrayList()
    var myTaskPlaces: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?)

    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmento = inflater.inflate(R.layout.fragment_to_do, container,false)

        /*    val btnSancocho:Button=fragmento.findViewById(R.id.btn_sancocho)
            val btnBocachico:Button=fragmento.findViewById(R.id.btn_bocachico)
            val btnChicharron:Button=fragmento.findViewById(R.id.btn_chicharron)
            val btnCazuela:Button=fragmento.findViewById(R.id.btn_cazuela)
            val btnCayeye:Button=fragmento.findViewById(R.id.btn_Cayeye)

            //Boton de sancocho
            btnSancocho.setOnClickListener (View.OnClickListener {

                val datos=Bundle()
                datos.putString("Titulo","Sancocho de pescado")
                datos.putString("Plato","Sopa con bagre y arroz")
                datos.putString("Precio","$20000")
                datos.putString("Imagen","@drawable/sancochodepescado.jpg")


                activity
                        ?.supportFragmentManager?.beginTransaction()
                        ?.setReorderingAllowed(true)
                        ?.replace(R.id.fcv, DetailFragment::class.java, datos, "DetailFragment")
                        ?.addToBackStack(null)
                        ?.commit()
            })

            btnBocachico.setOnClickListener (View.OnClickListener {

                val datos=Bundle()
                datos.putString("Titulo","Viuda de bocachico")
                datos.putString("Plato","Bocachico con yuca, mazorca, arracacha y arroz")
                datos.putString("Precio","$25000")



                activity
                    ?.supportFragmentManager?.beginTransaction()
                    ?.setReorderingAllowed(true)
                    ?.replace(R.id.fcv, DetailFragment::class.java, datos, "DetailFragment")
                    ?.addToBackStack(null)
                    ?.commit()
            })*/

        return fragmento
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /*
        var myTaskTitles: ArrayList<String> = ArrayList()
        var myTaskContents: ArrayList<String> = ArrayList()
        var myTaskPlaces: ArrayList<String> = ArrayList()

        myTaskTitles.add("Sancocho de pescado")
        myTaskTitles.add("Viudo de pescado")
        myTaskTitles.add("Ceviche de camaron")
        myTaskTitles.add("Bocachico")
        myTaskTitles.add("Cayeye")

        myTaskContents.add("Sopa con pescado y verduras")
        myTaskContents.add("Pescado sudado con arroz y platano")
        myTaskContents.add("Coctel de camaron con salsa de tomate y saltinas")
        myTaskContents.add("Pescado sudado con arroz y ñame")
        myTaskContents.add("mote de guineo verde")


        myTaskPlaces.add("Restaurante")
        myTaskPlaces.add("Restaurante o a domicilio")
        myTaskPlaces.add("Unicamente a domicilio")
        myTaskPlaces.add("Restaurante o a domicilio")
        myTaskPlaces.add("Unicamente a domicilio")


        var info: Bundle=Bundle()

        info.putStringArrayList("titles", myTaskTitles)
        info.putStringArrayList("contents", myTaskContents)
        info.putStringArrayList("places", myTaskPlaces)
        listRecyclerView = requireView().findViewById(R.id.recyclerToDoList)
        myAdapter = MyTaskListAdapter(activity as AppCompatActivity,info)
        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter = myAdapter
        listRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
*/

        //Ver video clase 3 21/10 para crear el newTaskActivity
        val fab : View = requireActivity().findViewById(R.id.fabHome)
        fab.setOnClickListener{ view ->
            val intent = Intent(activity,NewTaskActivity::class.java)
            startActivity(intent)

            //var recursiveScope = 0
            //startActivityForResult(intent,recursiveScope)
        }

        /*var info: Bundle=Bundle()

        info.putStringArrayList("titles", myTaskTitles)
        info.putStringArrayList("contents", myTaskContents)
        info.putStringArrayList("places", myTaskPlaces)
        listRecyclerView = requireView().findViewById(R.id.recyclerToDoList)
        myAdapter = MyTaskListAdapter(activity as AppCompatActivity,info)
        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter = myAdapter
        listRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))*/
        //updateList()
    }

/*    fun updateList(){

        val db = ToDoDatabase.getDatabase(requireActivity())
        val toDoDAD = db.todoDao()
        runBlocking {
            launch {
                var result = toDoDAD.getAllTasks()
                var i=1
                myTaskTitles.clear()
                myTaskContents.clear()
                myTaskPlaces.clear()
                while (i<result.size){
                    myTaskTitles.add(result[i].title.toString())
                    myTaskContents.add(result[i].content.toString())
                    myTaskPlaces.add(result[i].place.toString())

                    i++
                }

                myAdapter.notifyDataSetChanged()
            }
        }
    }*/

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode==0){

            if(resultCode== Activity.RESULT_OK){
                // updateList()
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

}