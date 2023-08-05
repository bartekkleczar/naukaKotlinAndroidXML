package pl.klenczi.oopbyhindus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myCar = MyCar()
        myCar.maxSpeed = 898
        myCar.start()
    }
}