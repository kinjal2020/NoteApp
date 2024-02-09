package com.example.notesapp;

public class NoteModelClass {

    public String title,note;

    public NoteModelClass(String title,String note){
        this.title=title;
        this.note=note;
    }

    public String getNote() {
        return note;
    }
    public String getTitle(){
        return  title;
    }
}
