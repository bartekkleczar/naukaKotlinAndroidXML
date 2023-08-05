package pl.klenczi.zadanieodhindusaclicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import pl.klenczi.zadanieodhindusaclicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var count = 0
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val tv = findViewById<TextView>(R.id.tvCount)
        val btn = findViewById<Button>(R.id.btnCount)

        tv.text = viewModel.count.toString()

        btn.setOnClickListener{
            viewModel.updateCount()
            tv.text = viewModel.count.toString()
        }
    }
}