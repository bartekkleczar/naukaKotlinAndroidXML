package pl.klenczi.oopbyhindus

import android.util.Log

class MyCar: Car(), SpeedController {
    override fun start(){
        Log.i("MyTag", "this is MyCar Starting... brand id is ${getBrandId()}")
    }

    override fun accelerate() {

    }

    override fun decelerate() {

    }
}