package com.example.formuskan;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formuskan.adapter.VideoGridAdapter;

public class VideoGridActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    String[] names = {"Mom", "Dad", "Sister", "Best Friend"};
    int[] images = {R.drawable.ram, R.drawable.ram, R.drawable.ram, R.drawable.ram};
    int[] videos = {R.raw.test_vid, R.raw.test_vid, R.raw.test_vid, R.raw.test_vid};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video_grid);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.videoGridRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new VideoGridAdapter(this, names, images, videos));
    }
}