package com.example.examenparcial

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    private var opcionSeleccionada: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSiguiente = findViewById<Button>(R.id.btnEntrar)
        val etName = findViewById<EditText>(R.id.Nombre)
        val etApellido = findViewById<EditText>(R.id.Apellidos)
        val etFecha = findViewById<EditText>(R.id.Fecha)
        val etContra = findViewById<EditText>(R.id.Contraseña)
        val etConfContra = findViewById<EditText>(R.id.ConfirmContraseña)
        val etEspecialista = findViewById<EditText>(R.id.Especialista)
        val citaU = findViewById<CardView>(R.id.cv)

        citaU.setOnClickListener {
            handleCardViewClick(citaU)
            startSegundaPantalla(
                etApellido,
                etName,
                etFecha,
                etContra,
                etConfContra,
                etEspecialista
            )
            Toast.makeText(this, "LA CITA ES URGENTE", Toast.LENGTH_SHORT).show()
        }

        btnSiguiente.setOnClickListener {
            startSegundaPantalla(
                etApellido,
                etName,
                etFecha,
                etContra,
                etConfContra,
                etEspecialista
            )
        }
    }

    private fun startSegundaPantalla(
        etApellido: EditText,
        etName: EditText,
        etFecha: EditText,
        etContra: EditText,
        etConfContra: EditText,
        etEspecialista: EditText
    ) {
        val apellido = etApellido.text.toString()
        val nombre = etName.text.toString()
        val fecha = etFecha.text.toString()
        val contrasenia = etContra.text.toString()
        val confcontra = etConfContra.text.toString()
        val especialista = etEspecialista.text.toString()

        if (apellido.isNotEmpty() && nombre.isNotEmpty() &&
            fecha.isNotEmpty() && contrasenia.isNotEmpty() &&
            confcontra.isNotEmpty() && especialista.isNotEmpty()
        ) {

            val intent = Intent(this, SegundaPantalla::class.java)
            intent.putExtra("EXTRA_APELLIDO", apellido)
            intent.putExtra("EXTRA_NOMBRE", nombre)
            intent.putExtra("EXTRA_FECHA", fecha)
            intent.putExtra("EXTRA_CONTRA", contrasenia)
            intent.putExtra("EXTRA_CONFCONTRA", confcontra)
            intent.putExtra("EXTRA_ESPECIALISTA", especialista)
            intent.putExtra("EXTRA_CITA", opcionSeleccionada)
            startActivity(intent)
        } else {
            Toast.makeText(this, "No has rellenado todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleCardViewClick(cardView: CardView) {
        when (cardView.id) {
            R.id.cv -> {

                println("Se ha pulsado cardview1")
                Log.d("CardView", "Has pulsado el cardview1")
                opcionSeleccionada = "la cita es urgente"
            }
        }
    }
}

