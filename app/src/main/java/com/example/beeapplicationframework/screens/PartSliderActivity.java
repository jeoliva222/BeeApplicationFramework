package com.example.beeapplicationframework.screens;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.beeapplicationframework.objects.*;

public class PartSliderActivity extends AppCompatActivity {

    Bitmap imageBitmap;
    boolean wasGuided;
    String bee;
    ImageView img;
    Boolean fromVideo;

    QuestionBranchList list; // List of last branches we visited
    QuestionFlagList flags; // List of current flags
    String photoPath;

    TextView headText;
    TextView thoraxText;
    TextView abdomenText;

    ImageView headView;
    ImageView thoraxView;
    ImageView abdomenView;

    ImageButton lhbutton;
    ImageButton rhbutton;
    ImageButton ltbutton;
    ImageButton rtbutton;
    ImageButton labutton;
    ImageButton rabutton;

    int hIndex = 0;
    int tIndex = 0;
    int aIndex = 0;
    int maxHead;
    int maxThorax;
    int maxAbdomen;

    String[] headList = new String[10];
    String[] thoraxList = new String[10];
    String[] abdomenList = new String[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_slider);

        this.fromVideo = Boolean.parseBoolean(getIntent().getStringExtra("fromVideo"));

        this.wasGuided = Boolean.parseBoolean(getIntent().getStringExtra("WAS_GUIDED"));
        this.bee = getIntent().getStringExtra("BEE");

        img = (ImageView) findViewById(R.id.beeView);
        photoPath = getIntent().getStringExtra("PHOTO_PATH");

