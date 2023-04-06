package pl.klenczi.clapapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var mP: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mP = MediaPlayer.create(this,  R.raw.applauding)

        val button = findViewById<Button>(R.id.btnClap)
        button.setOnClickListener{
            mP.start()
        }

    }
}