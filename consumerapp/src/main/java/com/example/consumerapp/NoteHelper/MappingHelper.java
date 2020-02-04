package com.example.consumerapp.NoteHelper;

import android.database.Cursor;

import com.example.consumerapp.db.DatabaseContract;
import com.example.consumerapp.entity.Note;

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

    public static Note mapCursorToObject(Cursor notesCursor) {
        notesCursor.moveToFirst();
        int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID));
        String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE));
        String description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTIOn));
        String date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE));
        return new Note(id, title, description, date);
    }
}