        if(fromVideo) {
            Bundle extras = getIntent().getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);
        } else {
            setPic();
        }

        headText = (TextView) findViewById(R.id.headText);
        thoraxText = (TextView) findViewById(R.id.thoraxText);
        abdomenText = (TextView) findViewById(R.id.abdomenText);

        headView = (ImageView) findViewById(R.id.headView);
        thoraxView = (ImageView) findViewById(R.id.thoraxView);
        abdomenView = (ImageView) findViewById(R.id.abdomenView);

        lhbutton = (ImageButton) findViewById(R.id.leftHeadButton);
        rhbutton = (ImageButton) findViewById(R.id.rightHeadButton);
        ltbutton = (ImageButton) findViewById(R.id.leftThoraxButton);
        rtbutton = (ImageButton) findViewById(R.id.rightThoraxButton);
        labutton = (ImageButton) findViewById(R.id.leftAbdomenButton);
        rabutton = (ImageButton) findViewById(R.id.rightAbdomenButton);

        // Determines the images in each slider based on what bee species was selected
        switch(bee) {

            case "affinis":
                headList[0] = "h1";

                thoraxList[0] = "t6";
                thoraxList[1] = "t9";

                abdomenList[0] = "a54";
                abdomenList[1] = "a55";
                abdomenList[2] = "a57";

                maxHead = 0;
                maxThorax = 1;
                maxAbdomen = 2;

                break;
            case "bimaculatus":
                headList[0] = "h1";
                headList[1] = "h2";

                thoraxList[0] = "t3";
                thoraxList[1] = "t6";
                thoraxList[2] = "t10";

                abdomenList[0] = "a38";
                abdomenList[1] = "a39";
                abdomenList[2] = "a40";
                abdomenList[3] = "a42";
                abdomenList[4] = "a44";

                maxHead = 1;
                maxThorax = 2;
                maxAbdomen = 4;

                break;
            case "fervidus":
                headList[0] = "h1";
                headList[1] = "h2";

                thoraxList[0] = "t5";

                abdomenList[0] = "a6";
                abdomenList[1] = "a8";
                abdomenList[2] = "a9";

                maxHead = 1;
                maxThorax = 0;
                maxAbdomen = 2;

                break;
            case "griseocollis":
                headList[0] = "h1";
                headList[1] = "h2";

                thoraxList[0] = "t6";

                abdomenList[0] = "a12";
                abdomenList[1] = "a13";
                abdomenList[2] = "a14";
                abdomenList[3] = "a15";
                abdomenList[4] = "a16";

                maxHead = 1;
                maxThorax = 0;
                maxAbdomen = 4;

                break;
            case "impatiens":
                headList[0] = "h1";
                headList[1] = "h2";

                thoraxList[0] = "t3";
                thoraxList[1] = "t4";

                abdomenList[0] = "a33";
                abdomenList[1] = "a34";

                maxHead = 1;
                maxThorax = 1;
                maxAbdomen = 1;

                break;
            case "pennsylvanicus":
                headList[0] = "h1";
                headList[1] = "h2";

                thoraxList[0] = "t13";
                thoraxList[1] = "t14";
                thoraxList[2] = "t15";

                abdomenList[0] = "a45";
                abdomenList[1] = "a46";
                abdomenList[2] = "a51";
                abdomenList[3] = "a52";

                maxHead = 1;
                maxThorax = 2;
                maxAbdomen = 3;

                break;
            case "perplexus":
                headList[0] = "h1";
                headList[1] = "h2";

                thoraxList[0] = "t3";

                abdomenList[0] = "a26";
                abdomenList[1] = "a29";
                abdomenList[2] = "a31";
                abdomenList[3] = "a54";

                maxHead = 1;
                maxThorax = 0;
                maxAbdomen = 3;

                break;
            case "ternarius":
                headList[0] = "h2";
                headList[1] = "h3";

                thoraxList[0] = "t5";
                thoraxList[1] = "t7";

                abdomenList[0] = "a20";
                abdomenList[1] = "a21";

                maxHead = 1;
                maxThorax = 1;
                maxAbdomen = 1;

                break;
            case "terricola":
                headList[0] = "h1";
                headList[1] = "h2";

                thoraxList[0] = "t1";
                thoraxList[1] = "t16";
                thoraxList[2] = "t17";

                abdomenList[0] = "a58";
                abdomenList[1] = "a64";
                abdomenList[2] = "a65";
                abdomenList[3] = "a66";

                maxHead = 1;
                maxThorax = 2;
                maxAbdomen = 3;

                break;
            case "vagans":
                headList[0] = "h1";
                headList[1] = "h2";

                thoraxList[0] = "t6";
                thoraxList[1] = "t9";

                abdomenList[0] = "a14";
                abdomenList[1] = "a25";
                abdomenList[2] = "a26";

                maxHead = 1;
                maxThorax = 1;
                maxAbdomen = 2;

                break;
            default:
                headList[0] = "h1";
                headList[1] = "h2";
                headList[2] = "h3";

                thoraxList[0] = "t1";
                thoraxList[1] = "t2";
                thoraxList[2] = "t3";

                abdomenList[0] = "a1";
                abdomenList[1] = "a2";
                abdomenList[2] = "a3";

                maxHead = 2;
                maxThorax = 2;
                maxAbdomen = 2;
        }

      //  headView.setImageResource(R.mipmap.h1);
      //  thoraxView.setImageResource(R.mipmap.t1);
      //  abdomenView.setImageResource(R.mipmap.a1);

        // Update all views
        updateSlider(4);

        lhbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(hIndex > 0) {
                    hIndex = hIndex - 1;
                } else {
                    hIndex = maxHead;
                }
                updateSlider(1);
            }
        });
        rhbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(hIndex < maxHead) {
                    hIndex = hIndex + 1;
                } else {
                    hIndex = 0;
                }
                updateSlider(1);
            }
        });

        ltbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(tIndex > 0) {
                    tIndex = tIndex - 1;
                } else {
                    tIndex = maxThorax;
                }
                updateSlider(2);
            }
        });
        rtbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(tIndex < maxThorax) {
                    tIndex = tIndex + 1;
                } else {
                    tIndex = 0;
                }
                updateSlider(2);
            }
        });

        labutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(aIndex > 0) {
                    aIndex = aIndex - 1;
                } else {
                    aIndex = maxAbdomen;
                }
                updateSlider(3);
            }
        });
        rabutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(aIndex < maxAbdomen) {
                    aIndex = aIndex + 1;
                } else {
                    aIndex = 0;
                }
                updateSlider(3);
            }
        });

        if(wasGuided) {
            this.list = (QuestionBranchList) getIntent().getSerializableExtra("LIST"); // Get the list of previous branches
            this.flags = (QuestionFlagList) getIntent().getSerializableExtra("FLAGS"); // Get the list of previous branches

            final Button backbutton = (Button) findViewById(R.id.backButton);
            backbutton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    QuestionBranch qb = (QuestionBranch) list.popBranch();

                    Intent intent = new Intent (PartSliderActivity.this, QuestionTreeBranchActivity.class);

                    intent.putExtra("data", imageBitmap);
                    intent.putExtra("PHOTO_PATH", photoPath);
                    intent.putExtra("fromVideo", fromVideo.toString());
                    intent.putExtra("LIST", list);
                    intent.putExtra("NEXT_BRANCH", qb);
                    intent.putExtra("FLAGS", flags);
                    startActivity(intent);
                }
            });

            final Button nextbutton = (Button) findViewById(R.id.nextButton);
            nextbutton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent (PartSliderActivity.this, LogBeeActivity_Flower.class);

                    intent.putExtra("data", imageBitmap);
                    intent.putExtra("PHOTO_PATH", photoPath);
                    intent.putExtra("fromVideo", fromVideo.toString());
                    intent.putExtra("WAS_GUIDED", "True");
                    intent.putExtra("BEE", bee);

                    intent.putExtra("LIST", list);
                    intent.putExtra("FLAGS", flags);

                    intent.putExtra("HEAD", headList[hIndex]);
                    intent.putExtra("THORAX", thoraxList[tIndex]);
                    intent.putExtra("ABDOMEN", abdomenList[aIndex]);

                    startActivity(intent);
                }
            });
        } else {
            final Button backbutton = (Button) findViewById(R.id.backButton);
            backbutton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(PartSliderActivity.this, LogBeeActivity_Manual.class);
                    intent.putExtra("data", imageBitmap);
                    intent.putExtra("PHOTO_PATH", photoPath);
                    intent.putExtra("fromVideo", fromVideo.toString());
                    startActivity(intent);
                }
            });

            final Button nextbutton = (Button) findViewById(R.id.nextButton);
            nextbutton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent (PartSliderActivity.this, LogBeeActivity_Flower.class);

                    intent.putExtra("data", imageBitmap);
                    intent.putExtra("PHOTO_PATH", photoPath);
                    intent.putExtra("fromVideo", fromVideo.toString());
                    intent.putExtra("WAS_GUIDED", "False");
                    intent.putExtra("BEE", bee);

                    intent.putExtra("HEAD", headList[hIndex]);
                    intent.putExtra("THORAX", thoraxList[tIndex]);
                    intent.putExtra("ABDOMEN", abdomenList[aIndex]);

                    startActivity(intent);
                }
            });
        }

    }

    public void updateSlider(int section) {
        int headID, thoraxID, abdomenID;

        Resources res = getResources();

        switch(section) {
            case 1: // Update Head
                headText.setText("Head # (" + Integer.toString(hIndex + 1) + " / " + Integer.toString(maxHead + 1) + ")");
                headID = res.getIdentifier(headList[hIndex], "mipmap", getPackageName());
                headView.setImageResource(headID);
                break;

            case 2: // Update Thorax
                thoraxText.setText("Thorax # (" + Integer.toString(tIndex + 1) + " / " + Integer.toString(maxThorax + 1) + ")");
                thoraxID = res.getIdentifier(thoraxList[tIndex], "mipmap", getPackageName());
                thoraxView.setImageResource(thoraxID);
                break;

            case 3: // Update Abdomen
                abdomenText.setText("Abdomen # (" + Integer.toString(aIndex + 1) + " / " + Integer.toString(maxAbdomen + 1) + ")");
                abdomenID = res.getIdentifier(abdomenList[aIndex], "mipmap", getPackageName());
                abdomenView.setImageResource(abdomenID);
                break;

            default: // Update All, otherwise
                headText.setText("Head # (" + Integer.toString(hIndex + 1) + " / " + Integer.toString(maxHead + 1) + ")");
                headID = res.getIdentifier(headList[hIndex], "mipmap", getPackageName());
                headView.setImageResource(headID);

                thoraxText.setText("Thorax # (" + Integer.toString(tIndex + 1) + " / " + Integer.toString(maxThorax + 1) + ")");
                thoraxID = res.getIdentifier(thoraxList[tIndex], "mipmap", getPackageName());
                thoraxView.setImageResource(thoraxID);

                abdomenText.setText("Abdomen # (" + Integer.toString(aIndex + 1) + " / " + Integer.toString(maxAbdomen + 1) + ")");
                abdomenID = res.getIdentifier(abdomenList[aIndex], "mipmap", getPackageName());
                abdomenView.setImageResource(abdomenID);
        }
    }

    private void setPic() {
        // Get the dimensions of the View
        int targetW = 300;
        int targetH = 300;

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
        if(wasGuided) {
            QuestionBranch qb = (QuestionBranch) list.popBranch();

            Intent intent = new Intent (PartSliderActivity.this, QuestionTreeBranchActivity.class);

            intent.putExtra("data", imageBitmap);
            intent.putExtra("PHOTO_PATH", photoPath);
            intent.putExtra("fromVideo", fromVideo.toString());
            intent.putExtra("LIST", list);
            intent.putExtra("NEXT_BRANCH", qb);
            intent.putExtra("FLAGS", flags);
            startActivity(intent);
        } else {
            Intent intent = new Intent(PartSliderActivity.this, LogBeeActivity_Manual.class);
            intent.putExtra("data", imageBitmap);
            intent.putExtra("PHOTO_PATH", photoPath);
            intent.putExtra("fromVideo", fromVideo.toString());
            startActivity(intent);
        }
    }

}
