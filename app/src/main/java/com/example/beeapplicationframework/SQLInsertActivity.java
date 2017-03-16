package com.example.beeapplicationframework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SQLInsertActivity extends AppCompatActivity {

    ExampleDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlinsert);

        dbHelper = new ExampleDBHelper(this);

        final Button backbutton = (Button) findViewById(R.id.backButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (SQLInsertActivity.this, SQLTestActivity.class);
                startActivity(intent);
            }
        });

        final Button addbutton = (Button) findViewById(R.id.addButton);
        addbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // If fields aren't empty
                if(checkAttributes()) {
                    final EditText namefield = (EditText) findViewById(R.id.nameText);
                    final EditText genderfield = (EditText) findViewById(R.id.genderText);
                    final EditText agefield = (EditText) findViewById(R.id.ageText);
                    String name_text = namefield.getText().toString().trim();
                    String gender_text = genderfield.getText().toString().trim();
                    String age_text = agefield.getText().toString().trim();
                    int age_num = Integer.parseInt(age_text);

                    // Insert the person
                    dbHelper.insertPerson(name_text, gender_text, age_num);

                    // Go back to last activity
                    Intent intent = new Intent (SQLInsertActivity.this, SQLTestActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    // Checks to see that all text fields are full
    public Boolean checkAttributes() {
        Boolean nameFlag, genderFlag, ageFlag;
        final EditText namefield = (EditText) findViewById(R.id.nameText);
        final EditText genderfield = (EditText) findViewById(R.id.genderText);
        final EditText agefield = (EditText) findViewById(R.id.ageText);
        String name_text = namefield.getText().toString().trim();
        String gender_text = genderfield.getText().toString().trim();
        String age_text = agefield.getText().toString().trim();

        nameFlag = (!(name_text.isEmpty() || name_text.length() == 0 || name_text.equals("") || name_text == null));
        genderFlag = (!(gender_text.isEmpty() || gender_text.length() == 0 || gender_text.equals("") || gender_text == null));
        ageFlag = (!(age_text.isEmpty() || age_text.length() == 0 || age_text.equals("") || age_text == null));

        return (nameFlag && genderFlag && ageFlag);
    }
}
