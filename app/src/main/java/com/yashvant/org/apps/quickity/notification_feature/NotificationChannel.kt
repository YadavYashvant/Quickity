package com.yashvant.org.apps.quickity.notification_feature

import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.yashvant.org.apps.qrscanner.R
import com.yashvant.org.apps.quickity.utils.Constants.Companion.CHANNEL_ID


// Define Notification Channel
fun NotificationChannel(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel= android.app.NotificationChannel(
            CHANNEL_ID,
            "You're ....",
            NotificationManager.IMPORTANCE_HIGH
        )

        val notificationManager = context.getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }
}

fun sendNotification(context: Context, title: String, message: String) {
    val notificationManager = ContextCompat.getSystemService(
        context,
        NotificationManager::class.java
    ) as NotificationManager

    val builder = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.grocery)
        .setContentTitle(title)
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    notificationManager.notify(0, builder.build())
}

