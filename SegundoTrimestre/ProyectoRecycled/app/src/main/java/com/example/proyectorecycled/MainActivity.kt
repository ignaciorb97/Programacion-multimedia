package com.example.proyectorecycled

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// definiendo una variable que es un list person de la clase Person
        val personList = generatePersonList() //metodo que introduce
        // la lista de personas.
        // hacemos referencia al id del recycledView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        //con linearlayoutmanager gestiona la posición de los elementos en el layout
        //tanto si es horizontal como vertical
        recyclerView.layoutManager = LinearLayoutManager(this)
        //crea una variable personAdapter le damos el valor de la clave PersonAdpater y el
        // es la lista de personas
        val personAdapter = PersonAdapter(personList)
        //añdimos a recyclerview la lista de personas
        recyclerView.adapter = personAdapter
    }

    private fun generatePersonList(): List<Person> {
        return listOf(
            Person("Alberto","Ruiz",7),
            Person("Juan","Perez",13),
            Person("Eva","Garcia",2),
            Person("Alberto","",19),
            Person("Laura","",23),
            Person("Cristina","",69),
            Person("Isabel","",93),
            Person("Pedro", "Moreno",1),
            Person("Jose","Android",23),
            Person("Manuel", "Oracle",33),
            Person("Diana","Hibernate",2),


        )
    }
}
