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

public class InspectBeeActivity extends AppCompatActivity {

    TextView latinText;
    TextView commonText;
    ImageView beeView;
    TextView habitatText;
    TextView activeText;
    TextView descText;

    Boolean fromGuided;

    QuestionBranchList list; // List of last branches we visited
    QuestionFlagList flags; // List of flags that have been set so far
    Bitmap imageBitmap;

    BeedexNode node;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspect_bee);

        latinText = (TextView) findViewById(R.id.latinText);
        commonText = (TextView) findViewById(R.id.commonText);
        beeView = (ImageView) findViewById(R.id.beeView);
        habitatText = (TextView) findViewById(R.id.habitatText);
        activeText = (TextView) findViewById(R.id.timeText);
        descText = (TextView) findViewById(R.id.descText);

        node = (BeedexNode) getIntent().getSerializableExtra("NODE");

        this.fromGuided = Boolean.parseBoolean(getIntent().getStringExtra("WAS_GUIDED"));

        latinText.setText(node.latinName);
        commonText.setText(node.commonName);
        habitatText.setText(node.habitatInfo);
        activeText.setText(node.activeInfo);
        descText.setText(node.descInfo);

        Resources res = getResources();
        int resID = res.getIdentifier(node.picName, "drawable", getPackageName());
        beeView.setImageResource(resID);

        final Button backButton = (Button) findViewById(R.id.backButton);
        if(fromGuided) {
            this.list = (QuestionBranchList) getIntent().getSerializableExtra("LIST"); // Get the list of previous branches
            this.flags = (QuestionFlagList) getIntent().getSerializableExtra("FLAGS"); // Get the list of previous flags set

            Bundle extras = getIntent().getExtras(); // Get the image of the bee
            imageBitmap = (Bitmap) extras.get("data");

            backButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    QuestionBranch qb = (QuestionBranch) list.popBranch();

                    Intent intent = new Intent (InspectBeeActivity.this, QuestionTreeBranchActivity.class);

                    intent.putExtra("data", imageBitmap);
                    intent.putExtra("LIST", list);
                    intent.putExtra("NEXT_BRANCH", qb);
                    intent.putExtra("FLAGS", flags);
                    startActivity(intent);
                }
            });
        } else {
            backButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent (InspectBeeActivity.this, BeedexActivity.class);
                    startActivity(intent);
                }
            });
        }

    }

    @Override
    public void onBackPressed() {
        if(fromGuided) {
            QuestionBranch qb = (QuestionBranch) list.popBranch();

            Intent intent = new Intent (InspectBeeActivity.this, QuestionTreeBranchActivity.class);

            intent.putExtra("data", imageBitmap);
            intent.putExtra("LIST", list);
            intent.putExtra("NEXT_BRANCH", qb);
            intent.putExtra("FLAGS", flags);
            startActivity(intent);
        } else {
            Intent intent = new Intent(InspectBeeActivity.this, BeedexActivity.class);
            startActivity(intent);
        }
    }
}
