package com.example.formuskan;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formuskan.adapter.NotesAdapter;

public class NotesActivity extends AppCompatActivity {

    RecyclerView notesRecyclerView;
    String[] notes = {
            "Every moment with you is a memory I cherish forever. 💖",
            "You light up my world more than any birthday candle ever could. ✨",
            "You're not just my girlfriend — you're my sunshine. ☀️",
            "I thank the universe every day for bringing you into my life. 🌌",
            "Happy Birthday to the girl who makes my heart skip a beat. 💓",
            "I love you more with each passing second, Muskan. 🕰️❤️",
            "kaali saari par kadhai nhi hoti.. jaanu aapki yaad me padhai nhi hoti..fshfianwaefiuhfiwaninefwaf\nfbeawififbhbawb\nefwfe\nfewf",
            "Every moment with you is a memory I cherish forever. 💖",
            "You light up my world more than any birthday candle ever could. ✨",
            "You're not just my girlfriend — you're my sunshine. ☀️",
            "I thank the universe every day for bringing you into my life. 🌌",
            "Happy Birthday to the girl who makes my heart skip a beat. 💓",
            "I love you more with each passing second, Muskan. 🕰️❤️",
            "kaali saari par kadhai nhi hoti.. jaanu aapki yaad me padhai nhi hoti..fshfianwaefiuhfiwaninefwaf\nfbeawififbhbawb\nefwfe\nfewf"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        notesRecyclerView = findViewById(R.id.notesRecyclerView);
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesRecyclerView.setAdapter(new NotesAdapter(this, notes));


    }
}