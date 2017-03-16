package com.example.beeapplicationframework;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class QuestionTreeBaseActivity extends AppCompatActivity {

    Bitmap imageBitmap;
    QuestionBranchList list;
    QuestionFlagList flags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_tree_base);

        Bundle extras = getIntent().getExtras();
        imageBitmap = (Bitmap) extras.get("data");

        ImageView img = (ImageView) findViewById(R.id.beeView);
        img.setImageBitmap(imageBitmap);

        list = new QuestionBranchList();
        flags = new QuestionFlagList();

        final Button blackbutton = (Button) findViewById(R.id.blackButton);
        blackbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (QuestionTreeBaseActivity.this, QuestionTreeBranchActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("STATE", 0);
                intent.putExtra("LIST", list);

                flags.addBranch("BaseColor", "black");
                intent.putExtra("FLAGS", flags);
                startActivity(intent);
            }
        });

        final Button halfbutton = (Button) findViewById(R.id.halfButton);
        halfbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (QuestionTreeBaseActivity.this, QuestionTreeBranchActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("STATE", 1);
                intent.putExtra("LIST", list);

                flags.addBranch("BaseColor", "half");
                intent.putExtra("FLAGS", flags);
                startActivity(intent);
            }
        });

        final Button yellowbutton = (Button) findViewById(R.id.yellowButton);
        yellowbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (QuestionTreeBaseActivity.this, QuestionTreeBranchActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("STATE", 2);
                intent.putExtra("LIST", list);

                flags.addBranch("BaseColor", "yellow");
                intent.putExtra("FLAGS", flags);
                startActivity(intent);
            }
        });

        final Button backbutton = (Button) findViewById(R.id.backButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (QuestionTreeBaseActivity.this, LogBeeActivity_Menu.class);
                intent.putExtra("data", imageBitmap);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (QuestionTreeBaseActivity.this, LogBeeActivity_Menu.class);
        intent.putExtra("data", imageBitmap);
        startActivity(intent);
    }
}
