package com.example.beeapplicationframework.screens;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.beeapplicationframework.objects.*;

import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;
import static android.content.Intent.FLAG_GRANT_WRITE_URI_PERMISSION;
import static com.example.beeapplicationframework.objects.MyLogsDBHelper.LOG_COLUMN_ABDOMEN;
import static com.example.beeapplicationframework.objects.MyLogsDBHelper.LOG_COLUMN_F_COLOR;
import static com.example.beeapplicationframework.objects.MyLogsDBHelper.LOG_COLUMN_F_SHAPE;
import static com.example.beeapplicationframework.objects.MyLogsDBHelper.LOG_COLUMN_HEAD;
import static com.example.beeapplicationframework.objects.MyLogsDBHelper.LOG_COLUMN_ID;
import static com.example.beeapplicationframework.objects.MyLogsDBHelper.LOG_COLUMN_ISVIDEO;
import static com.example.beeapplicationframework.objects.MyLogsDBHelper.LOG_COLUMN_PICTURE;
import static com.example.beeapplicationframework.objects.MyLogsDBHelper.LOG_COLUMN_SPECIES;
import static com.example.beeapplicationframework.objects.MyLogsDBHelper.LOG_COLUMN_THORAX;
import static com.example.beeapplicationframework.objects.MyLogsDBHelper.LOG_COLUMN_TIME;


public class MyLogsActivity extends AppCompatActivity {

    MyLogsDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_logs);

        dbHelper = new MyLogsDBHelper(this);

        final Button backbutton = (Button) findViewById(R.id.backButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (MyLogsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        final Button deletebutton = (Button) findViewById(R.id.deleteButton);
        deletebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dbHelper.removeAll();

                Intent intent = new Intent (MyLogsActivity.this, MyLogsActivity.class);
                startActivity(intent);
            }
        });

        // Iterate through all log instances and create a layout showing information for each one
        Cursor c = dbHelper.getAllLogs();
        int count = c.getCount();
        LinearLayout ll = (LinearLayout)findViewById(R.id.LogLayout);
        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp1.setMargins(0, 0, 0, 10);

        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 0.7f);
        LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 0.3f);

        if (!(c.moveToFirst()) || count == 0){
            //cursor is empty
        } else {
            c.moveToFirst();
            for(int x = 0; x < count; x++) {
                Long id = c.getLong(
                        c.getColumnIndexOrThrow(LOG_COLUMN_ID)
                );
                String sid = id.toString();

                final String name = c.getString(
                        c.getColumnIndexOrThrow(LOG_COLUMN_SPECIES)
                );
                String abbre_name;
                if(name.length() > 9) {
                    abbre_name = name.substring(0, 1).toUpperCase() + name.substring(1, 9) + ".";
                } else {
                    abbre_name = name.substring(0, 1).toUpperCase() + name.substring(1);
                }

                String time = c.getString(
                        c.getColumnIndexOrThrow(LOG_COLUMN_TIME)
                );
                String formatted_date = time.substring(4, 6) + "/" + time.substring(6, 8) + "/" + time.substring(0, 4);

                final String photoPath = c.getString(
                        c.getColumnIndexOrThrow(LOG_COLUMN_PICTURE)
                );

                int tester = c.getInt(
                        c.getColumnIndexOrThrow(LOG_COLUMN_ISVIDEO)
                );
                final String isVideo;
                if(tester == 1) {
                    isVideo = "True";
                } else {
                    isVideo = "False";
                }

                final String head = c.getString(
                        c.getColumnIndexOrThrow(LOG_COLUMN_HEAD)
                );

                final String thorax = c.getString(
                        c.getColumnIndexOrThrow(LOG_COLUMN_THORAX)
                );

                final String abdomen = c.getString(
                        c.getColumnIndexOrThrow(LOG_COLUMN_ABDOMEN)
                );

                final String f_color = c.getString(
                        c.getColumnIndexOrThrow(LOG_COLUMN_F_COLOR)
                );

                final String f_shape = c.getString(
                        c.getColumnIndexOrThrow(LOG_COLUMN_F_SHAPE)
                );

                TextView testview = new TextView(this);
                testview.setTextSize(20);
                testview.setText(sid + ": " + abbre_name + " | " + formatted_date);

                // Controller for 'Inspect' Button
                Button inspectButton = new Button(this);
                inspectButton.setText("Inspect Log " + sid);
                inspectButton.setBackgroundColor(Color.parseColor("#f6f4b8"));
                inspectButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent (MyLogsActivity.this, InspectLogActivity.class);
                        intent.putExtra("PHOTO_PATH", photoPath);
                        intent.putExtra("fromVideo", isVideo);
                        intent.putExtra("BEE", name);
                        intent.putExtra("HEAD", head);
                        intent.putExtra("THORAX", thorax);
                        intent.putExtra("ABDOMEN", abdomen);
                        intent.putExtra("F_COLOR", f_color);
                        intent.putExtra("F_SHAPE", f_shape);
                        intent.addFlags(FLAG_GRANT_READ_URI_PERMISSION | FLAG_GRANT_WRITE_URI_PERMISSION);
                        startActivity(intent);
                    }
                });

                LinearLayout hl = new LinearLayout(this);
                hl.setOrientation(LinearLayout.HORIZONTAL);
                hl.setWeightSum(1.0f);
                hl.addView(testview, lp2);
                hl.addView(inspectButton, lp3);


                ll.addView(hl, lp1);
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
