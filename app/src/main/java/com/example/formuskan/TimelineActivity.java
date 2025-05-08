package com.example.formuskan;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formuskan.adapter.TimelineAdapter;
import com.example.formuskan.model.MemoryItem;

import java.util.ArrayList;
import java.util.List;

public class TimelineActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TimelineAdapter adapter;
    List<MemoryItem> memoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_timeline);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.timelineRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        memoryList = new ArrayList<>();
        memoryList.add(new MemoryItem(R.drawable.ram, "12 Jan 2023", "Our first movie night 💑"));
        memoryList.add(new MemoryItem(R.drawable.m1, "14 Feb 2023", "Valentine's day gift 💝"));
        memoryList.add(new MemoryItem(R.drawable.ic_heart, "28 Mar 2023", "Your smile that melted my heart 😊"));

        adapter = new TimelineAdapter(memoryList);
        recyclerView.setAdapter(adapter);
    }
}