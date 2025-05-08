package com.example.formuskan;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class LoveMeterActivity extends AppCompatActivity {

    ImageView heartView;
    Button testLoveBtn;
    TextView percentageText;
    LinearLayout loveErrorBox;
    RelativeLayout loveMeterLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_love_meter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.loveMeterLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        heartView = findViewById(R.id.heartView);
        testLoveBtn = findViewById(R.id.testLoveBtn);
        percentageText = findViewById(R.id.percentageText);
        loveErrorBox = findViewById(R.id.loveErrorBox);
        loveMeterLayout = findViewById(R.id.loveMeterLayout);

        testLoveBtn.setOnClickListener(v -> startLoveAnimation());
    }

    private void startLoveAnimation() {
        testLoveBtn.setEnabled(false);
        percentageText.setVisibility(View.VISIBLE);

        ValueAnimator animator = ValueAnimator.ofInt(0, 1000);
        animator.setDuration(3000);
        animator.setInterpolator(new AccelerateInterpolator());

        animator.addUpdateListener(animation -> {
            int value = (int) animation.getAnimatedValue();
            percentageText.setText(value + "%");

            // Optionally scale the heart slightly
            heartView.setScaleX(1 + (value / 1000f));
            heartView.setScaleY(1 + (value / 1000f));

            // Gradually change background to red
            if (value > 800) {
                loveMeterLayout.setBackgroundColor(Color.rgb(255, 50 + (value % 200), 100));
            }

            if (value == 1000) {
                showLoveError();
            }
        });

        animator.start();
    }

    private void showLoveError() {
        new Handler().postDelayed(() -> {
            loveErrorBox.setVisibility(View.VISIBLE);
            YoYo.with(Techniques.BounceIn) // Add animation if using 'YoYo' lib
                    .duration(700)
                    .playOn(loveErrorBox);
        }, 300);
    }
}
