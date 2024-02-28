package com.example.simulacroejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class animacion3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animacion3)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.transparency)
        imageView.startAnimation(animation)
    }
}