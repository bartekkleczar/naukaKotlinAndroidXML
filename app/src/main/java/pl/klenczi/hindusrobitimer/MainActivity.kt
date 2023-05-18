package pl.klenczi.hindusrobitimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.klenczi.hindusrobitimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun start(){

    }

    private fun stop(){

    }

    private fun reset(){

    }

}