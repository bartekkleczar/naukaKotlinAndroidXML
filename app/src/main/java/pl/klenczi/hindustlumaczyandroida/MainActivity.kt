package pl.klenczi.hindustlumaczyandroida

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
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
        var offersButton = findViewById<Button>(R.id.btnOffers)
        var enteredName: String
        submitButton.setOnClickListener{
            enteredName = inputField.text.toString()
            if (enteredName == ""){
                offersButton.visibility = INVISIBLE
                greetingsFromIndia.text = ""
                Toast.makeText(
                    this@MainActivity,
                    "Enter your name",
                    Toast.LENGTH_SHORT).show()
            }
            else{
            var message = "Greetings from India $enteredName"
            greetingsFromIndia.text = message
            inputField.text.clear()
            offersButton.visibility = VISIBLE}
        }

        offersButton.setOnClickListener{
            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER", enteredName)
            startActivity(intent)
        }
    }
}