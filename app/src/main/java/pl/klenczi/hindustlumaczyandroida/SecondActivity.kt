package pl.klenczi.hindustlumaczyandroida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var userName = intent.getStringExtra("USER")
        var textView = findViewById<TextView>(R.id.tvOffer)
        var message = "$userName, you will get free access to whole content for one month"
        textView.text = message
    }
}