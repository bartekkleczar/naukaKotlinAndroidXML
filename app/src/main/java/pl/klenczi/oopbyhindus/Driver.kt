package pl.klenczi.oopbyhindus

import android.util.Log

class Driver(name: String) {
    lateinit var driverName: String

    init {
        driverName = name
    }

    fun showDetails(){
        Log.i("MYTAG", "Name of the driver is $driverName")
    }
}