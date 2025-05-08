package com.example.formuskan;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FullscreenImageActivity extends AppCompatActivity {
    ImageView fullImageView;
    ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fullscreen_image);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fullImageView = findViewById(R.id.fullImageView);
        backArrow = findViewById(R.id.backArrow);

        backArrow.setOnClickListener(v -> {
            getOnBackPressedDispatcher().onBackPressed();
        });
        int imageResId = getIntent().getIntExtra("imageResId", 0);
        if (imageResId != 0) {
            fullImageView.setImageResource(imageResId);
        }
    }
}