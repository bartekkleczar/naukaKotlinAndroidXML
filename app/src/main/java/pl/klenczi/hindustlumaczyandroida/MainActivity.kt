package pl.klenczi.hindustlumaczyandroida

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var greetingsFromIndia = findViewById<TextView>(R.id.tvHello)
        var inputField = findViewById<EditText>(R.id.etName)
        var submitButton = findViewById<Button>(R.id.btnSubmit)
        submitButton.setOnClickListener{
            var enteredName = inputField.text.toString()
            if (enteredName == ""){
                greetingsFromIndia.text = ""
                Toast.makeText(
                    this@MainActivity,
                    "Enter your name",
                    Toast.LENGTH_SHORT).show()
            }
            else{
            var message = "Greetings from India $enteredName"
            greetingsFromIndia.text = message}
        }
    }
}