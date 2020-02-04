package com.example.consumerapp.db;

import android.net.Uri;
import android.provider.BaseColumns;

public class DatabaseContract {
    public static final String AUTHOTY = "com.example.mynotesapp";
    private static final String SCHEME = "content";

    public static String TABLE_NAME = "note";

    public static final class NoteColumns implements BaseColumns{
        public static String TITLE = "title";
        public static String DESCRIPTIOn = "description";
        public static String DATE = "date";
        //untuk membuat URI content "com.example.mynotesapp.entity/note"

        public static final Uri CONTENT_URI = new Uri.Builder().scheme(SCHEME)
                .authority(AUTHOTY)
                .appendPath(TABLE_NAME)
                .build();
    }


}
