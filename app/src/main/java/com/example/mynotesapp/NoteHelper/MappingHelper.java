package com.example.mynotesapp.NoteHelper;

import android.database.Cursor;

import com.example.mynotesapp.db.DatabaseContract;
import com.example.mynotesapp.entity.Note;

import java.util.ArrayList;

public class MappingHelper {
    public static ArrayList<Note> mapCursorToArrayList(Cursor noteCursor){
        ArrayList<Note> noteList = new ArrayList<>();

        while (noteCursor.moveToNext()){
            int id = noteCursor.getInt(noteCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID));
            String title = noteCursor.getString(noteCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE));
            String description = noteCursor.getString(noteCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTIOn));
            String date = noteCursor.getString(noteCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE));
            noteList.add(new Note(id,title,description,date));
        }

        return noteList;
    }
}
