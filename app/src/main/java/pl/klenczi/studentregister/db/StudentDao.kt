package pl.klenczi.studentregister.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

//Ten kod zawiera interfejs DAO (Data Access Object) dla bazy danych, która przechowuje informacje o studentach
@Dao // adnotacja oznaczająca, że to jest interfejs DAO
interface StudentDao { // deklaracja interfejsu DAO
    @Insert // metoda w interfejsie DAO do wstawiania danych w bazie danych
    suspend fun insertStudent(student: Student) // stworzenie metody 'suspend' -> korutynowej

    @Update // metoda w interfejsie DAO do aktualizowania a danych w bazie danych
    suspend fun updateStudent(student: Student) // stworzenie metody 'suspend' -> korutynowej

    @Delete // metoda w interfejsie DAO do usuwaniaa danych w bazie danych
    suspend fun deleteStudent(student: Student) // stworzenie metody 'suspend' -> korutynowej

    @Query("SELECT * FROM student_data_table") // apytanie SQL do pobierania danych z bazy danych. Wybiera wszystkie wiersze z tabeli 'student_data_table'
    fun getAllStudents(): LiveData<List<Student>> //  ta metoda zwraca wszystkich studentów z bazy danych jako <List<Student>>
}