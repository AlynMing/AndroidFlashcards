package com.example.wongy.flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        final String question = getIntent().getStringExtra("String1");
        final String answer = getIntent().getStringExtra("String2");
        final String incAnswer1 = getIntent().getStringExtra("String3");
        final String incAnswer2 = getIntent().getStringExtra("String4");
        final String set=getIntent().getStringExtra("Set");

        if (set.equals("True")) {
            ((EditText) findViewById(R.id.newCorrectAnswer)).setText(answer);
            ((EditText) findViewById(R.id.newQuestion)).setText(question);
            ((EditText) findViewById(R.id.newIncorrectAnswer1)).setText(incAnswer1);
            ((EditText) findViewById(R.id.newIncorrectAnswer2)).setText(incAnswer2);
        }

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent data= new Intent();
                data.putExtra("String1", question);
                data.putExtra("String2", answer);
                data.putExtra("String3", incAnswer1);
                data.putExtra("String4", incAnswer2);
                setResult(RESULT_OK, data);

                finish();
                overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
            }
        });

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newQuestion = ((EditText)findViewById(R.id.newQuestion)).getText().toString();
                String newAnswer = ((EditText)findViewById(R.id.newCorrectAnswer)).getText().toString();
                String newIncAnswer1 = ((EditText)findViewById(R.id.newIncorrectAnswer1)).getText().toString();
                String newIncAnswer2 = ((EditText)findViewById(R.id.newIncorrectAnswer2)).getText().toString();


                if (newQuestion.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please type a question", Toast.LENGTH_SHORT).show();
                }else if (newAnswer.equals("") || newIncAnswer1.equals("") || newIncAnswer2.equals("")){
                    Toast.makeText(getApplicationContext(), "Please fill in the answers", Toast.LENGTH_SHORT).show();
                } else {
                    Intent data = new Intent();
                    data.putExtra("String1", newQuestion);
                    data.putExtra("String2", newAnswer);
                    data.putExtra("String3", newIncAnswer1);
                    data.putExtra("String4", newIncAnswer2);
                    setResult(RESULT_OK, data);
                    finish();
                    Toast.makeText(getApplicationContext(), "Question saved", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
