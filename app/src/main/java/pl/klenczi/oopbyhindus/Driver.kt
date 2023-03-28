package pl.klenczi.oopbyhindus

import android.util.Log

class Driver(var name: String) {

    var car = Car()

    init {
        car.maxSpeed = 150
        car.start()
    }
    fun showDetails(){
        Log.i("MYTAG", "Name of the driver is $name")
    }
}