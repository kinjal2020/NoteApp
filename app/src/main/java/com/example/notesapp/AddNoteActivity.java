package com.example.notesapp;

import static com.example.notesapp.MainActivity.noteList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AddNoteActivity extends AppCompatActivity {

    EditText titleEditText, noteEditText;
    ImageView addNote;
    ImageView backHome;
    ImageView delete;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        initBinding();

        if (getIntent().getStringExtra("title") != null) {
            titleEditText.setText(getIntent().getStringExtra("title"));
            noteEditText.setText(getIntent().getStringExtra("note"));
            index = getIntent().getIntExtra("index", 0);
        }

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getIntent().getStringExtra("title") != null) {
                    noteList.remove(index);
                    finish();
                }else {
                    finish();
                }
            }
        });

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = titleEditText.getText().toString();
                String note = noteEditText.getText().toString();

                if (TextUtils.isEmpty(title) && TextUtils.isEmpty(note)) {
                    finish();
                } else {
                    if (getIntent().getStringExtra("title") != null) {
                        NoteModelClass noteModel = new NoteModelClass(title, note);
                        noteList.set(index, noteModel);
                        finish();
                    } else {
                        NoteModelClass noteModel = new NoteModelClass(title, note);
                        noteList.add(noteModel);
                        finish();
                    }
                }
            }
        });
    }

    private void initBinding() {
        titleEditText = findViewById(R.id.titleEditText);
        noteEditText = findViewById(R.id.noteEditText);
        addNote = findViewById(R.id.add);
        backHome = findViewById(R.id.backHome);
        delete = findViewById(R.id.delete);
    }
}