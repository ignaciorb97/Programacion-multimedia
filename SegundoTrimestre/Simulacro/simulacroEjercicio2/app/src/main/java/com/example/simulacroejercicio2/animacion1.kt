package com.example.simulacroejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class animacion1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animacion1)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotation)
        imageView.startAnimation(animation)
    }
}