package pl.klenczi.studentregister

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pl.klenczi.studentregister.db.StudentDao

class StudentViewModelFactory(private val dao: StudentDao):ViewModelProvider.Factory {
    fun <T : ViewModel?> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(StudentViewModel::class.java)){
            return StudentViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}