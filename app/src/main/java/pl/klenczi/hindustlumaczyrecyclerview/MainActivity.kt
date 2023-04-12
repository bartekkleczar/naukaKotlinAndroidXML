package pl.klenczi.hindustlumaczyrecyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val fruits = listOf<Fruit>(
        Fruit("Mango", "Joe"), Fruit("Apple", "Frank"), Fruit("Banana", "Tom"), Fruit("Guava", "Joe"), Fruit("Lemon", "Alex"), Fruit("Pear", "Joe"), Fruit("Orange", "Alex"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.myRV)
        rv.setBackgroundColor(Color.YELLOW)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = MyRvAdapter(fruits)
    }
}