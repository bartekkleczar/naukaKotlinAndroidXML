package pl.klenczi.taskmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvTasks)
        //rv.setBackgroundColor(Color.YELLOW)
        rv.layoutManager = LinearLayoutManager(this)

        val tasks = mutableListOf<Task>()
        val etInput = findViewById<EditText>(R.id.etTaskName)
        val btnAdd = findViewById<Button>(R.id.btnTaskAdd)

        btnAdd.setOnClickListener {
            if(etInput.text.toString() != ""){
                tasks.add(element = Task(etInput.text.toString()))
                etInput.setText("")
                rv.adapter = MyRvAdapter(tasks)
            }
            else{
                val toast = getString(R.string.task_add_empty_error)
                Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
            }
        }



    }
}