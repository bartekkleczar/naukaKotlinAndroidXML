package pl.klenczi.studentregister.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/*
Ten kod definiuje klasę StudentDatabase, która jest klasą abstrakcyjną służącą do zarządzania bazą danych Room
 */

@Database( //  definiuje, że ta klasa jest bazą danych
    entities = [Student::class], // określa listę encji, które znajdują się w tej bazie danych
    version = 1, // określa numer wersji bazy danych
    exportSchema = false // wyłącza eksportowanie schematu bazy danych
)
abstract class StudentDatabase: RoomDatabase(){
    abstract fun studentDao(): StudentDao // definiuje abstrakcyjną funkcję, będzie wykorzystywana do uzyskiwania dostępu do encji Student w bazie danych

    companion object{ // definiuje obiekt towarzyszący dla klasy

        @Volatile // może być zmieniona przez wiele wątków
        private var INSTANCE: StudentDatabase? = null /* definiuje zmienną INSTANCE, która przechowuje instancję klasy StudentDatabase.
        Zmienna ta jest oznaczona jako volatile, co oznacza, że jej wartość może być zmieniona przez wiele wątków. */

        fun getInstance(context: Context): StudentDatabase{ // wywoływana, aby uzyskać instancję klasy StudentDatabase. fun -> StudentDatabase

            synchronized(this){ /* kod jest synchronizowany na obiekcie klasy
            Synchronizacja ta zapewnia, że tylko jeden wątek na raz będzie mógł uzyskać dostęp do tego bloku kodu*/

                var instance = INSTANCE
                if(instance == null){ // -> true, jeśli nie swtorzone jeszcze bazy danych
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDatabase::class.java,
                        "student_data_database"
                    ).build() // tworzy nową bazę danych
                }
                return instance
            }
        }
    }
}