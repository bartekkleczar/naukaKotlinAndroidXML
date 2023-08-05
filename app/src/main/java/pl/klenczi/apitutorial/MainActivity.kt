package pl.klenczi.apitutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.gson.Gson
import pl.klenczi.apitutorial.databinding.ActivityMainBinding
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // Dodanie bindingu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Dodanie bindingu - rozwianie go
        setContentView(binding.root) // Dodanie bindingu - zmiana content view

        FetchCurrencyData().start()

        val btn = findViewById<Button>(R.id.btnSecondActivity)
        btn.setOnClickListener{
            val intent = Intent(this, DrugieApi::class.java)
            startActivity(intent)
        }
    }

    private fun FetchCurrencyData(): Thread {
        return Thread{
            val url = URL("https://open.er-api.com/v6/latest/aud")
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
        runOnUiThread{
            kotlin.run {
                binding.lastUpdated.text = request.time_last_update_utc
                binding.nzd.text = String.format("NZD: %.2f", request.rates.NZD)
                binding.usd.text = String.format("USD: %.2f", request.rates.USD)
                binding.gbp.text = String.format("GBP: %.2f", request.rates.GBP)
            }
        }
    }
}