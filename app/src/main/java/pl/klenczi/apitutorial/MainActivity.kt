package pl.klenczi.apitutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.klenczi.apitutorial.databinding.ActivityMainBinding
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // Dodanie bindingu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Dodanie bindingu - rozwianie go
        setContentView(binding.root) // Dodanie bindingu - zmiana content view

        FetchCurrencyData().start()
    }

    private fun FetchCurrencyData(): Thread {
        return Thread{
            val url = URL("https://open.er-api.com/v6/latest/aud")
            val connection = url.openConnection() as HttpsURLConnection

            if(connection.responseCode == 200){
                val inputSystem = connection.inputStream
                println(inputSystem.toString())
            }
            else{
                binding.baseCurrency.text = "Failed Connection"
            }
        }
    }
}