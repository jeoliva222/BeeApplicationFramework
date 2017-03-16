package com.example.beeapplicationframework;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LogBeeActivity_Flower extends AppCompatActivity {

    boolean wasGuided;
    String bee, head, thorax, abdomen;
    Bitmap imageBitmap;

    QuestionBranchList list; // List of last branches we visited
    QuestionFlagList flags; // List of current flags

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_bee__flower);

        this.wasGuided = Boolean.parseBoolean(getIntent().getStringExtra("WAS_GUIDED"));
        this.bee = getIntent().getStringExtra("BEE");
        this.head = getIntent().getStringExtra("HEAD");
        this.thorax = getIntent().getStringExtra("THORAX");
        this.abdomen = getIntent().getStringExtra("ABDOMEN");

        Bundle extras = getIntent().getExtras(); // Get bitmap from extras
        imageBitmap = (Bitmap) extras.get("data");

        ImageView img = (ImageView) findViewById(R.id.beeView); // Display the bee's picture on the screen
        img.setImageBitmap(imageBitmap);

        if(wasGuided) {
            this.list = (QuestionBranchList) getIntent().getSerializableExtra("LIST"); // Get the list of previous branches
            this.flags = (QuestionFlagList) getIntent().getSerializableExtra("FLAGS"); // Get the list of previous branches
        }
    }

    public void goToPartSliderActivity(View view) {
        Intent intent = new Intent(this, PartSliderActivity.class);

        intent.putExtra("data", imageBitmap);
        intent.putExtra("BEE", bee);
        if(wasGuided) {
            intent.putExtra("WAS_GUIDED", "True");
            intent.putExtra("LIST", list);
            intent.putExtra("FLAGS", flags);
        } else {
            intent.putExtra("WAS_GUIDED", "False");
        }
        startActivity(intent);
    }

    public void goToSubmitActivity(View view) {
        Intent intent = new Intent (this, SubmitLogActivity.class);

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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, PartSliderActivity.class);

        intent.putExtra("data", imageBitmap);
        intent.putExtra("BEE", bee);
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
