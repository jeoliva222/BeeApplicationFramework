package com.example.beeapplicationframework.objects;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jackson on 3/2/2017.
 */

public class MyLogsDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyLogs.db";
    private static final int DATABASE_VERSION = 1;
    public static final String LOG_TABLE_NAME = "logs";
    public static final String LOG_COLUMN_ID = "_id";
    public static final String LOG_COLUMN_SPECIES = "species";
    public static final String LOG_COLUMN_PICTURE = "picture";
    public static final String LOG_COLUMN_ISVIDEO = "isvideo";
    public static final String LOG_COLUMN_HEAD = "head";
    public static final String LOG_COLUMN_THORAX = "thorax";
    public static final String LOG_COLUMN_ABDOMEN = "abdomen";
    public static final String LOG_COLUMN_F_SHAPE = "fshape";
    public static final String LOG_COLUMN_F_COLOR = "fcolor";
    public static final String LOG_COLUMN_TIME = "time";


    public MyLogsDBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + LOG_TABLE_NAME + "(" +
                LOG_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                LOG_COLUMN_SPECIES + " TEXT, " +
                LOG_COLUMN_PICTURE + " TEXT, " +
                LOG_COLUMN_ISVIDEO + " INTEGER, " +
                LOG_COLUMN_HEAD + " TEXT, " +
                LOG_COLUMN_THORAX + " TEXT, " +
                LOG_COLUMN_ABDOMEN + " TEXT, " +
                LOG_COLUMN_F_SHAPE + " TEXT, " +
                LOG_COLUMN_F_COLOR + " TEXT, " +
                LOG_COLUMN_TIME + " TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LOG_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertLog(String species, String pic, int isVideo, String head, String thorax, String abdomen, String f_shape,
                             String f_color, String time) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LOG_COLUMN_SPECIES, species);
        contentValues.put(LOG_COLUMN_PICTURE, pic);
        contentValues.put(LOG_COLUMN_ISVIDEO, isVideo);
        contentValues.put(LOG_COLUMN_HEAD, head);
        contentValues.put(LOG_COLUMN_THORAX, thorax);
        contentValues.put(LOG_COLUMN_ABDOMEN, abdomen);
        contentValues.put(LOG_COLUMN_F_SHAPE, f_shape);
        contentValues.put(LOG_COLUMN_F_COLOR, f_color);
        contentValues.put(LOG_COLUMN_TIME, time);
        db.insert(LOG_TABLE_NAME, null, contentValues);
        return true;
    }

    public boolean updateLog(Integer id, String species, String pic, int isVideo, String head, String thorax, String abdomen, String f_shape,
                             String f_color, String time) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LOG_COLUMN_SPECIES, species);
        contentValues.put(LOG_COLUMN_PICTURE, pic);
        contentValues.put(LOG_COLUMN_ISVIDEO, isVideo);
        contentValues.put(LOG_COLUMN_HEAD, head);
        contentValues.put(LOG_COLUMN_THORAX, thorax);
        contentValues.put(LOG_COLUMN_ABDOMEN, abdomen);
        contentValues.put(LOG_COLUMN_F_SHAPE, f_shape);
        contentValues.put(LOG_COLUMN_F_COLOR, f_color);
        contentValues.put(LOG_COLUMN_TIME, time);
        db.update(LOG_TABLE_NAME, contentValues, LOG_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Cursor getLog(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + LOG_TABLE_NAME + " WHERE " +
                LOG_COLUMN_ID + "=?", new String[] { Integer.toString(id) } );
        return res;
    }
    public Cursor getAllLogs() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + LOG_TABLE_NAME, null );
        return res;
    }

    public Integer deleteLog(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(LOG_TABLE_NAME,
                LOG_COLUMN_ID + " = ? ",
                new String[] { Integer.toString(id) });
    }

    public void removeAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + LOG_TABLE_NAME);
    }

    public void deleteTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + LOG_TABLE_NAME);
    }
}
