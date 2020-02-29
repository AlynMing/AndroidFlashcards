package com.example.wongy.flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
            findViewById(R.id.flashcard_answer3).setBackgroundColor(getResources().getColor(R.color.colorLightGreen));
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

    findViewById(R.id.add_activity).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, addCardActivity.class);
            MainActivity.this.startActivityForResult(intent,100);
        }
    });

    findViewById(R.id.edit_question).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){

            Intent intent = new Intent(MainActivity.this, addCardActivity.class);

            String oldQuestion = ((TextView)findViewById(R.id.flashcard_question)).getText().toString();
            String oldAnswer = ((TextView)findViewById(R.id.flashcard_answer3)).getText().toString();
            intent.putExtra("String1",oldQuestion);
            intent.putExtra("String2",oldAnswer);

            MainActivity.this.startActivityForResult(intent,100);

        }
    });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String string1 = data.getExtras().getString("String1"); // 'string1' needs to match the key we used when we put the string in the Intent
            String string2 = data.getExtras().getString("String2");
            ((TextView)findViewById(R.id.flashcard_question)).setText(string1);
            ((TextView)findViewById(R.id.flashcard_answer3)).setText(string2);
        }
    }
}
