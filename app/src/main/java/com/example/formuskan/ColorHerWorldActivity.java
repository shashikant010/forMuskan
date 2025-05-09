package com.example.formuskan;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ColorHerWorldActivity extends AppCompatActivity {
    ImageView imageGray, imageColor;
    TextView loveMessage;
    boolean colored = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_her_world);

        imageGray = findViewById(R.id.imageGray);
        imageColor = findViewById(R.id.imageColor);
        loveMessage = findViewById(R.id.loveMessage);

        View layout = findViewById(R.id.colorWorldLayout);

        layout.setOnTouchListener((v, event) -> {
            if (!colored && (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE)) {
                colored = true;
                animateColoring();
            }
            return true;
        });
    }

    private void animateColoring() {
        imageColor.animate().alpha(1f).setDuration(1500).start();
        loveMessage.animate().alpha(1f).setDuration(2000).start();
    }
}
