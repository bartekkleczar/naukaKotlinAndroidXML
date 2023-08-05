package pl.klenczi.hindustlumaczyservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import pl.klenczi.hindustlumaczyservices.MyBackgroundService.Companion.MARKS
import pl.klenczi.hindustlumaczyservices.MyBackgroundService.Companion.NAME
import pl.klenczi.hindustlumaczyservices.MyBackgroundService.Companion.TAG
import pl.klenczi.hindustlumaczyservices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val serviceIntent = Intent(this, MyBackgroundService::class.java)
        serviceIntent.putExtra(NAME, "Dupa")
        serviceIntent.putExtra(MARKS, 78)
        binding.apply{
            btnStart.setOnClickListener{
                Log.i(TAG, "Service starting")
                startService(serviceIntent)
            }

            btnStop.setOnClickListener{
                Log.i(TAG, "Service stopping")
                stopService(serviceIntent)
            }
        }
    }
}