package com.example.formuskan;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.widget.RemoteViews;

import java.util.Random;

public class LoveMessageWidget extends AppWidgetProvider {

    private static final String[] messages = {
            "You are my sunshine ☀️",
            "Missing you already 💕",
            "Can’t wait to see your smile 😍",
            "You’re the best thing in my life 💖",
            "Forever yours ❤️",
            "Your smile lights up my world 💫",
            "Thinking of you always 💭",
            "You complete me 🧩",
            "Every hour I love you more ⏳",
            "You're my happy place 🌈",
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

    private static final String ACTION_UPDATE = "com.example.formuskan.UPDATE_WIDGET";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateWidget(context, appWidgetManager, appWidgetId);
        }

        // Schedule the alarm to update every minute
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, LoveMessageWidget.class);
        intent.setAction(ACTION_UPDATE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        alarmManager.setRepeating(
                AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime(),
                60 * 1000,  // 1 minute
                pendingIntent
        );
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (ACTION_UPDATE.equals(intent.getAction())) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(
                    new ComponentName(context, LoveMessageWidget.class));
            for (int appWidgetId : appWidgetIds) {
                updateWidget(context, appWidgetManager, appWidgetId);
            }
        }
    }

    private void updateWidget(Context context, AppWidgetManager manager, int widgetId) {
        String message = messages[new Random().nextInt(messages.length)];
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.activity_love_message_widget);
        views.setTextViewText(R.id.widget_message, message);
        manager.updateAppWidget(widgetId, views);
    }
}
