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
        memoryList.add(new MemoryItem(R.drawable.call_ss, "11 July 2020", "First Video Call Screenshot i have 📲❤️"));
        memoryList.add(new MemoryItem(R.drawable.first_meet, "22 July 2020", "First Meed of us 🧑‍🤝‍🧑💕"));
        memoryList.add(new MemoryItem(R.drawable.eat_momo, "12 Oct 2020", "Eating Momos together 🍴😀"));
        memoryList.add(new MemoryItem(R.drawable.eat_pizza, "21 Dec 2020", "Eating Pizza together 🍕😍"));
        memoryList.add(new MemoryItem(R.drawable.went_church, "25 Dec 2020", "Went church Together for the first time ⛪❤️"));
        memoryList.add(new MemoryItem(R.drawable.first_ring, "4 Jan 2021", "Proposed You with Ring in class"));
        memoryList.add(new MemoryItem(R.drawable.first_rose, "14 Feb 2021", "First rose by me 🌹🌹"));
        memoryList.add(new MemoryItem(R.drawable.first_bday, "10 May 2021", "Your first birthday with me 🎂❤️"));
        memoryList.add(new MemoryItem(R.drawable.long_meet, "1 March 2022", "Our first meet after Long Distance ✈(❁´◡`❁)"));
        memoryList.add(new MemoryItem(R.drawable.first_train2, "3 July 2024", "Our First Train Trip 🚂"));
        memoryList.add(new MemoryItem(R.drawable.first_wedding, "22 Nov 2024", "First Wedding we attended Together ❤️"));
        memoryList.add(new MemoryItem(R.drawable.first_friend, "23 Feb 2025", "First Long trip with friends"));


        adapter = new TimelineAdapter(memoryList);
        recyclerView.setAdapter(adapter);
    }
}