package com.example.beeapplicationframework.screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.beeapplicationframework.objects.*;

public class BeedexActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beedex);

        // Tree defined here that contains all the Beedex node information
        final BeedexTree tree = new BeedexTree();

        final Button affiButton = (Button) findViewById(R.id.button1);
        affiButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (BeedexActivity.this, InspectBeeActivity.class);

                intent.putExtra("NODE", tree.affinisNode);
                intent.putExtra("WAS_GUIDED", "False");

                startActivity(intent);
            }
        });

        final Button bimaButton = (Button) findViewById(R.id.button2);
        bimaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (BeedexActivity.this, InspectBeeActivity.class);

                intent.putExtra("NODE", tree.bimaculatusNode);
                intent.putExtra("WAS_GUIDED", "False");

                startActivity(intent);
            }
        });

        final Button fervButton = (Button) findViewById(R.id.button3);
        fervButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (BeedexActivity.this, InspectBeeActivity.class);

                intent.putExtra("NODE", tree.fervidusNode);
                intent.putExtra("WAS_GUIDED", "False");

                startActivity(intent);
            }
        });

        final Button grisButton = (Button) findViewById(R.id.button4);
        grisButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (BeedexActivity.this, InspectBeeActivity.class);

                intent.putExtra("NODE", tree.griseocollisNode);
                intent.putExtra("WAS_GUIDED", "False");

                startActivity(intent);
            }
        });

        final Button impaButton = (Button) findViewById(R.id.button5);
        impaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (BeedexActivity.this, InspectBeeActivity.class);

                intent.putExtra("NODE", tree.impatiensNode);
                intent.putExtra("WAS_GUIDED", "False");

                startActivity(intent);
            }
        });

        final Button pennButton = (Button) findViewById(R.id.button6);
        pennButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (BeedexActivity.this, InspectBeeActivity.class);

                intent.putExtra("NODE", tree.pennsylvanicusNode);
                intent.putExtra("WAS_GUIDED", "False");

                startActivity(intent);
            }
        });

        final Button perpButton = (Button) findViewById(R.id.button7);
        perpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (BeedexActivity.this, InspectBeeActivity.class);

                intent.putExtra("NODE", tree.perplexusNode);
                intent.putExtra("WAS_GUIDED", "False");

                startActivity(intent);
            }
        });

        final Button ternButton = (Button) findViewById(R.id.button8);
        ternButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (BeedexActivity.this, InspectBeeActivity.class);

                intent.putExtra("NODE", tree.ternariusNode);
                intent.putExtra("WAS_GUIDED", "False");

                startActivity(intent);
            }
        });

        final Button terrButton = (Button) findViewById(R.id.button9);
        terrButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (BeedexActivity.this, InspectBeeActivity.class);

                intent.putExtra("NODE", tree.terricolaNode);
                intent.putExtra("WAS_GUIDED", "False");

                startActivity(intent);
            }
        });

        final Button vagaButton = (Button) findViewById(R.id.button10);
        vagaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (BeedexActivity.this, InspectBeeActivity.class);

                intent.putExtra("NODE", tree.vagansNode);
                intent.putExtra("WAS_GUIDED", "False");

                startActivity(intent);
            }
        });

}

    public void goToMainActivity(View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}
