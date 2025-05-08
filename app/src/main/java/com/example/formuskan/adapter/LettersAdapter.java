package com.example.formuskan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formuskan.LetterDetailActivity;
import com.example.formuskan.R;
import com.example.formuskan.model.LetterItem;

import java.util.List;

public class LettersAdapter extends RecyclerView.Adapter<LettersAdapter.LetterViewHolder> {

    Context context;
    List<LetterItem> letters;

    public LettersAdapter(Context context, List<LetterItem> letters) {
        this.context = context;
        this.letters = letters;
    }

    @NonNull
    @Override
    public LetterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_letter, parent, false);
        return new LetterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LetterViewHolder holder, int position) {
        LetterItem item = letters.get(position);
        holder.letterTitle.setText(item.title);
        holder.letterSnippet.setText(item.content);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, LetterDetailActivity.class);
            intent.putExtra("title", item.title);
            intent.putExtra("content", item.content);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return letters.size();
    }

    static class LetterViewHolder extends RecyclerView.ViewHolder {
        TextView letterTitle, letterSnippet;

        public LetterViewHolder(@NonNull View itemView) {
            super(itemView);
            letterTitle = itemView.findViewById(R.id.letterTitle);
            letterSnippet = itemView.findViewById(R.id.letterSnippet);
        }
    }
}
