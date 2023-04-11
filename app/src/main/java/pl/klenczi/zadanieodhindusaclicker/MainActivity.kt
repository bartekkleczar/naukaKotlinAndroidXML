package pl.klenczi.zadanieodhindusaclicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import pl.klenczi.zadanieodhindusaclicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tv = findViewById<TextView>(R.id.tvCount)
        val btn = findViewById<Button>(R.id.btnCount)

        tv.text = count.toString()

        btn.setOnClickListener{
            ++count
            tv.text = count.toString()
        }
    }
}