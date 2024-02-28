package com.example.simulacroejercicio2

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView

class video1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video1)
        val videoView = findViewById<VideoView>(R.id.video_view)

        val videoPath = "android.resource://${packageName}/${R.raw.video1}"
        val videoUri = Uri.parse(videoPath)

        videoView.setVideoURI(videoUri)

        val mediaController = android.widget.MediaController(this)
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)

        videoView.start()

        val buttonPlay = findViewById<Button>(R.id.button_play)
        buttonPlay.setOnClickListener {
            videoView.seekTo(0)
            videoView.start()
        }
    }
}