package com.example.beeapplicationframework;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LogBeeActivity_Manual extends AppCompatActivity {

    Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_bee_manual);

        Bundle extras = getIntent().getExtras();
        imageBitmap = (Bitmap) extras.get("data");

        ImageView img = (ImageView) findViewById(R.id.beeView); // Display the bee's picture on the screen
        img.setImageBitmap(imageBitmap);

        Resources res = getResources();

        // Set icon pictures for each bee
        ImageView bee1View = (ImageView) findViewById(R.id.bee1View);
        int resID = res.getIdentifier("affinis_icon", "drawable", getPackageName());
        bee1View.setImageResource(resID);

        ImageView bee2View = (ImageView) findViewById(R.id.bee2View);
        int res2ID = res.getIdentifier("bimaculatus_icon", "drawable", getPackageName());
        bee2View.setImageResource(res2ID);

        ImageView bee3View = (ImageView) findViewById(R.id.bee3View);
        int res3ID = res.getIdentifier("fervidus_icon", "drawable", getPackageName());
        bee3View.setImageResource(res3ID);

        ImageView bee4View = (ImageView) findViewById(R.id.bee4View);
        int res4ID = res.getIdentifier("griseocollis_icon", "drawable", getPackageName());
        bee4View.setImageResource(res4ID);

        ImageView bee5View = (ImageView) findViewById(R.id.bee5View);
        int res5ID = res.getIdentifier("impatiens_icon", "drawable", getPackageName());
        bee5View.setImageResource(res5ID);

        ImageView bee6View = (ImageView) findViewById(R.id.bee6View);
        int res6ID = res.getIdentifier("pennsylvanicus_icon", "drawable", getPackageName());
        bee6View.setImageResource(res6ID);

        ImageView bee7View = (ImageView) findViewById(R.id.bee7View);
        int res7ID = res.getIdentifier("perplexus_icon", "drawable", getPackageName());
        bee7View.setImageResource(res7ID);

        ImageView bee8View = (ImageView) findViewById(R.id.bee8View);
        int res8ID = res.getIdentifier("ternarius_icon", "drawable", getPackageName());
        bee8View.setImageResource(res8ID);

        ImageView bee9View = (ImageView) findViewById(R.id.bee9View);
        int res9ID = res.getIdentifier("terricola_icon", "drawable", getPackageName());
        bee9View.setImageResource(res9ID);

        ImageView bee10View = (ImageView) findViewById(R.id.bee10View);
        int res10ID = res.getIdentifier("vagans_icon", "drawable", getPackageName());
        bee10View.setImageResource(res10ID);

        final Button affiButton = (Button) findViewById(R.id.button1);
        affiButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Manual.this, PartSliderActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("WAS_GUIDED", "False");
                intent.putExtra("BEE", "affinis");
                startActivity(intent);
            }
        });

        final Button bimaButton = (Button) findViewById(R.id.button2);
        bimaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Manual.this, PartSliderActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("WAS_GUIDED", "False");
                intent.putExtra("BEE", "bimaculatus");
                startActivity(intent);
            }
        });

        final Button fervButton = (Button) findViewById(R.id.button3);
        fervButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Manual.this, PartSliderActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("WAS_GUIDED", "False");
                intent.putExtra("BEE", "fervidus");
                startActivity(intent);
            }
        });

        final Button grisButton = (Button) findViewById(R.id.button4);
        grisButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Manual.this, PartSliderActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("WAS_GUIDED", "False");
                intent.putExtra("BEE", "griseocollis");
                startActivity(intent);
            }
        });

        final Button impaButton = (Button) findViewById(R.id.button5);
        impaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Manual.this, PartSliderActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("WAS_GUIDED", "False");
                intent.putExtra("BEE", "impatiens");
                startActivity(intent);
            }
        });

        final Button pennButton = (Button) findViewById(R.id.button6);
        pennButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Manual.this, PartSliderActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("WAS_GUIDED", "False");
                intent.putExtra("BEE", "pennsylvanicus");
                startActivity(intent);
            }
        });

        final Button perpButton = (Button) findViewById(R.id.button7);
        perpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Manual.this, PartSliderActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("WAS_GUIDED", "False");
                intent.putExtra("BEE", "perplexus");
                startActivity(intent);
            }
        });

        final Button ternButton = (Button) findViewById(R.id.button8);
        ternButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Manual.this, PartSliderActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("WAS_GUIDED", "False");
                intent.putExtra("BEE", "ternarius");
                startActivity(intent);
            }
        });

        final Button terrButton = (Button) findViewById(R.id.button9);
        terrButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Manual.this, PartSliderActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("WAS_GUIDED", "False");
                intent.putExtra("BEE", "terricola");
                startActivity(intent);
            }
        });

        final Button vagaButton = (Button) findViewById(R.id.button10);
        vagaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (LogBeeActivity_Manual.this, PartSliderActivity.class);
                intent.putExtra("data", imageBitmap);
                intent.putExtra("WAS_GUIDED", "False");
                intent.putExtra("BEE", "vagans");
                startActivity(intent);
            }
        });
    }

    public void goToLBMenuActivity(View view) {
        Bundle extras = getIntent().getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        Intent intent = new Intent (this, LogBeeActivity_Menu.class);
        intent.putExtra("data", imageBitmap);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Bundle extras = getIntent().getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        Intent intent = new Intent (this, LogBeeActivity_Menu.class);
        intent.putExtra("data", imageBitmap);
        startActivity(intent);
    }

}
