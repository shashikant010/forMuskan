package com.example.formuskan;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formuskan.adapter.LettersAdapter;
import com.example.formuskan.model.LetterItem;

import java.util.ArrayList;
import java.util.List;

public class LettersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LettersAdapter adapter;
    List<LetterItem> letterList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_letters);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.lettersRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        letterList = new ArrayList<>();
        letterList.add(new LetterItem("To Muskan in 2026", "You’re reading this in the future, and I hope you’re still smiling like you do now"));
        letterList.add(new LetterItem("On our wedding day", "Today is the day I hold your hand forever. I want to tell you something I may forget to say in all the excitement..."));
        letterList.add(new LetterItem("For your sad days", "Whenever you feel low, I want you to remember this letter and feel wrapped in my arms..."));

        adapter = new LettersAdapter(this, letterList);
        recyclerView.setAdapter(adapter);
    }
}