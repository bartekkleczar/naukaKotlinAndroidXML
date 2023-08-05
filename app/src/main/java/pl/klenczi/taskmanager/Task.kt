package pl.klenczi.taskmanager

class Task(var name: String, var isDone: Boolean = false){
    fun check(status: Boolean): Boolean {
        when(status){
            true -> {
                return true
            }
            false -> {
                return false
            }
        }
    }
}
