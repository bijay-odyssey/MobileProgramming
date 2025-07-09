package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "College.db";
    private static final String TABLE_NAME = "Student";
    private static final String COL_ROLL = "Roll";
    private static final String COL_NAME = "Name";
    private static final String COL_ADDRESS = "Address";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COL_ROLL + " INTEGER PRIMARY KEY, " + COL_NAME + " TEXT, " + COL_ADDRESS + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertStudent(int roll, String name, String address) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ROLL, roll);
        values.put(COL_NAME, name);
        values.put(COL_ADDRESS, address);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String[] getAllStudents() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{COL_ROLL, COL_NAME, COL_ADDRESS}, null, null, null, null, null);
        String[] students = new String[cursor.getCount()];
        int i = 0;
        while (cursor.moveToNext()) {
            students[i++] = cursor.getInt(0) + ": " + cursor.getString(1) + ", " + cursor.getString(2);
        }
        cursor.close();
        db.close();
        return students;
    }
}
