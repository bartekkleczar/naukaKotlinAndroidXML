package pl.klenczi.hindustlumaczyandroida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.i("MYTAG", "SecondActivity: onCreate")
        var userName = intent.getStringExtra("USER")
        var textView = findViewById<TextView>(R.id.tvOffer)
        var message = "$userName, you will get free access to whole content for one month"
        textView.text = message
    }

    override fun onStart() {
        super.onStart()
        Log.i("MYTAG", "SecondActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG", "SecondActivity: onResume")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("MYTAG", "SecondActivity: onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MYTAG", "SecondActivity: onRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MYTAG", "SecondActivity: onStop")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG", "SecondActivity: onPause")
    }
}