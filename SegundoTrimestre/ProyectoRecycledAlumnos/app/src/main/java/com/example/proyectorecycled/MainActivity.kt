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
        val personList = generateAlumnoList() //metodo que introduce
        // la lista de personas.
        // hacemos referencia al id del recycledView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        //con linearlayoutmanager gestiona la posición de los elementos en el layout
        //tanto si es horizontal como vertical
        recyclerView.layoutManager = LinearLayoutManager(this)
        //crea una variable personAdapter le damos el valor de la clave PersonAdpater y el
        // es la lista de personas
        val alumnosAdapter = AlumnosAdapter(personList)
        //añdimos a recyclerview la lista de personas
        recyclerView.adapter = alumnosAdapter
    }

    private fun generateAlumnoList(): List<Alumnos> {
        return listOf(
            Alumnos("Alberto","Matematicas",7),
            Alumnos("Juan","Lengua",6),
            Alumnos("Eva","Fisica",5),
            Alumnos("Alberto","Programacion",5),
            Alumnos("Laura","Educacion Fisica",6),
            Alumnos("Cristina","FOL",7),
            Alumnos("Isabel","FOL",8),
            Alumnos("Pedro", "Lengua",9),
            Alumnos("Jose","Matematicas",8),
            Alumnos("Manuel", "Fisica",3),
            Alumnos("Diana","Programacion",2),


        )
    }
}
