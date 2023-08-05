package pl.klenczi.oopbyhindus

interface SpeedController {
    fun accelerate()
    fun decelerate()

    fun getBrandId(): String{
        return "ADS3452"
    }
}