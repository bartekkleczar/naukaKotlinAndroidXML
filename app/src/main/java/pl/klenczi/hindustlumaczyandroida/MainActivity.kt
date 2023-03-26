package pl.klenczi.hindustlumaczyandroida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var greetingsFromIndia = findViewById<TextView>(R.id.tvHello)
        var inputField = findViewById<EditText>(R.id.tvName)
        var submitButton = findViewById<Button>(R.id.btnSubmit)
        submitButton.setOnClickListener{
            var enteredName = inputField.text.toString()
            var message = "Greetings from India $enteredName"
            greetingsFromIndia.text = message
        }
    }
}