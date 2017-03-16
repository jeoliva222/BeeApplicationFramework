package com.example.beeapplicationframework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Code by Obaro Ogbo
 * Modified by Jackson Oliva to suit project
 */

public class BeesDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Bees.db";
    private static final int DATABASE_VERSION = 1;
    public static final String BEE_TABLE_NAME = "bee";
    public static final String BEE_COLUMN_ID = "_id";
    public static final String BEE_COLUMN_NAME = "name";
    public static final String TYPE = "type";
    public static final String WEIGHT = "weight";
    public static final String HEAD = "head";
    public static final String THORAX = "thorax";
    public static final String ABDOMEN = "abdomen";
    public static final String BASE_COLOR = "BaseColor";
    public static final String ORANGE = "Orange";
    public static final String TOP_BLACK = "TopBlack";
    public static final String TDOT = "Tdot";
    public static final String TDOTSTRIPS = "Tdotstrips";
    public static final String TSTRIPE = "Tstripe";
    public static final String TBLACK = "Tblack";
    public static final String WINGBASE = "wingBase";
    public static final String HEAD_COLOR = "headColor";

    public BeesDBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + BEE_TABLE_NAME + "(" +
                BEE_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                BEE_COLUMN_NAME + " TEXT, " +
                TYPE + " TEXT, " +
                WEIGHT + " INTEGER, " +
                HEAD + " TEXT, " +
                THORAX + " TEXT, " +
                ABDOMEN + " TEXT, " +
                BASE_COLOR + " TEXT, " +
                ORANGE + " TEXT, " +
                TOP_BLACK + " TEXT, " +
                TDOT + " TEXT, " +
                TDOTSTRIPS + " TEXT, " +
                TSTRIPE + " TEXT, " +
                TBLACK + " TEXT, " +
                WINGBASE + " TEXT, " +
                HEAD_COLOR + " TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BEE_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertBee(String name, String type, int weight, String head, String thorax, String abdomen,
                             String bcolor, String orange, String topblack, String tdot, String tdotstrips,
                             String tstripe, String tblack, String wingbase, String headcolor) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BEE_COLUMN_NAME, name);
        contentValues.put(TYPE, type);
        contentValues.put(WEIGHT, weight);
        contentValues.put(HEAD, head);
        contentValues.put(THORAX, thorax);
        contentValues.put(ABDOMEN, abdomen);
        contentValues.put(BASE_COLOR, bcolor);
        contentValues.put(ORANGE, orange);
        contentValues.put(TOP_BLACK, topblack);
        contentValues.put(TDOT, tdot);
        contentValues.put(TDOTSTRIPS, tdotstrips);
        contentValues.put(TSTRIPE, tstripe);
        contentValues.put(TBLACK, tblack);
        contentValues.put(WINGBASE, wingbase);
        contentValues.put(HEAD_COLOR, headcolor);
        db.insert(BEE_TABLE_NAME, null, contentValues);
        return true;
    }

    public boolean updateBee(Integer id, String name, String type, int weight, String head, String thorax, String abdomen,
                             String bcolor, String orange, String topblack, String tdot, String tdotstrips,
                             String tstripe, String tblack, String wingbase, String headcolor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BEE_COLUMN_NAME, name);
        contentValues.put(TYPE, type);
        contentValues.put(WEIGHT, weight);
        contentValues.put(HEAD, head);
        contentValues.put(THORAX, thorax);
        contentValues.put(ABDOMEN, abdomen);
        contentValues.put(BASE_COLOR, bcolor);
        contentValues.put(ORANGE, orange);
        contentValues.put(TOP_BLACK, topblack);
        contentValues.put(TDOT, tdot);
        contentValues.put(TDOTSTRIPS, tdotstrips);
        contentValues.put(TSTRIPE, tstripe);
        contentValues.put(TBLACK, tblack);
        contentValues.put(WINGBASE, wingbase);
        contentValues.put(HEAD_COLOR, headcolor);
        db.update(BEE_TABLE_NAME, contentValues, BEE_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Cursor getBee(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + BEE_TABLE_NAME + " WHERE " +
                BEE_COLUMN_ID + "=?", new String[] { Integer.toString(id) } );
        return res;
    }
    public Cursor getAllBees() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + BEE_TABLE_NAME, null );
        return res;
    }

    public Integer deleteBee(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(BEE_TABLE_NAME,
                BEE_COLUMN_ID + " = ? ",
                new String[] { Integer.toString(id) });
    }

    public void removeAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + BEE_TABLE_NAME);
    }

}
