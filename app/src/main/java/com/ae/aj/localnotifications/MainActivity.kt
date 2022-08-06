package com.ae.aj.localnotifications

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import com.ae.aj.localnotifications.notification.Balance
import com.ae.aj.localnotifications.notification.BalanceNotificationService
import com.ae.aj.localnotifications.ui.theme.AjLocalNotificationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = BalanceNotificationService(applicationContext)
        setContent {
            AjLocalNotificationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Button(onClick = { service.showNotification(Balance.value) }) {
                            Text(text = "Show Notification")
                        }
                    }
                }
            }
        }
    }
}