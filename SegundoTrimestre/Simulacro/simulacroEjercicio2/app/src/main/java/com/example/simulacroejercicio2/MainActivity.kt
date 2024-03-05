package com.example.simulacroejercicio2

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import java.io.OutputStreamWriter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class MainActivity : AppCompatActivity() {
    private var opcionSeleccionada: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Create","App iniciada")

        val titulo = findViewById<TextView>(R.id.Login)
        val mSpannableString = SpannableString(titulo.text)

        mSpannableString.setSpan(UnderlineSpan(), 0, mSpannableString.length, 0)
        titulo.text = mSpannableString


        val btnSiguiente = findViewById<Button>(R.id.btnEntrar)
        val etName = findViewById<EditText>(R.id.Nombre)
        val etContra = findViewById<EditText>(R.id.Contraseña)
        val etFecha = findViewById<EditText>(R.id.Fecha)
        val etHora = findViewById<EditText>(R.id.Hora)


        val btnF = findViewById<Button>(R.id.btnFecha)
        val btnH = findViewById<Button>(R.id.btnHora)
        val citaU = findViewById<CardView>(R.id.cv)
        val selectedDate = Calendar.getInstance()

        citaU.setOnClickListener {
            handleCardViewClick(citaU)
        }
        btnF.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    selectedDate.set(year, month, dayOfMonth)
                    actualizarCampoFecha(etFecha,selectedDate)
                },
                selectedDate.get(Calendar.YEAR),
                selectedDate.get(Calendar.MONTH),
                selectedDate.get(Calendar.DAY_OF_MONTH)
            )
            datePickerDialog.show()
        }

        btnH.setOnClickListener {
            val cldr = Calendar.getInstance()
            val hour = cldr[Calendar.HOUR_OF_DAY]
            val minutes = cldr[Calendar.MINUTE]
            val timePickerDialog = TimePickerDialog(
                this,
                { _, hourOfDay, minute ->
                    val time = String.format("%02d:%02d", hourOfDay, minute)
                    etHora.setText("$time")
                },
                hour,
                minutes,
                true
            )
            timePickerDialog.show()
        }
        btnSiguiente.setOnClickListener {
            val contra = etContra.text.toString()
            val nombre = etName.text.toString()
            val fecha = etFecha.text.toString()
            val hora = etHora.text.toString()

            if (contra.isNotEmpty() && nombre.isNotEmpty() &&
                fecha.isNotEmpty() && hora.isNotEmpty()
            ) {
                Log.d("Datos","Datos insertados correctamente")
                try {
                    val fileName = "Usuarios"
                    val fileContent = "Nombre: $nombre | Contraseña: $contra | Fecha: $fecha | Hora: $hora \n"
                    val osw = OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE))
                    osw.write(fileContent)
                    osw.flush()
                    osw.close()
                    Log.d("Éxito", "Archivo creado con éxito!")
                } catch (e: Exception) {
                    Log.e("Error", "Error al usar OutputStreamWriter: " + e.message)
                }
                Toast.makeText(this, "El texto es correcto", Toast.LENGTH_LONG).show()
                val intent = Intent(this, SegundaPantalla::class.java)
                intent.putExtra("EXTRA_CONTRA", contra)
                intent.putExtra("EXTRA_NOMBRE", nombre)
                intent.putExtra("EXTRA_FECHA", fecha)
                intent.putExtra("EXTRA_HORA", hora)
                intent.putExtra("EXTRA_CITA",opcionSeleccionada)
                startActivity(intent)
            }else{
                Log.e("Error","Faltan rellenar campos")
                Toast.makeText(this,"Los datos son incorrectos",Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun handleCardViewClick(cardView: CardView) {
        when (cardView.id) {
            R.id.cv -> {
                println("Se ha pulsado cardview1")
                Log.d("CardView", "Has pulsado el cardview1")
                opcionSeleccionada = "USUARIO ADMIN"
            }
        }
    }
    private fun actualizarCampoFecha(etF:EditText, sd:Calendar) {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        etF.setText(sdf.format(sd.time))
    }
}