package com.example.beeapplicationframework.screens;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.beeapplicationframework.objects.*;

public class QuestionTreeBaseActivity extends AppCompatActivity {

    Bitmap imageBitmap;
    QuestionBranchList list;
    QuestionFlagList flags;
    String photoPath;
    ImageView img;
    Boolean fromVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_tree_base);

        this.fromVideo = Boolean.parseBoolean(getIntent().getStringExtra("fromVideo"));

        img = (ImageView) findViewById(R.id.beeView);
        photoPath = getIntent().getStringExtra("PHOTO_PATH");

        if(fromVideo) {
            Bundle extras = getIntent().getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);
        } else {
            setPic();
        }

        list = new QuestionBranchList();
        flags = new QuestionFlagList();

        final Button blackbutton = (Button) findViewById(R.id.blackButton);
        blackbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (QuestionTreeBaseActivity.this, QuestionTreeBranchActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("PHOTO_PATH", photoPath);
                intent.putExtra("fromVideo", fromVideo.toString());
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
                intent.putExtra("PHOTO_PATH", photoPath);
                intent.putExtra("fromVideo", fromVideo.toString());
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
                intent.putExtra("PHOTO_PATH", photoPath);
                intent.putExtra("fromVideo", fromVideo.toString());
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
                intent.putExtra("PHOTO_PATH", photoPath);
                intent.putExtra("fromVideo", fromVideo.toString());
                startActivity(intent);
            }
        });
    }

    private void setPic() {
        // Get the dimensions of the View
        int targetW = 300;
        int targetH = 220;

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
        img.setImageBitmap(bitmap);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (QuestionTreeBaseActivity.this, LogBeeActivity_Menu.class);
        intent.putExtra("data", imageBitmap);
        intent.putExtra("PHOTO_PATH", photoPath);
        intent.putExtra("fromVideo", fromVideo.toString());
        startActivity(intent);
    }
}
