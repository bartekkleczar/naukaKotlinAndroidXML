package pl.klenczi.hindustlumaczyservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyBackgroundService: Service() {

    init{
        Log.i("MainActivity", "Service has been created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("MainActivity", "Service started")
        return START_STICKY
    }
    /*
    Funkcja onStartCommand() jest uruchamiana, gdy system Android rozpoczyna usługę w tle.
    Zwraca ona wartość START_STICKY, co oznacza, że usługa będzie kontynuowana, gdy zostanie zatrzymana ze względu na brak pamięci.
     */

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    /*
    Funkcja onBind() jest wywoływana, gdy inna aplikacja chce skorzystać z tej usługi poprzez wywołanie metody bindService().
    Ta funkcja zwraca null, co oznacza, że nie zezwala na powiązanie z tą usługą.
    */

    override fun onDestroy() {
        Log.i("MainActivity", "Service destroying")
        super.onDestroy()
    }

    /*
    Funkcja onDestroy() jest wywoływana, gdy system Android kończy usługę.
     */
}