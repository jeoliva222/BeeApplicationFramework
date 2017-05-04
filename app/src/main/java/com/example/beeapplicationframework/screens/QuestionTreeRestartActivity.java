package com.example.beeapplicationframework.screens;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.beeapplicationframework.objects.*;

public class QuestionTreeRestartActivity extends AppCompatActivity {

    Bitmap imageBitmap;
    QuestionBranchList list; // List of last branches we visited
    QuestionFlagList flags; // List of current flags
    String photoPath;
    Boolean fromVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_tree_restart);

        this.fromVideo = Boolean.parseBoolean(getIntent().getStringExtra("fromVideo"));

        this.photoPath = getIntent().getStringExtra("PHOTO_PATH");

        Bundle extras = getIntent().getExtras();
        imageBitmap = (Bitmap) extras.get("data");

        this.list = (QuestionBranchList) getIntent().getSerializableExtra("LIST"); // Get the list of previous branches
        this.flags = (QuestionFlagList) getIntent().getSerializableExtra("FLAGS"); // Get the list of previous branches

        final Button backbutton = (Button) findViewById(R.id.backButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                QuestionBranch qb = (QuestionBranch) list.popBranch();

                Intent intent = new Intent (QuestionTreeRestartActivity.this, QuestionTreeBranchActivity.class);

                intent.putExtra("data", imageBitmap);
                intent.putExtra("PHOTO_PATH", photoPath);
                intent.putExtra("fromVideo", fromVideo.toString());
                intent.putExtra("LIST", list);
                intent.putExtra("NEXT_BRANCH", qb);
                intent.putExtra("FLAGS", flags);
                startActivity(intent);
            }
        });

        final Button restartbutton = (Button) findViewById(R.id.restartButton);
        restartbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                list.clearList();
                flags.clearList();

                Intent intent = new Intent (QuestionTreeRestartActivity.this, QuestionTreeBaseActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("PHOTO_PATH", photoPath);
                intent.putExtra("fromVideo", fromVideo.toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        QuestionBranch qb = (QuestionBranch) list.popBranch();

        Intent intent = new Intent (QuestionTreeRestartActivity.this, QuestionTreeBranchActivity.class);

        intent.putExtra("data", imageBitmap);
        intent.putExtra("PHOTO_PATH", photoPath);
        intent.putExtra("fromVideo", fromVideo.toString());
        intent.putExtra("LIST", list);
        intent.putExtra("NEXT_BRANCH", qb);
        intent.putExtra("FLAGS", flags);
        startActivity(intent);
    }
}
