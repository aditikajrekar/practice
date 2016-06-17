package com.example.aditi.practice;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aditi.practice.data.myDB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Aditi on 17-06-2016.
 */
public class entryactivity extends AppCompatActivity {
    EditText title, highlight, content, mood;
    Button savebtn;
    myDB mydb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        mydb = new myDB(this);
        initialiseViews();
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savetoDB();
            }
        });
    }

    public void initialiseViews() {
        title = (EditText) findViewById(R.id.edit1);
        highlight = (EditText) findViewById(R.id.edit2);
        content = (EditText) findViewById(R.id.edit3);
        mood = (EditText) findViewById(R.id.edit4);
        savebtn = (Button) findViewById(R.id.btn1);


    }

    public void savetoDB() {
        mydb.open();
        String entrytitle = title.getText().toString();
        String entryhighlight = highlight.getText().toString();
        String entrycontent = content.getText().toString();
        String entrymood = mood.getText().toString();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault());
        Date date = new Date();

        mydb.insertEntry(entrytitle, entrymood, entrycontent, sdf.format(date), entryhighlight);
        mydb.close();
        Log.d("Database Updayed", entrytitle + " added to db");

    }
}
