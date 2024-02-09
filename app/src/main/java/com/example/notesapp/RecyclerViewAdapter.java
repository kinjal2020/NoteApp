package com.example.notesapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.DataViewHolder> {

    MainActivity activity;
    List<NoteModelClass> noteList;

    RecyclerViewAdapter(MainActivity activity, List<NoteModelClass> list) {
        this.activity = activity;
        this.noteList = list;
    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.custom_list_view, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.DataViewHolder holder, int position) {
        holder.title.setText(noteList.get(position).getTitle());
        holder.note.setText(noteList.get(position).getNote());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, AddNoteActivity.class);
                intent.putExtra("title", noteList.get(position).getTitle());
                intent.putExtra("note", noteList.get(position).getNote());
                intent.putExtra("index",position);
                activity.startActivity(intent);
            }
        });
    }

    class DataViewHolder extends RecyclerView.ViewHolder {
        TextView title, note;
        CardView cardView;

        public DataViewHolder(@NonNull View itemView) {

            super(itemView);
            title = itemView.findViewById(R.id.titleTextView);
            note = itemView.findViewById(R.id.noteTextView);
            cardView = itemView.findViewById(R.id.cardView);


        }
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
