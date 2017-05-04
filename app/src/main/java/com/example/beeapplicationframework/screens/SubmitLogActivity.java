package com.example.beeapplicationframework.screens;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.beeapplicationframework.objects.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SubmitLogActivity extends AppCompatActivity {

    boolean wasGuided;
    String bee, head, thorax, abdomen, f_color, f_shape;
    Bitmap imageBitmap;
    String photoPath;
    ImageView beeimg;
    Boolean fromVideo;

    QuestionBranchList list; // List of last branches we visited
    QuestionFlagList flags; // List of current flags

    MyLogsDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_log);

        this.fromVideo = Boolean.parseBoolean(getIntent().getStringExtra("fromVideo"));

        dbHelper = new MyLogsDBHelper(this);

        this.wasGuided = Boolean.parseBoolean(getIntent().getStringExtra("WAS_GUIDED"));
        this.bee = getIntent().getStringExtra("BEE");
        this.head = getIntent().getStringExtra("HEAD");
        this.thorax = getIntent().getStringExtra("THORAX");
        this.abdomen = getIntent().getStringExtra("ABDOMEN");
        this.f_color = getIntent().getStringExtra("F_COLOR");
        this.f_shape = getIntent().getStringExtra("F_SHAPE");

        if(wasGuided) {
            this.list = (QuestionBranchList) getIntent().getSerializableExtra("LIST"); // Get the list of previous branches
            this.flags = (QuestionFlagList) getIntent().getSerializableExtra("FLAGS"); // Get the list of previous branches
        }

        beeimg = (ImageView) findViewById(R.id.beeView);
        photoPath = getIntent().getStringExtra("PHOTO_PATH");

        if(fromVideo) {
            Bundle extras = getIntent().getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            beeimg.setImageBitmap(imageBitmap);
        } else {
            setPic();
        }

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

        TextView flowerDetailText = (TextView) findViewById(R.id.flowerDetailText);
        flowerDetailText.setText(f_color + " Color and " + f_shape + " Shape");

        TextView speciesText = (TextView) findViewById(R.id.speciesText);
        speciesText.setText("Bombus " + bee);

        final Button backbutton = (Button) findViewById(R.id.backButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (SubmitLogActivity.this, LogBeeActivity_Flower.class);

                intent.putExtra("data", imageBitmap);
                intent.putExtra("PHOTO_PATH", photoPath);
                intent.putExtra("fromVideo", fromVideo.toString());
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
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                if(fromVideo) {
                    dbHelper.insertLog(bee, photoPath, 1, head, thorax, abdomen, f_shape, f_color, timeStamp);
                } else {
                    dbHelper.insertLog(bee, photoPath, 0, head, thorax, abdomen, f_shape, f_color, timeStamp);
                }

                Intent intent = new Intent (SubmitLogActivity.this, ConfirmSubmissionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setPic() {
        // Get the dimensions of the View
        int targetW = 110;
        int targetH = 250;

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(photoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(photoPath, bmOptions);
        beeimg.setImageBitmap(bitmap);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (SubmitLogActivity.this, LogBeeActivity_Flower.class);

        intent.putExtra("data", imageBitmap);
        intent.putExtra("PHOTO_PATH", photoPath);
        intent.putExtra("fromVideo", fromVideo.toString());
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
