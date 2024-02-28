package com.example.simulacroej1

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
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellido = findViewById<EditText>(R.id.etApellido)
        val etDireccion = findViewById<EditText>(R.id.etDireccion)
        val etCp = findViewById<EditText>(R.id.etCp)
        val etCiudad = findViewById<EditText>(R.id.etCiudad)
        val etProvincia = findViewById<EditText>(R.id.etProvincia)
        val etTelefono = findViewById<EditText>(R.id.etTelefono)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val tvMuestraNombre = findViewById<TextView>(R.id.tvMuestraNombre)
        val btnEliminar = findViewById<Button>(R.id.btnEliminar)

        btnAgregar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val direccion = etDireccion.text.toString()
            val cp = etCp.text.toString()
            val ciudad = etCiudad.text.toString()
            val provincia = etProvincia.text.toString()
            val telefono = etTelefono.text.toString()
            dataManager.addName(nombre,apellido,direccion,cp,ciudad,provincia,telefono)
            Toast.makeText(this, "Se agregó a la base de datos: $nombre",
                Toast.LENGTH_SHORT).show()
            etNombre.text.clear()
            etApellido.text.clear()
            etDireccion.text.clear()
            etCp.text.clear()
            etCiudad.text.clear()
            etProvincia.text.clear()
            etTelefono.text.clear()
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