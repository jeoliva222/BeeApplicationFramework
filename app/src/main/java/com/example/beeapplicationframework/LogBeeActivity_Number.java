package com.example.beeapplicationframework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogBeeActivity_Number extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_bee__number);
    }

    public void goToLogBeeActivity(View view) {
        Intent intent = new Intent (this, LogBeeActivity_Manual.class);
        startActivity(intent);
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}
