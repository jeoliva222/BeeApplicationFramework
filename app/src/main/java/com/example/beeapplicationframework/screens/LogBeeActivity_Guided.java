package com.example.beeapplicationframework.screens;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogBeeActivity_Guided extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_bee__guided);
    }

    public void goToLBFlowerActivity(View view) {
        Bundle extras = getIntent().getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        Intent intent = new Intent (this, LogBeeActivity_Flower.class);
        intent.putExtra("data", imageBitmap);
        intent.putExtra("WAS_GUIDED", "True");
        startActivity(intent);
    }

    public void goToLBMenuActivity(View view) {
        Bundle extras = getIntent().getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        Intent intent = new Intent (this, LogBeeActivity_Menu.class);
        intent.putExtra("data", imageBitmap);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Bundle extras = getIntent().getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        Intent intent = new Intent (this, LogBeeActivity_Menu.class);
        intent.putExtra("data", imageBitmap);
        startActivity(intent);
    }
}
