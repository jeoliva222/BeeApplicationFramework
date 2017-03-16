package com.example.beeapplicationframework;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SubmitLogActivity extends AppCompatActivity {

    boolean wasGuided;
    String bee, head, thorax, abdomen;
    Bitmap imageBitmap;

    QuestionBranchList list; // List of last branches we visited
    QuestionFlagList flags; // List of current flags

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_log);

        this.wasGuided = Boolean.parseBoolean(getIntent().getStringExtra("WAS_GUIDED"));
        this.bee = getIntent().getStringExtra("BEE");
        this.head = getIntent().getStringExtra("HEAD");
        this.thorax = getIntent().getStringExtra("THORAX");
        this.abdomen = getIntent().getStringExtra("ABDOMEN");

        Bundle extras = getIntent().getExtras(); // Get bitmap from extras
        imageBitmap = (Bitmap) extras.get("data");

        if(wasGuided) {
            this.list = (QuestionBranchList) getIntent().getSerializableExtra("LIST"); // Get the list of previous branches
            this.flags = (QuestionFlagList) getIntent().getSerializableExtra("FLAGS"); // Get the list of previous branches
        }

        ImageView beeimg = (ImageView) findViewById(R.id.beeView); // Display the bee's picture on the screen
        beeimg.setImageBitmap(imageBitmap);

        Resources res = getResources();

        ImageView headimg = (ImageView) findViewById(R.id.headView); // Display the bee's head coloration on the screen
        int headID = res.getIdentifier(head, "mipmap", getPackageName());
        headimg.setImageResource(headID);

        ImageView thoraximg = (ImageView) findViewById(R.id.thoraxView); // Display the bee's thorax coloration on the screen
        int thoraxID = res.getIdentifier(thorax, "mipmap", getPackageName());
        thoraximg.setImageResource(thoraxID);

        ImageView abdomenimg = (ImageView) findViewById(R.id.abdomenView); // Display the bee's abdomen coloration on the screen
        int abdomenID = res.getIdentifier(abdomen, "mipmap", getPackageName());
        abdomenimg.setImageResource(abdomenID);

        TextView speciesText = (TextView) findViewById(R.id.speciesText);
        speciesText.setText("Bombus " + bee);

        final Button backbutton = (Button) findViewById(R.id.backButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (SubmitLogActivity.this, LogBeeActivity_Flower.class);

                intent.putExtra("data", imageBitmap);
                intent.putExtra("BEE", bee);
                intent.putExtra("HEAD", head);
                intent.putExtra("THORAX", thorax);
                intent.putExtra("ABDOMEN", abdomen);

                if(wasGuided) {
                    intent.putExtra("WAS_GUIDED", "True");
                    intent.putExtra("LIST", list);
                    intent.putExtra("FLAGS", flags);
                } else {
                    intent.putExtra("WAS_GUIDED", "False");
                }

                startActivity(intent);
            }
        });

        final Button submitbutton = (Button) findViewById(R.id.submitButton);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (SubmitLogActivity.this, ConfirmSubmissionActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (SubmitLogActivity.this, LogBeeActivity_Flower.class);

        intent.putExtra("data", imageBitmap);
        intent.putExtra("BEE", bee);
        intent.putExtra("HEAD", head);
        intent.putExtra("THORAX", thorax);
        intent.putExtra("ABDOMEN", abdomen);

        if(wasGuided) {
            intent.putExtra("WAS_GUIDED", "True");
            intent.putExtra("LIST", list);
            intent.putExtra("FLAGS", flags);
        } else {
            intent.putExtra("WAS_GUIDED", "False");
        }

        startActivity(intent);
    }
}
