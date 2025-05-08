package com.example.formuskan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formuskan.R;
import com.example.formuskan.model.MemoryItem;

import java.util.List;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder> {

    List<MemoryItem> memoryList;

    public TimelineAdapter(List<MemoryItem> memoryList) {
        this.memoryList = memoryList;
    }

    @NonNull
    @Override
    public TimelineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(com.example.formuskan.R.layout.item_timeline, parent, false);
        return new TimelineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimelineViewHolder holder, int position) {
        MemoryItem item = memoryList.get(position);
        holder.imageMemory.setImageResource(item.imageResId);
        holder.textMemoryDate.setText(item.date);
        holder.textMemoryDesc.setText(item.description);
    }

    @Override
    public int getItemCount() {
        return memoryList.size();
    }

    static class TimelineViewHolder extends RecyclerView.ViewHolder {
        ImageView imageMemory;
        TextView textMemoryDate, textMemoryDesc;

        public TimelineViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMemory = itemView.findViewById(R.id.imageMemory);
            textMemoryDate = itemView.findViewById(R.id.textMemoryDate);
            textMemoryDesc = itemView.findViewById(R.id.textMemoryDesc);
        }
    }
}

