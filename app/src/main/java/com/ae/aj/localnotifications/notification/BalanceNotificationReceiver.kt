package com.ae.aj.localnotifications.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/*
* A Receiver which will listen to the Notification action and updates back
*
* */
class BalanceNotificationReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val service = BalanceNotificationService(context)
        service.showNotification(++Balance.value)
    }
}