package com.example.formuskan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {


    Button  btnGallery, btnNotes, btnVideo, btnTImeline, btnFuture,loveMeter,btnScratch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnGallery = findViewById(R.id.btnGallery);
        btnNotes = findViewById(R.id.btnNotes);
        btnVideo = findViewById(R.id.btnVideo);
        loveMeter = findViewById(R.id.loveMeterBtn);
        btnTImeline = findViewById(R.id.btnTimeline);
        btnFuture = findViewById(R.id.btnFuture);
        btnScratch = findViewById(R.id.btnScratch);



        btnGallery.setOnClickListener(v -> startActivity(new Intent(this, GalleryActivity.class)));
        btnNotes.setOnClickListener(v -> startActivity(new Intent(this, NotesActivity.class)));
        btnVideo.setOnClickListener(v -> startActivity(new Intent(this, VideoGridActivity.class)));
        loveMeter.setOnClickListener(v -> startActivity(new Intent(this, LoveMeterActivity.class)));
        btnTImeline.setOnClickListener(v->{startActivity(new Intent(this,TimelineActivity.class));});
        btnFuture.setOnClickListener(v->{startActivity(new Intent(this,LettersActivity.class));});
        btnScratch.setOnClickListener(v->{startActivity(new Intent(this,ScratchActivityCard.class));});



    }
}