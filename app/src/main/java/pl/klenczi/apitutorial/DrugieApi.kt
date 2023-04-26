package pl.klenczi.apitutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.klenczi.apitutorial.databinding.ActivityMainBinding

class DrugieApi : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // Dodanie bindingu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Dodanie bindingu - rozwianie go
        setContentView(binding.root) // Dodanie bindingu - zmiana content view
    }
}