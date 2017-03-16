package com.example.beeapplicationframework;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LogBeeActivity_Menu extends AppCompatActivity {

    Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_bee__menu);

        Bundle extras = getIntent().getExtras();
        imageBitmap = (Bitmap) extras.get("data");

        ImageView img = (ImageView) findViewById(R.id.beeView);
        img.setImageBitmap(imageBitmap);

        final Button manbutton = (Button) findViewById(R.id.manualButton);
        manbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Menu.this, LogBeeActivity_Manual.class);
                intent.putExtra("data", imageBitmap);
                startActivity(intent);
            }
        });

        final Button autobutton = (Button) findViewById(R.id.helpButton);
        autobutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Menu.this, QuestionTreeBaseActivity.class);
                intent.putExtra("data", imageBitmap);
                startActivity(intent);
            }
        });

        final Button backbutton = (Button) findViewById(R.id.backButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Menu.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (LogBeeActivity_Menu.this, MainActivity.class);
        startActivity(intent);
    }
}
