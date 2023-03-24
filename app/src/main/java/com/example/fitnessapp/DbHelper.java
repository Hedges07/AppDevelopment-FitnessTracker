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
        db.execSQL("CREATE table workouts(username TEXT, description TEXT, date TEXT)");
        db.execSQL("CREATE table favWorkouts(username TEXT, description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists workouts");
        db.execSQL("drop table if exists favWorkouts");
        onCreate(db);
    }

    public boolean insertWorkouts(String username, String description, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("description", description);
        values.put("date", date);

        long result = db.insert("workouts", null, values);

        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean insertFavWorkouts(String username, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("description", description);

        long result = db.insert("FavWorkouts", null, values);

        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean insertUsernamePassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        ContentValues values2 = new ContentValues();
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