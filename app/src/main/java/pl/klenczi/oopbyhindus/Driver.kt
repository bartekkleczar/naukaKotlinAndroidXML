package pl.klenczi.oopbyhindus

import android.util.Log

class Driver(var name: String, credit: Int) {
    private var totalCredit = credit
    private var car = Car()

    init {
        totalCredit += credit
        car.maxSpeed = 150
        car.start()
    }
    fun showDetails(){
        Log.i("MYTAG", "Name of the driver is $name with $totalCredit credits")
    }
}