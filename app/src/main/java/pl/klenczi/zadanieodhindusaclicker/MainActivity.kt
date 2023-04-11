package pl.klenczi.zadanieodhindusaclicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.klenczi.zadanieodhindusaclicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener {
            when(binding.tvCount.text.toString() ){
                "" -> {binding.tvCount.text = "1"}
                else -> {binding.tvCount.text = (binding.tvCount.text.toString().toInt()+1).toString()}
            }
        }
    }
}