package com.example.beeapplicationframework.screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Tutorial2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial2);
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    public void goToTutorialActivity(View view) {
        Intent intent = new Intent (this, TutorialActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (this, TutorialActivity.class);
        startActivity(intent);
    }
}
