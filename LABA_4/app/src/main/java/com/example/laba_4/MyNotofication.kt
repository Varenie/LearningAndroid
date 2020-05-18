package com.example.laba_4

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MyNotofication(context: Context) {
    val context = context

    val NAME = "basic"
    val CH_ID = "5"
    val NOTIF_ID = 5

    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CH_ID, NAME, importance)
            val notificationManager = context.getSystemService(NotificationManager::class.java)

            notificationManager.createNotificationChannel(channel)
        }
    }

    fun sendNotification(){
        createNotificationChannel()

        val arr = longArrayOf(500, 500, 500, 500)

        val builder = NotificationCompat.Builder(context, CH_ID)
            .setSmallIcon(R.drawable.clock)
            .setContentTitle("Уведомление")
            .setContentText("Часики то тикают!")
            .setVibrate(arr)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(NOTIF_ID, builder.build())
    }
}