package pl.klenczi.wiadomoscidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val CHANNEL_ID = "my_channel"

        fun showNotification(context: Context, title: String, message: String) {
            // Tworzenie kanału powiadomień
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channelName = "My Channel"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, channelName, importance)
            channel.apply {
                enableLights(true)
                lightColor = Color.RED
                enableVibration(true)
                description = "My notification channel"
            }
            notificationManager.createNotificationChannel(channel)

            //przekierowanie do aplikacji gdy klikniesz w powiadomienie
            val pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE
            )

            // Tworzenie powiadomienia
            val notificationBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground) //ikona powiadomienia
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(pendingIntent) //przekierowanie do aplikacji gdy klikniesz w powiadomienie
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setOngoing(true) // ustawia powiadomienie jako trwałe, nie do usunięcia przez użytkownika

            // nw co to robi, jest zbedne w dzialaniu aplikaci
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            // Wyświetlenie powiadomienia
            notificationManager.notify(0, notificationBuilder.build())
        }

        showNotification(this, "My Title", "My message")
    }

    override fun onDestroy() {
        super.onDestroy()
        // usunięcie powiadomienia
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancel(0)
    }
}