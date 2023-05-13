package pl.klenczi.hindustlumaczyviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import pl.klenczi.hindustlumaczyviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString()
            binding.tvMessage.text = "Hello $name"
            binding.etName.setText("")
        }
    }
}