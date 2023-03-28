package pl.klenczi.oopbyhindus

import android.util.Log

class Driver(var name: String) {

    fun showDetails(){
        Log.i("MYTAG", "Name of the driver is $name")
    }
}