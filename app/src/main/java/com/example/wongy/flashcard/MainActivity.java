package com.example.wongy.flashcard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Boolean _visible = true;

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

    findViewById(R.id.toggle_choice_visibility).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (_visible==true) {
                _visible=false;
                findViewById(R.id.flashcard_answer1).setVisibility(view.INVISIBLE);
                findViewById(R.id.flashcard_answer2).setVisibility(view.INVISIBLE);
                findViewById(R.id.flashcard_answer3).setVisibility(view.INVISIBLE);
                ((ImageView) findViewById(R.id.toggle_choice_visibility)).setImageResource(R.drawable.ic_eyec);
            } else {
                _visible=true;
                findViewById(R.id.flashcard_answer1).setVisibility(view.VISIBLE);
                findViewById(R.id.flashcard_answer2).setVisibility(view.VISIBLE);
                findViewById(R.id.flashcard_answer3).setVisibility(view.VISIBLE);
                findViewById(R.id.flashcard_answer1).setBackgroundColor(getResources().getColor(R.color.colorCream));
                findViewById(R.id.flashcard_answer2).setBackgroundColor(getResources().getColor(R.color.colorCream));
                findViewById(R.id.flashcard_answer3).setBackgroundColor(getResources().getColor(R.color.colorCream));
                ((ImageView) findViewById(R.id.toggle_choice_visibility)).setImageResource(R.drawable.ic_eyeo);
            }
        }
    });

    }
}
