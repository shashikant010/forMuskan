package com.example.formuskan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formuskan.adapter.GalleryAdapter;


public class GalleryActivity extends AppCompatActivity {

    RecyclerView galleryRecyclerView;
    int[] imageIds = {
//            R.drawable.photo1, R.drawable.photo2, R.drawable.photo3,
//            R.drawable.photo4, R.drawable.photo5, R.drawable.photo6
            com.example.formuskan.R.drawable.ic_heart,R.drawable.ram,
            R.drawable.m1,R.drawable.m1,
            com.example.formuskan.R.drawable.m1,R.drawable.ram,
            com.example.formuskan.R.drawable.ic_heart,R.drawable.ic_heart,
            com.example.formuskan.R.drawable.ic_heart,R.drawable.ic_heart,
            com.example.formuskan.R.drawable.ic_heart,R.drawable.ic_heart,
            com.example.formuskan.R.drawable.ic_heart,R.drawable.ic_heart,
            // Add more images in drawable folder
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        galleryRecyclerView = findViewById(R.id.galleryRecyclerView);
        galleryRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        RecyclerView.Adapter adapter= new GalleryAdapter(this,imageIds);
        galleryRecyclerView.setAdapter(adapter);
    }
}
