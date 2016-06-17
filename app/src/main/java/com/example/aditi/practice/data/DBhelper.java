package com.example.aditi.practice.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;

/**
 * Created by Aditi on 16-06-2016.
 */
public class DBhelper extends SQLiteOpenHelper {

    private static final String CREATE_TABLE = " create table " +
            constants.TABLE_NAME  + " ("+
            constants.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            constants.TITLE_NAME + " TEXT NOT NULL, " +
            constants.CONTENT_NAME + " TEXT NOT NULL, " +
            constants.MOOD + " TEXT NOT NULL, " +
            constants.DATE_NAME + " TEXT NOT NULL) " ;

    public DBhelper(Context c)
    {

        super(c,constants.DATABASE_NAME,null, constants.DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("drop table if exists" + constants.TABLE_NAME);
        onCreate(db);
    }

}
