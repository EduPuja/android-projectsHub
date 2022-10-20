package com.example.activityseven.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.activityseven.database.entities.StudentDB;

public class StudentElementHelper extends SQLiteOpenHelper {
    // if you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Students.db";

    public StudentElementHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StudentDB.StudentElementEntry.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(StudentDB.StudentElementEntry.DELETE_TABLE);
        onCreate(db);
    }
}
