package pl.klenczi.studentregister.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_data_table") //  definiuje, że ta klasa jest encją, a parametr tableName określa nazwę tabeli w bazie danych, którą ta encja reprezentuje
data class Student( // definiuje klasę Student, która jest encją w bazie danych
    @PrimaryKey(autoGenerate = true) // ta adnotacja definiuje pole id jako klucz główny tabeli, który jest generowany automatycznie przez bazę danych

    @ColumnInfo(name = "student_id") // definiuje, że nazwa kolumny w bazie danych dla pola id to student_id
    var id: Int, //pole klasy Student, które reprezentują id studenta przechowywane w bazie danych

    @ColumnInfo(name = "student_name") // definiuje, że nazwa kolumny w bazie danych dla pola id to student_name
    var name: String, //pole klasy Student, które reprezentują name studenta przechowywany w bazie danych

    @ColumnInfo(name = "student_email") // definiuje, że nazwa kolumny w bazie danych dla pola id to student_email
    var email: String //pole klasy Student, które reprezentują email studenta przechowywany w bazie danych
)