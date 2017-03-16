package com.example.beeapplicationframework;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuestionTreeBranchActivity extends AppCompatActivity {

    // Fields we use on the screen
    TextView questiontext;
    Button nobutton;
    Button yesbutton;
    Button backbutton;
    Button infobutton;
    ImageView helpimage;

    int startingState; // Enumeration dictating which branch we start at (which option user picked last screen)
    QuestionBranch currentBranch; // Current Branch we load in on
    QuestionBranchList list; // List of last branches we visited
    QuestionFlagList flags; // List of flags that have been set so far

    BeedexTree tree;

    Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_tree_branch);

        // For now, define all nodes here
        QuestionBranch grisNode = new QuestionBranch("Is your bee the species B. griseocollis?", null, null, "Bee", true, "griseocollis", "griseocollis");
        QuestionBranch bimaNode = new QuestionBranch("Is your bee the species B. bimaculatus?", null, null, "Bee", true, "bimaculatus", "bimaculatus");
        QuestionBranch impaNode = new QuestionBranch("Is your bee the species B. impatiens?", null, null, "Bee", true, "impatiens", "impatiens");
        QuestionBranch affiNode = new QuestionBranch("Is your bee the species B. affinis?", null, null, "Bee", true, "affinis", "affinis");
        QuestionBranch terrNode = new QuestionBranch("Is your bee the species B. terricola?", null, null, "Bee", true, "terricola", "terricola");
        QuestionBranch vagaNode = new QuestionBranch("Is your bee the species B. vagans?", null, null, "Bee", true, "vagans", "vagans");
        QuestionBranch perpNode = new QuestionBranch("Is your bee the species B. perplexus?", null, null, "Bee", true, "perplexus", "perplexus");
        QuestionBranch ternNode = new QuestionBranch("Is your bee the species B. ternarius?", null, null, "Bee", true, "ternarius", "ternarius");
        QuestionBranch pensNode = new QuestionBranch("Is your bee the species B. pennsylvanicus?", null, null, "Bee", true, "pennsylvanicus", "pennsylvanicus");
        QuestionBranch fervNode = new QuestionBranch("Is your bee the species B. fervidus?", null, null, "Bee", true, "fervidus", "fervidus");
        QuestionBranch node1 = new QuestionBranch("Does your bee have a dirty yellow band?", null, impaNode, "Tstripe", "helper_3");
        QuestionBranch node2 = new QuestionBranch("Does your bee have a dot on its thorax?", node1, bimaNode, "Tdot", "helper_2");
        QuestionBranch node3 = new QuestionBranch("Does your bee have orange coloring on its abdomen?", node2, grisNode, "Orange", "helper_1");
        QuestionBranch node4 = new QuestionBranch("Does your bee have black on its sides?", null, perpNode, "wingBase", "helper_7");
        QuestionBranch node5 = new QuestionBranch("Does your bee have a black dot on its thorax?", node4, vagaNode, "Tdot", "helper_6");
        QuestionBranch node6 = new QuestionBranch("Is the top of your bee's abdomen black?", node5, terrNode, "TopBlack", "helper_10");
        QuestionBranch node7 = new QuestionBranch("Does your bee have orange coloring on its abdomen?", node6, affiNode, "Orange", "helper_1");
        QuestionBranch node8 = new QuestionBranch("Does your bee have black on its sides?", null, perpNode, "wingBase", "helper_9");
        QuestionBranch node9 = new QuestionBranch("Does your bee have a black-striped thorax?", node8, fervNode, "Tstripe", "helper_5");
        QuestionBranch node10 = new QuestionBranch("Is your bee's thorax mostly black?", node9, pensNode, "Tblack", "helper_8");
        QuestionBranch node11 = new QuestionBranch("Does your bee have orange coloring on its abdomen?", node10, ternNode, "Orange", "helper_4");


        // Get which button we hit from the QuestionTreeBaseActivity and decide which node to load up first
        // Defaults to '3' if we did not get to this screen from QuestionTreeBaseActivity, triggering the switch to
        // use the 'default' statement
        this.startingState = getIntent().getIntExtra("STATE", 3);

        Bundle extras = getIntent().getExtras(); // Get the image of the bee
        imageBitmap = (Bitmap) extras.get("data");

        this.list = (QuestionBranchList) getIntent().getSerializableExtra("LIST"); // Get the list of previous branches
        this.flags = (QuestionFlagList) getIntent().getSerializableExtra("FLAGS"); // Get the list of previous flags set

        tree = new BeedexTree();

        questiontext = (TextView) findViewById(R.id.testText);
        nobutton = (Button) findViewById(R.id.noButton);
        yesbutton = (Button) findViewById(R.id.yesButton);
        backbutton = (Button) findViewById(R.id.backButton);
        infobutton = (Button) findViewById(R.id.infoButton);
        helpimage = (ImageView) findViewById(R.id.helperView);

        ImageView img = (ImageView) findViewById(R.id.beeView);
        img.setImageBitmap(imageBitmap);

        switch(this.startingState) {
            case 0:         // Mostly Black
                this.currentBranch = node3;

                updateViews();

                break;
            case 1:         // Half / Half
                this.currentBranch = node7;

                updateViews();

                break;
            case 2:         // Mostly Yellow
                this.currentBranch = node11;

                updateViews();

                break;
            default:        // Default case if we return to this activity from an activity that is not QuestionTreeBaseActivity
                this.currentBranch = (QuestionBranch) getIntent().getSerializableExtra("NEXT_BRANCH");

                updateViews();

        }

    }

    public void updateViews() {

        questiontext.setText(currentBranch.title);

        Resources res = getResources();
        int resID = res.getIdentifier(currentBranch.helper, "drawable", getPackageName());
        helpimage.setImageResource(resID);

        if(currentBranch.isEnd) {
            infobutton.setVisibility(View.VISIBLE);

            infobutton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(QuestionTreeBranchActivity.this, InspectBeeActivity.class);

                    BeedexNode node = tree.getNode(currentBranch.species);
                    intent.putExtra("NODE", node);

                    list.addBranch(currentBranch); // Updates backtracking list
                    intent.putExtra("LIST", list);
                    intent.putExtra("FLAGS", flags);
                    intent.putExtra("WAS_GUIDED", "True");

                    intent.putExtra("data", imageBitmap);
                    startActivity(intent);
                }
            });
        } else {
            infobutton.setVisibility(View.INVISIBLE);
        }

        nobutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentBranch.noBranch != null) {

                    list.addBranch(currentBranch); // Updates backtracking list

                    flags.addBranch(currentBranch.flag, "no"); // Updates flag list

                    QuestionBranch q = currentBranch.noBranch;
                    currentBranch = q;
                    updateViews();

                } else {
                    Intent intent = new Intent(QuestionTreeBranchActivity.this, QuestionTreeRestartActivity.class);

                    list.addBranch(currentBranch); // Updates backtracking list
                    intent.putExtra("LIST", list);
                    intent.putExtra("FLAGS", flags);

                    intent.putExtra("data", imageBitmap);
                    startActivity(intent);
                }
            }
        });

        yesbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(currentBranch.yesBranch != null) {

                    list.addBranch(currentBranch); // Updates backtracking list

                    flags.addBranch(currentBranch.flag, "yes"); // Updates flag list

                    QuestionBranch q = currentBranch.yesBranch;
                    currentBranch = q;
                    updateViews();
                } else {
                    Intent intent = new Intent(QuestionTreeBranchActivity.this, PartSliderActivity.class);

                    intent.putExtra("WAS_GUIDED", "True");
                    intent.putExtra("data", imageBitmap);

                    list.addBranch(currentBranch); // Updates backtracking list
                    flags.addBranch(currentBranch.flag, "yes"); // Updates flag list

                    intent.putExtra("LIST", list);
                    intent.putExtra("FLAGS", flags);
                    intent.putExtra("BEE", currentBranch.species);

                    startActivity(intent);
                }
            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                QuestionBranch qbp = (QuestionBranch) list.popBranch();

                if(qbp == null) {
                    Intent intent = new Intent (QuestionTreeBranchActivity.this, QuestionTreeBaseActivity.class);
                    intent.putExtra("data", imageBitmap);
                    flags.clearList();
                    startActivity(intent);
                } else {
                    flags.removeBranch();
                    currentBranch = qbp;
                    updateViews();

                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        QuestionBranch qbp = (QuestionBranch) list.popBranch();

        if(qbp == null) {
            Intent intent = new Intent (QuestionTreeBranchActivity.this, QuestionTreeBaseActivity.class);
            intent.putExtra("data", imageBitmap);
            flags.clearList();
            startActivity(intent);
        } else {
            flags.removeBranch();
            currentBranch = qbp;
            updateViews();

        }
    }

}
