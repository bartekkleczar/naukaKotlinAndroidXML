package pl.klenczi.studentregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import pl.klenczi.studentregister.R
import pl.klenczi.studentregister.db.Student
import pl.klenczi.studentregister.db.StudentDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var nameET: EditText
    private lateinit var emailET: EditText
    private lateinit var saveBtn: Button
    private lateinit var clearBtn: Button

    private lateinit var viewModel: StudentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameET = findViewById(R.id.etName)
        emailET = findViewById(R.id.etEmail)
        saveBtn = findViewById(R.id.btnSave)
        clearBtn = findViewById(R.id.btnClear)

        val dao = StudentDatabase.getInstance(application).studentDao()
        val factory = StudentViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory).get(StudentViewModel::class.java)

        saveBtn.setOnClickListener {
            saveStudentData()
            clearInput()
        }

        clearBtn.setOnClickListener {
            clearInput()
        }
    }

    private fun saveStudentData(){
        val name = nameET.text.toString()
        val email = emailET.text.toString()
        val student = Student(0, name, email)
        viewModel.insertStudent(student)
    }

    private fun clearInput(){
        nameET.setText("")
        emailET.setText("")
    }
}