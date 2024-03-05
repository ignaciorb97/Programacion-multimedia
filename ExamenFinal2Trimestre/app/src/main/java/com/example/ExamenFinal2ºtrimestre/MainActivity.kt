package com.example.ExamenFinal2ºtrimestre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var dataManager: DataManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        dataManager = DataManager(this)
        val etTitulo = findViewById<EditText>(R.id.etNombre)
        val etAutor = findViewById<EditText>(R.id.etApellido)
        val etGenero = findViewById<EditText>(R.id.etDireccion)
        val etEditorial = findViewById<EditText>(R.id.etCp)
        val etAnio = findViewById<EditText>(R.id.etCiudad)

        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val tvMuestraNombre = findViewById<TextView>(R.id.tvMuestraNombre)
        val btnEliminar = findViewById<Button>(R.id.btnEliminar)

        btnAgregar.setOnClickListener {
            val titulo = etTitulo.text.toString()
            val autor = etAutor.text.toString()
            val genero = etGenero.text.toString()
            val editorial = etEditorial.text.toString()
            val anio = etAnio.text.toString()

            dataManager.addName(titulo,autor,genero,editorial,anio)
            Toast.makeText(this, "Se agregó a la base de datos: $titulo",
                Toast.LENGTH_SHORT).show()
            etTitulo.text.clear()
            etAutor.text.clear()
            etGenero.text.clear()
            etEditorial.text.clear()
            etAnio.text.clear()

        }

        btnMostrar.setOnClickListener {
            val nombres = dataManager.getAllNames(this)
            tvMuestraNombre.text = nombres
        }

        btnEliminar.setOnClickListener {
            dataManager.eliminarUser()
            Toast.makeText(this, "Se eliminaron todos los datos", Toast.LENGTH_SHORT).show()
        }
    }
}