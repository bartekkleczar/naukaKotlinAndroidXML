package pl.klenczi.apitrainingpictures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val job: Job = CoroutineScope(Dispatchers.IO).launch{ // zmienna z korutyną do pobierania API
            Log.d("HTTP_JSON", Fetchr().getJsonString())
            val gson = Gson() // baza do parsowania
            val obiekt = gson.fromJson(Fetchr().getJsonString(), JsonDataClass::class.java) // obiekt klasy jsonowej
            /*Log.d("HTTP_JSON", obiekt.eyeColor)*/  // wypisanie zmiennej z obiektu

            for(i in obiekt.photos.photo){
                Log.d("HTTP_JSON", i.title)
            }
        }

        job.start() // startowanie zmiennej job - do pobierania API

        if(job.isCompleted){ // usuniecie job jak sie zrobi
            job.cancel()
        }
    }
}