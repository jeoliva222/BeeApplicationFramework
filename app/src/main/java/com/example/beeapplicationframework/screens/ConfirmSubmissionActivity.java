package com.example.beeapplicationframework.screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfirmSubmissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_submission);

        final Button homebutton = (Button) findViewById(R.id.homeButton);
        homebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (ConfirmSubmissionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        // Do nothing
    }
}
