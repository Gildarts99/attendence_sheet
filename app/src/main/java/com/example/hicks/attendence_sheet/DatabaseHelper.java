package com.example.hicks.attendence_sheet;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "user_manager";
    public static final String TABLE_STUDENTS = "students";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWRD = "password";
    public static final String KEY_FIRSTNAME = "first name";
    public static final String KEY_LASTNAME = "last name";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_STUDENTS + "TEXT" + KEY_USERNAME + "("
                + KEY_PASSWRD + " TEXT," + KEY_FIRSTNAME
                + " ,TEXT" + KEY_LASTNAME + " ,TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + KEY_USERNAME);

        onCreate(db);
    }

    public void addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("KEY_USERNAME", student.getUsername());
        values.put("KEY_PASSWRD" , student.getPasswrd());
        values.put("KEY_FIRSTNAME", student.getFirst_name());
        values.put("KEY_LASTNAME" , student.getLast_name());

        db.insert("TABLE_STUDENTS", null, values);
        db.close();
    }

    public Student getStudent(String username, String passwrd){
        SQLiteDatabase db = this.getReadableDatabase();

    }
}
