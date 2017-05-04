package com.example.beeapplicationframework.screens;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.example.beeapplicationframework.objects.*;

import static com.example.beeapplicationframework.objects.ExampleDBHelper.PERSON_COLUMN_AGE;
import static com.example.beeapplicationframework.objects.ExampleDBHelper.PERSON_COLUMN_GENDER;
import static com.example.beeapplicationframework.objects.ExampleDBHelper.PERSON_COLUMN_ID;
import static com.example.beeapplicationframework.objects.ExampleDBHelper.PERSON_COLUMN_NAME;


public class SQLTestActivity extends AppCompatActivity {

    ExampleDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqltest);

        dbHelper = new ExampleDBHelper(this);

        final Button backbutton = (Button) findViewById(R.id.backButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (SQLTestActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        final Button addbutton = (Button) findViewById(R.id.addButton);
        addbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (SQLTestActivity.this, SQLInsertActivity.class);
                startActivity(intent);
            }
        });

        final Button deletebutton = (Button) findViewById(R.id.deleteButton);
        deletebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dbHelper.removeAll();

                Intent intent = new Intent (SQLTestActivity.this, SQLTestActivity.class);
                startActivity(intent);
            }
        });


        Cursor c = dbHelper.getAllPersons();
        int count = c.getCount();
        LinearLayout ll = (LinearLayout)findViewById(R.id.personLayout);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        if (!(c.moveToFirst()) || count == 0){
            //cursor is empty
        } else {
            c.moveToFirst();
            for(int x = 0; x < count; x++) {
                Long id = c.getLong(
                        c.getColumnIndexOrThrow(PERSON_COLUMN_ID)
                );
                String sid = id.toString();
                String name = c.getString(
                        c.getColumnIndexOrThrow(PERSON_COLUMN_NAME)
                );
                String gender = c.getString(
                        c.getColumnIndexOrThrow(PERSON_COLUMN_GENDER)
                );
                int age = c.getInt(
                        c.getColumnIndexOrThrow(PERSON_COLUMN_AGE)
                );
                String sage = String.valueOf(age);

                TextView testview = new TextView(this);
                testview.setText(sid + ": " + name + " / " + gender + " / Age = " + sage);

                ll.addView(testview, lp);
                c.moveToNext();
            }
        }

    }
}
