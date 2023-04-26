package pl.klenczi.apitutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import pl.klenczi.apitutorial.databinding.ActivityMainBinding
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class DrugieApi : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // Dodanie bindingu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Dodanie bindingu - rozwianie go
        setContentView(binding.root) // Dodanie bindingu - zmiana content view
    }
    private fun FetchCurrencyData(): Thread {
        return Thread{
            val url = URL("https://dog-facts-api.herokuapp.com/api/v1/resources/dogs?number=1")
            val connection = url.openConnection() as HttpsURLConnection
            if(connection.responseCode == 200){
                val inputSystem = connection.inputStream
                val inputStreamReader = InputStreamReader(inputSystem, "UTF-8")
                val request = Gson().fromJson( inputStreamReader, Request::class.java)
                updateUI(request)
                inputStreamReader.close()
                inputSystem.close()
            }
            else{
                binding.baseCurrency.text = "Failed Connection"
            }
        }
    }

    private fun updateUI(request: Request) {

    }

}