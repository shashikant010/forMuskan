package com.example.formuskan;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import java.util.Random;

public class HourlyNotificationReceiver extends BroadcastReceiver {

    private final String[] messages = {
            "You are my sunshine ☀️",
            "Missing you already 💕",
            "Can’t wait to see your smile 😍",
            "You’re the best thing in my life 💖",
            "You make my world brighter 🌟",
            "Thinking of you is my favorite hobby ❤️",
            "Your smile is my favorite view 😘",
            "Every moment without you feels incomplete 🕰️",
            "I love you more than words can express 💌",
            "You're always in my heart 💗",
            "Counting the minutes till I see you ⏳",
            "My heart beats for you only 💓",
            "You're the melody to my life's song 🎵",
            "Just wanted to remind you: you're amazing 💕",
            "You're my reason to smile every day 😊",
            "My day starts and ends with you ☀️🌙",
            "I'm lucky to call you mine 🍀",
            "Your love is my daily motivation 🚀",
            "You’re the piece that completes my puzzle 🧩",
            "I hope you're smiling right now 😊",
            "Falling for you more with every hour 🕐",
            "I cherish every memory we've made 🖼️",
            "You’re the calm in my chaos 🌈",
            "Your love is my favorite gift 🎁"
    };

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = messages[new Random().nextInt(messages.length)];

        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(
                context, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE);

        String channelId = "romantic_reminders";
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    channelId, "Romantic Reminders", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("From Your Jaan 💘")
                .setContentText(message)
                .setAutoCancel(true)
                .setContentIntent(contentIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        manager.notify(new Random().nextInt(), builder.build());
    }
}

