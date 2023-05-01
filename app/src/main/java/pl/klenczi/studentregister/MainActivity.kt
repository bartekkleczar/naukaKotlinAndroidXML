package pl.klenczi.studentregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.klenczi.studentregister.R
import pl.klenczi.studentregister.db.Student
import pl.klenczi.studentregister.db.StudentDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var nameET: EditText
    private lateinit var emailET: EditText
    private lateinit var saveBtn: Button
    private lateinit var clearBtn: Button

    private lateinit var viewModel: StudentViewModel
    private lateinit var studentRecyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter
    private var isListItemClicked = false

    private lateinit var selectedStudent: Student
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameET = findViewById(R.id.etName)
        emailET = findViewById(R.id.etEmail)
        saveBtn = findViewById(R.id.btnSave)
        clearBtn = findViewById(R.id.btnClear)
        studentRecyclerView = findViewById(R.id.rvStudent)

        val dao = StudentDatabase.getInstance(application).studentDao()
        val factory = StudentViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory).get(StudentViewModel::class.java)

        saveBtn.setOnClickListener {
            if(isListItemClicked){
                updateStudentData()
                clearInput()
            }else {
                saveStudentData()
                clearInput()
            }
        }

        clearBtn.setOnClickListener {
            if(isListItemClicked){
                deleteStudentData()
                clearInput()
            }else {
                clearInput()
            }
        }

        initRecyclerView()
    }

    private fun saveStudentData(){
        val name = nameET.text.toString()
        val email = emailET.text.toString()
        val student = Student(0, name, email)
        viewModel.insertStudent(student)
    }

    private fun updateStudentData(){
        viewModel.deleteStudent(
            Student(
                selectedStudent.id,
                nameET.text.toString(),
                emailET.text.toString()))
        selectedStudent = null
        saveBtn.text = "Safe"
        clearBtn.text = "Clear"
        isListItemClicked = false
    }

    private fun deleteStudentData(){
        viewModel.updateStudent(
            Student(
                selectedStudent.id,
                nameET.text.toString(),
                emailET.text.toString()))
        selectedStudent = null
        saveBtn.text = "Safe"
        clearBtn.text = "Clear"
        isListItemClicked = false
    }
    private fun clearInput(){
        nameET.setText("")
        emailET.setText("")
    }

    private fun initRecyclerView(){
        studentRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter{ selectedItem: Student -> listItemClicked(selectedItem) }
        studentRecyclerView.adapter = adapter
        displayStudentsList()
    }

    private fun displayStudentsList(){
        viewModel.students.observe(this, {adapter.setList(it); adapter.notifyDataSetChanged()})
    }

    private fun listItemClicked(student: Student){
        selectedStudent = student
        saveBtn.text = "Update"
        clearBtn.text = "Delete"
        isListItemClicked = true
    }
}