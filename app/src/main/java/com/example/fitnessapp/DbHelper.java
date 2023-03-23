package com.example.fitnessapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Login.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table users(username TEXT, password TEXT)");
        db.execSQL("CREATE table workouts(name TEXT, description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists workouts");
    }

    public boolean insertUsernamePassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);

        long result = db.insert("users", null, values);

        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkUsername(String username) {
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from users WHERE username=?", new String[] {username});
        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkUsernamePassword(String username,String password) {
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username=? AND password=?", new String[] {username,password});
        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }

    }
}