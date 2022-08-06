package com.ae.aj.localnotifications.notification

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context

class AjApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    /*
    * To create a Notification channel for the application
    * Long press the app icon and click App info
    * to see the created channel
    * */
    private fun createNotificationChannel() {
        val notificationChannel = NotificationChannel(
            BalanceNotificationService.BALANCE_CHANNEL_ID,
            "Balance",
            NotificationManager.IMPORTANCE_DEFAULT //Importance of the channel to appear
        )
        notificationChannel.description = "Used for the balance notifications"
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)
    }
}