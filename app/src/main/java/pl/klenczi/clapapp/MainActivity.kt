package pl.klenczi.clapapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var seekBar: SeekBar
    private var mP: MediaPlayer? = null
    private lateinit var runnable: Runnable
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar = findViewById(R.id.sbClapping)
        handler = Handler(Looper.getMainLooper())
        val play = findViewById<FloatingActionButton>(R.id.fabPlay)
        val pause = findViewById<FloatingActionButton>(R.id.fabPause)
        val stop = findViewById<FloatingActionButton>(R.id.fabStop)

        play.setOnClickListener {
            if(mP == null){
                mP = MediaPlayer.create(this,  R.raw.applauding)
                initSeekBar()
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
            handler.removeCallbacks(runnable)
            seekBar.progress = 0
        }
    }
    private fun initSeekBar(){
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) mP?.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        val tvP = findViewById<TextView>(R.id.tvPlayed)
        val  tvDue = findViewById<TextView>(R.id.tvDue)
        seekBar.max = mP!!.duration
        runnable = Runnable{
            seekBar.progress = mP!!.currentPosition

            val playedTime = mP!!.currentPosition/1000
            tvP.text = "$playedTime sec"
            val duration = mP!!.duration/1000
            val dueTime = duration-playedTime
            tvDue.text = "$dueTime sec"

            handler.postDelayed(runnable, 10)
        }
        handler.postDelayed(runnable, 10)

    }
}