package com.example.beeapplicationframework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class BeedexActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beedex);

        // For now, define the beedex nodes here
        final BeedexTree tree = new BeedexTree();
        /*
        final BeedexNode affinisNode = new BeedexNode("Bombus affinis", "Rusty-patched bumble bee", "affinis",
                "griseocollis, bimaculatus",
                "April - October",
                "This bumble bee has a half black, half yellow abdomen with a thin orange stripe in the top half." +
                        " It has a black dot and gray coloring on the thorax and is dark around the wings.");
        final BeedexNode bimaculatusNode = new BeedexNode("Bombus bimaculatus", "Two-spotted bumble bee", "bimaculatus",
                "impatiens, griseocollis",
                "April - October",
                "This bumble bee has a black dot on the thorax, is dark around the wings and has a mostly black abdomen. " +
                        "The top half of the abdomen typically, has an irregular band in the middle of the abdomen.");
        final BeedexNode fervidusNode = new BeedexNode("Bombus fervidus", "Yellow bumble bee", "fervidus",
                "-",
                "May - October",
                "This bumble bee has a mostly yellow abdomen, with a small portion of black at the bottom of the abdomen. " +
                        "The thorax has a black band going across the middle.");
        final BeedexNode griseocollisNode = new BeedexNode("Bombus griseocollis", "Brown-belted bumble bee", "griseocollis",
                "bimaculatus, affinis, impatiens",
                "May - October",
                "This bumble bee has a black dot on the thorax, is dark around the wings and has a thin orange band before the " +
                        "abdomen becomes mostly black.");
        final BeedexNode impatiensNode = new BeedexNode("Bombus impatiens", "Common Eastern bumble bee", "impatiens",
                "bimaculatus, griseocollis",
                "April - October",
                "This bumble bee is dark around the wings, has a gray coloring to the thorax and has a mostly black abdomen.");
        final BeedexNode pennsylvanicusNode = new BeedexNode("Bombus pennsylvanicus", "American bumble bee", "pennsylvanicus",
                "terricola",
                "May - October",
                "This bumble bee has a mostly yellow abdomen. The bottom of the abdomen is always black and occasionally, there " +
                        "is a thin black coloring at the top of the abdomen, extending down from the thorax. The thorax is typically " +
                        "dark, either being all black or having a distinct black band surrounded by gray coloring.");
        final BeedexNode perplexusNode = new BeedexNode("Bombus perplexus", "Confusing bumble bee", "perplexus",
                "vagans",
                "April - September",
                "This bumble bee has a half black abdomen. Occasionally, the black band is irregular. The thorax is yellow with " +
                        "darkening around the wings.");
        final BeedexNode ternariusNode = new BeedexNode("Bombus ternarius", "Tri-colored bumble bee", "ternarius",
                "-",
                "April - October",
                "This bumble bee has a thick orange strip on the abdomen. The thorax has black band in the middle and may have " +
                        "a black triangle below the band as well.");
        final BeedexNode terricolaNode = new BeedexNode("Bombus terricola", "Yellow-banded bumble bee", "terricola",
                "pennsylvanicus",
                "April - October",
                "This bumble bee has a half black abdomen. The top and bottom ends of the abdomen are typically black, with yellow in " +
                        "between the two bands. Top of the abdomen has a black band as well.");
        final BeedexNode vagansNode = new BeedexNode("Bombus vagans", "Half-black bumble bee", "vagans",
                "perplexus",
                "April - October",
                "This bumble bee has a half black abdomen, with the bottom half always being black. The abdomen has a " +
                        "black dot surrounded by a gray coloring and dark around the wings.");
                        */


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
