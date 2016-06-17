package com.example.aditi.practice.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.SyncStateContract;

/**
 * Created by Aditi on 16-06-2016.
 */
public class myDB {
    private SQLiteDatabase db;
    private DBhelper dBhelper;

    public myDB (Context c){
        dBhelper = new DBhelper(c);
    }
    public void open() {


        db = dBhelper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }
    public long insertEntry(String title,String mood,String content,String date, String highlight){
        ContentValues cv = new ContentValues();
        cv.put(constants.TITLE_NAME,title);
        cv.put(constants.CONTENT_NAME,content);
        cv.put(constants.MOOD,mood);
        cv.put(constants.DATE_NAME,date);
        return db.insert(constants.TABLE_NAME,null,cv);
    }
}
