package com.example.beeapplicationframework;

import android.content.Context;
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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
