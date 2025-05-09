package com.example.formuskan;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {


    Button  btnGallery, btnNotes, btnComplete, btnTImeline, btnFuture,loveMeter,btnScratch,btnHear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnGallery = findViewById(R.id.btnGallery);
        btnNotes = findViewById(R.id.btnNotes);
        btnComplete = findViewById(R.id.btnComplete);
        loveMeter = findViewById(R.id.loveMeterBtn);
        btnTImeline = findViewById(R.id.btnTimeline);
        btnFuture = findViewById(R.id.btnFuture);
        btnScratch = findViewById(R.id.btnScratch);
        btnHear = findViewById(R.id.btnHear);



        btnGallery.setOnClickListener(v -> startActivity(new Intent(this, GalleryActivity.class)));
        btnNotes.setOnClickListener(v -> startActivity(new Intent(this, NotesActivity.class)));
        btnComplete.setOnClickListener(v -> startActivity(new Intent(this, ColorHerWorldActivity.class)));
        loveMeter.setOnClickListener(v -> startActivity(new Intent(this, LoveMeterActivity.class)));
        btnTImeline.setOnClickListener(v->{startActivity(new Intent(this,TimelineActivity.class));});
        btnFuture.setOnClickListener(v->{startActivity(new Intent(this,LettersActivity.class));});
        btnScratch.setOnClickListener(v->{startActivity(new Intent(this,ScratchActivityCard.class));});
        btnHear.setOnClickListener(v->{startActivity(new Intent(this,VoiceMessageActivity.class));});

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
            } else {
                scheduleHourlyNotification();
            }
        } else {
            scheduleHourlyNotification();
        }

        scheduleHourlyNotification();




    }

    private void scheduleHourlyNotification() {
        Intent intent = new Intent(this, HourlyNotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.HOUR, 1);

        alarmManager.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_HOUR,
                pendingIntent
        );
    }
}