package com.example.wongy.flashcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            findViewById(R.id.flashcard_question).setVisibility(view.VISIBLE);
            findViewById(R.id.flashcard_answer1).setBackgroundColor(getResources().getColor(R.color.colorCream));
            findViewById(R.id.flashcard_answer2).setBackgroundColor(getResources().getColor(R.color.colorCream));
            findViewById(R.id.flashcard_answer3).setBackgroundColor(getResources().getColor(R.color.colorCream));
        }
    });

    findViewById(R.id.flashcard_answer1).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            findViewById(R.id.flashcard_answer1).setBackgroundColor(getResources().getColor(R.color.colorDarkRed));
            findViewById(R.id.flashcard_answer2).setBackgroundColor(getResources().getColor(R.color.colorCream));
            findViewById(R.id.flashcard_answer3).setBackgroundColor(getResources().getColor(R.color.colorLightGreen));
        }
    });


    findViewById(R.id.flashcard_answer2).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            findViewById(R.id.flashcard_answer1).setBackgroundColor(getResources().getColor(R.color.colorCream));
            findViewById(R.id.flashcard_answer2).setBackgroundColor(getResources().getColor(R.color.colorDarkRed));
            findViewById(R.id.flashcard_answer3).setBackgroundColor(getResources().getColor(R.color.colorLightGreen));
        }
    });

    findViewById(R.id.flashcard_answer3).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            findViewById(R.id.flashcard_answer1).setBackgroundColor(getResources().getColor(R.color.colorCream));
            findViewById(R.id.flashcard_answer2).setBackgroundColor(getResources().getColor(R.color.colorCream));
            findViewById(R.id.flashcard_answer3).setBackgroundColor(getResources().getColor(R.color.colorLightGreen));
        }
    });

    }
}
