package com.example.beeapplicationframework.screens;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import com.example.beeapplicationframework.objects.*;

public class LogBeeActivity_Flower extends AppCompatActivity {

    boolean wasGuided;
    String bee, head, thorax, abdomen;
    Bitmap imageBitmap;
    ImageView img;
    Spinner flower_color;
    Spinner flower_shape;
    Boolean fromVideo;

    QuestionBranchList list; // List of last branches we visited
    QuestionFlagList flags; // List of current flags
    String photoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_bee__flower);

        this.wasGuided = Boolean.parseBoolean(getIntent().getStringExtra("WAS_GUIDED"));
        this.fromVideo = Boolean.parseBoolean(getIntent().getStringExtra("fromVideo"));
        this.bee = getIntent().getStringExtra("BEE");
        this.head = getIntent().getStringExtra("HEAD");
        this.thorax = getIntent().getStringExtra("THORAX");
        this.abdomen = getIntent().getStringExtra("ABDOMEN");

        img = (ImageView) findViewById(R.id.beeView);
        photoPath = getIntent().getStringExtra("PHOTO_PATH");

        if(fromVideo) {
            Bundle extras = getIntent().getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);
        } else {
            setPic();
        }

        flower_color = (Spinner) findViewById(R.id.spinner_color);
        flower_shape = (Spinner) findViewById(R.id.spinner_shape);

        if(wasGuided) {
            this.list = (QuestionBranchList) getIntent().getSerializableExtra("LIST"); // Get the list of previous branches
            this.flags = (QuestionFlagList) getIntent().getSerializableExtra("FLAGS"); // Get the list of previous branches
        }
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

    public void goToPartSliderActivity(View view) {
        Intent intent = new Intent(this, PartSliderActivity.class);

        intent.putExtra("data", imageBitmap);
        intent.putExtra("PHOTO_PATH", photoPath);
        intent.putExtra("BEE", bee);
        intent.putExtra("fromVideo", fromVideo.toString());
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

        String f_color = flower_color.getSelectedItem().toString();
        String f_shape = flower_shape.getSelectedItem().toString();

        intent.putExtra("data", imageBitmap);
        intent.putExtra("PHOTO_PATH", photoPath);
        intent.putExtra("BEE", bee);
        intent.putExtra("HEAD", head);
        intent.putExtra("THORAX", thorax);
        intent.putExtra("ABDOMEN", abdomen);
        intent.putExtra("F_COLOR", f_color);
        intent.putExtra("F_SHAPE", f_shape);
        intent.putExtra("fromVideo", fromVideo.toString());

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
        intent.putExtra("PHOTO_PATH", photoPath);
        intent.putExtra("BEE", bee);
        intent.putExtra("fromVideo", fromVideo.toString());
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
