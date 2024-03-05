package com.example.simulacroejercicio2


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SegundaPantalla : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_pantalla)

        val rootView: View = LayoutInflater.from(this).inflate(R.layout.activity_segunda_pantalla, null)
        val linearLayout = rootView.findViewById<LinearLayout>(R.id.linearLayout)


        val name: String = intent.extras?.getString("EXTRA_NOMBRE").orEmpty()
        val contra:String = intent.extras?.getString("EXTRA_CONTRA").orEmpty()
        val fecha:String = intent.extras?.getString("EXTRA_FECHA").orEmpty()
        val hora:String = intent.extras?.getString("EXTRA_HORA").orEmpty()
        val citaU:String = intent.extras?.getString("EXTRA_CITA").orEmpty()


        val tvNombre= TextView(this)
        val tvContra = TextView(this)
        val tvFecha = TextView(this)
        val tvHora = TextView(this)
        val tvCita = TextView(this)

        tvNombre.text="Nombre: $name"
        tvContra.text="contra: $contra"
        tvFecha.text="Fecha: $fecha"
        tvFecha.text="Hora: $hora"
        tvCita.text="$citaU"

        tvNombre.textSize= 30F
        tvContra.textSize= 30F
        tvFecha.textSize= 30F
        tvHora.textSize= 30F
        tvCita.textSize= 30F



        linearLayout.addView(tvNombre)
        linearLayout.addView(tvContra)
        linearLayout.addView(tvFecha)
        linearLayout.addView(tvHora)
        linearLayout.addView(tvCita)

        val btVideo1 = Button(this)
        val btVideo2 = Button(this)
        val btVideo3 = Button(this)
        val btAnimacion1 = Button(this)
        val btAnimacion2 = Button(this)
        val btAnimacion3 = Button(this)

        btVideo1.text = "Video 1"
        btVideo2.text = "Video 2"
        btVideo3.text = "Video 3"
        btAnimacion1.text = "Animación 1"
        btAnimacion2.text = "Animación 2"
        btAnimacion3.text = "Animación 3"

        btVideo1.setOnClickListener {
            val intent = Intent(this, video1::class.java)
            startActivity(intent)
        }
        btVideo2.setOnClickListener {
            val intent = Intent(this, video2::class.java)
            startActivity(intent)
        }
        btVideo3.setOnClickListener {
            val intent = Intent(this, video3::class.java)
            startActivity(intent)
        }
        btAnimacion1.setOnClickListener {
            val intent = Intent(this, animacion1::class.java)
            startActivity(intent)
        }
        btAnimacion2.setOnClickListener {
            val intent = Intent(this, animacion2::class.java)
            startActivity(intent)
        }
        btAnimacion3.setOnClickListener {
            val intent = Intent(this, animacion3::class.java)
            startActivity(intent)
        }

        linearLayout.addView(btVideo1)
        linearLayout.addView(btVideo2)
        linearLayout.addView(btVideo3)
        linearLayout.addView(btAnimacion1)
        linearLayout.addView(btAnimacion2)
        linearLayout.addView(btAnimacion3)

        setContentView(rootView)
    }
}