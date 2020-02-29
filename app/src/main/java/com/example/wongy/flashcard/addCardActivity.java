package com.example.wongy.flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class addCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newQuestion = ((EditText)findViewById(R.id.newQuestion)).getText().toString();
                String newAnswer = ((EditText)findViewById(R.id.newAnswer)).getText().toString();

                Intent data = new Intent();
                data.putExtra("String1",newQuestion);
                data.putExtra("String2",newAnswer);
                setResult(RESULT_OK, data);
                finish();
            }
        });


    }
}
