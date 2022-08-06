package com.ae.aj.localnotifications.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.ae.aj.localnotifications.MainActivity
import com.ae.aj.localnotifications.R

class BalanceNotificationService(
    private val context: Context
) {
    private val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    fun showNotification(balance: Int) {

        //Pending Intent for Notification content -> Activity to open when clicked on notification in status bar
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            Intent(context, MainActivity::class.java),
            PendingIntent.FLAG_IMMUTABLE
        )

        //Pending Intent for Action
        val actionPendingIntent = PendingIntent.getBroadcast(
            context, 1, Intent(context, BalanceNotificationReceiver::class.java),
            PendingIntent.FLAG_IMMUTABLE
        )

        //Actual notification to show
        val notification = NotificationCompat.Builder(context, BALANCE_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_baby_changing_station_24)
            .setContentTitle("Increment balance")
            .setContentText("Balance is $balance")
            .setContentIntent(activityPendingIntent)
            .addAction(
                R.drawable.ic_baseline_baby_changing_station_24,
                "Increment",
                actionPendingIntent
            )
            .build()

        //Notification Id should be same if you want to send same notification type
        manager.notify(1, notification)
    }

    companion object {
        const val BALANCE_CHANNEL_ID = "balance_channel" //Unique and constant Channel ID
    }
}