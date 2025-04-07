package com.example.uidesign.Notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.uidesign.MainActivity // Replace with the appropriate activity class
import com.example.uidesign.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FCM", "Token: $token")
        // Optionally save token to Firestore or backend here
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        val title = remoteMessage.notification?.title ?: "No Title"
        val body = remoteMessage.notification?.body ?: "No Message"

        // Log notification received event
        val analytics = FirebaseAnalytics.getInstance(this)
        analytics.logEvent("notification_received", Bundle().apply {
            putString("title", title)
            putString("body", body)
        })

        showNotification(title, body)
    }

    private fun showNotification(title: String?, body: String?) {
        val channelId = "login_channel"
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create Notification Channel for devices running Android O and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Login Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        // Intent to open the app when the user taps the notification
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("title", title) // Pass the title as extra data
            putExtra("body", body)   // Pass the body as extra data
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        }

        // PendingIntent to launch activity on tap
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent, PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )

        // Create the notification
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle(title ?: "Default Title")
            .setContentText(body ?: "Default Message")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent) // Set the PendingIntent
            .build()

        // Show the notification
        notificationManager.notify(0, notification)
    }

    // Handle the notification tap in the activity
    override fun onMessageSent(msgId: String) {
        super.onMessageSent(msgId)
        val intent = Intent(this, MainActivity::class.java)
        val title = intent.getStringExtra("title")
        val body = intent.getStringExtra("body")

        // Log notification opened event
        val analytics = FirebaseAnalytics.getInstance(this)
        analytics.logEvent("notification_opened", Bundle().apply {
            putString("title", title)
            putString("body", body)
        })
    }
}
