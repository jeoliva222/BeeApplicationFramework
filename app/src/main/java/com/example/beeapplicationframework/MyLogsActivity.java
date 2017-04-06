package com.example.beeapplicationframework;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.beeapplicationframework.MyLogsDBHelper.LOG_COLUMN_ID;
import static com.example.beeapplicationframework.MyLogsDBHelper.LOG_COLUMN_SPECIES;

public class MyLogsActivity extends AppCompatActivity {

    MyLogsDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_logs);

        dbHelper = new MyLogsDBHelper(this);

        Cursor c = dbHelper.getAllLogs();
        int count = c.getCount();
        LinearLayout ll = (LinearLayout)findViewById(R.id.LogLayout);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        if (!(c.moveToFirst()) || count == 0){
            //cursor is empty
        } else {
            c.moveToFirst();
            for(int x = 0; x < count; x++) {
                Long id = c.getLong(
                        c.getColumnIndexOrThrow(LOG_COLUMN_ID)
                );
                String sid = id.toString();
                String name = c.getString(
                        c.getColumnIndexOrThrow(LOG_COLUMN_SPECIES)
                );

                TextView testview = new TextView(this);
                testview.setText(sid + ": " + name + " / ");

                ll.addView(testview, lp);
                c.moveToNext();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}
