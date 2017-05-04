package com.example.beeapplicationframework.screens;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LogBeeActivity_Menu extends AppCompatActivity {

    Bitmap imageBitmap;
    String photoPath;
    ImageView img;
    Boolean fromVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_bee__menu);

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





        final Button manbutton = (Button) findViewById(R.id.manualButton);
        manbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Menu.this, LogBeeActivity_Manual.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("PHOTO_PATH", photoPath);
                intent.putExtra("fromVideo", fromVideo.toString());
                startActivity(intent);
            }
        });

        final Button autobutton = (Button) findViewById(R.id.helpButton);
        autobutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Menu.this, QuestionTreeBaseActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("PHOTO_PATH", photoPath);
                intent.putExtra("fromVideo", fromVideo.toString());
                startActivity(intent);
            }
        });

        final Button backbutton = (Button) findViewById(R.id.backButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent (LogBeeActivity_Menu.this, PictureVideoSelectActivity.class);
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

    public void goToMainActivity(View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
            Intent intent = new Intent (LogBeeActivity_Menu.this, PictureVideoSelectActivity.class);
            startActivity(intent);
    }
}
