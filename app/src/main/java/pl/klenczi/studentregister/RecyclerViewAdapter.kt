package pl.klenczi.studentregister

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.klenczi.studentregister.db.Student

class RecyclerViewAdapter(private val clickListener: (Student)-> Unit): RecyclerView.Adapter<ViewHolder>() {
    private val studentList = ArrayList<Student>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return  studentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(studentList[position], clickListener)
    }

    fun setList(students: List<Student>){
        studentList.clear()
        studentList.addAll(students)
    }
}

class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){
    fun bind(student: Student, clickListener: (Student)-> Unit){
        val nameTV = view.findViewById<TextView>(R.id.tvName)
        val emailTV = view.findViewById<TextView>(R.id.tvEmail)

        nameTV.text = student.name
        emailTV.text = student.email
        view.setOnClickListener{
            clickListener(student)
        }
    }
}