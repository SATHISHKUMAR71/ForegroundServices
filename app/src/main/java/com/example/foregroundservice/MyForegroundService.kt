package com.example.foregroundservice

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

class MyForegroundService:Service() {

    companion object{
        val NOTIFICATION_ID = 104
        val CHANNEL_ID = "ForegroundServiceChannel"
    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val activityIntent = Intent(this,MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            activityIntent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("App Foreground Service")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentText("This is the Content of the Foreground Service")
            .setContentIntent(pendingIntent)
            .build()

        startForeground(NOTIFICATION_ID,notification)
        return START_STICKY
    }
}