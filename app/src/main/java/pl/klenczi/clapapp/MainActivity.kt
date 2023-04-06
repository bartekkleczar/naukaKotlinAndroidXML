package pl.klenczi.clapapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var mP: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play = findViewById<FloatingActionButton>(R.id.fabPlay)
        val pause = findViewById<FloatingActionButton>(R.id.fabPause)
        val stop = findViewById<FloatingActionButton>(R.id.fabStop)

        play.setOnClickListener {
            if(mP == null){
                mP = MediaPlayer.create(this,  R.raw.applauding)
            }

            mP?.start()
        }

        pause.setOnClickListener {
            mP?.pause()
        }

        stop.setOnClickListener {
            mP?.stop()
            mP?.reset()
            mP?.release()
            mP = null
        }
    }
}