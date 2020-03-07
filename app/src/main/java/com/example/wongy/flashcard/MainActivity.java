package com.example.wongy.flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    private Boolean _visible = true;
    private String _originalQ;
    private String _originalA;
    FlashcardDatabase flashcardDatabase;
    List<Flashcard> allFlashcards;
    int currentCardDisplayedIndex = 0;
    private final int edit_card= 50;
    private Flashcard cardToEdit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flashcardDatabase = new FlashcardDatabase(getApplicationContext());
        allFlashcards = flashcardDatabase.getAllCards();

        if (allFlashcards != null && allFlashcards.size() > 0) {
            ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(0).getQuestion());
            ((TextView) findViewById(R.id.flashcard_answer3)).setText(allFlashcards.get(0).getAnswer());
            ((TextView) findViewById(R.id.flashcard_answer1)).setText(allFlashcards.get(0).getWrongAnswer1());
            ((TextView) findViewById(R.id.flashcard_answer2)).setText(allFlashcards.get(0).getWrongAnswer2());
        }
        if (allFlashcards.size()==1 || allFlashcards.size()==0 ){
            findViewById(R.id.next).setVisibility(INVISIBLE);
        }

    findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            findViewById(R.id.flashcard_question).setVisibility(VISIBLE);
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
                findViewById(R.id.flashcard_answer1).setVisibility(INVISIBLE);
                findViewById(R.id.flashcard_answer2).setVisibility(INVISIBLE);
                findViewById(R.id.flashcard_answer3).setVisibility(INVISIBLE);
                ((ImageView) findViewById(R.id.toggle_choice_visibility)).setImageResource(R.drawable.ic_eyec);
            } else {
                _visible=true;
                findViewById(R.id.flashcard_answer1).setVisibility(VISIBLE);
                findViewById(R.id.flashcard_answer2).setVisibility(VISIBLE);
                findViewById(R.id.flashcard_answer3).setVisibility(VISIBLE);
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

            String oldQuestion = ((TextView)findViewById(R.id.flashcard_question)).getText().toString();
            String oldAnswer = ((TextView)findViewById(R.id.flashcard_answer3)).getText().toString();
            String oldIncAnswer1 = ((TextView)findViewById(R.id.flashcard_answer1)).getText().toString();
            String oldIncAnswer2 = ((TextView)findViewById(R.id.flashcard_answer2)).getText().toString();
            intent.putExtra("String1",oldQuestion);
            intent.putExtra("String2",oldAnswer);
            intent.putExtra("String3",oldIncAnswer1);
            intent.putExtra("String4",oldIncAnswer2);

            intent.putExtra("Set","False");

            MainActivity.this.startActivityForResult(intent,100);
            findViewById(R.id.next).setVisibility(VISIBLE);
        }
    });

    findViewById(R.id.edit_question).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){

            cardToEdit=allFlashcards.get(currentCardDisplayedIndex);
            Intent intent = new Intent(MainActivity.this, addCardActivity.class);

            String oldQuestion = ((TextView)findViewById(R.id.flashcard_question)).getText().toString();
            String oldAnswer = ((TextView)findViewById(R.id.flashcard_answer3)).getText().toString();
            String oldIncAnswer1 = ((TextView)findViewById(R.id.flashcard_answer1)).getText().toString();
            String oldIncAnswer2 = ((TextView)findViewById(R.id.flashcard_answer2)).getText().toString();
            intent.putExtra("String1",oldQuestion);
            intent.putExtra("String2",oldAnswer);
            intent.putExtra("String3",oldIncAnswer1);
            intent.putExtra("String4",oldIncAnswer2);

            intent.putExtra("Set","True");

            MainActivity.this.startActivityForResult(intent,edit_card);

        }
    });

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                currentCardDisplayedIndex++;
                findViewById(R.id.back).setVisibility(VISIBLE);

                // make sure we don't get an IndexOutOfBoundsError if we are viewing the last indexed card in our list
                if (currentCardDisplayedIndex == allFlashcards.size() - 1) {
//                    currentCardDisplayedIndex = 0;
                    findViewById(R.id.next).setVisibility(INVISIBLE);
                }
                ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                ((TextView) findViewById(R.id.flashcard_answer3)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
                ((TextView) findViewById(R.id.flashcard_answer1)).setText(allFlashcards.get(currentCardDisplayedIndex).getWrongAnswer1());
                ((TextView) findViewById(R.id.flashcard_answer2)).setText(allFlashcards.get(currentCardDisplayedIndex).getWrongAnswer2());
                findViewById(R.id.flashcard_answer1).setBackgroundColor(getResources().getColor(R.color.colorCream));
                findViewById(R.id.flashcard_answer2).setBackgroundColor(getResources().getColor(R.color.colorCream));
                findViewById(R.id.flashcard_answer3).setBackgroundColor(getResources().getColor(R.color.colorCream));

            }
        });

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                currentCardDisplayedIndex--;
                findViewById(R.id.next).setVisibility(VISIBLE);


                // make sure we don't get an IndexOutOfBoundsError if we are viewing the last indexed card in our list
                if (currentCardDisplayedIndex ==0) {
                    findViewById(R.id.back).setVisibility(INVISIBLE);
                }
                ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                ((TextView) findViewById(R.id.flashcard_answer3)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
                ((TextView) findViewById(R.id.flashcard_answer1)).setText(allFlashcards.get(currentCardDisplayedIndex).getWrongAnswer1());
                ((TextView) findViewById(R.id.flashcard_answer2)).setText(allFlashcards.get(currentCardDisplayedIndex).getWrongAnswer2());
                findViewById(R.id.flashcard_answer1).setBackgroundColor(getResources().getColor(R.color.colorCream));
                findViewById(R.id.flashcard_answer2).setBackgroundColor(getResources().getColor(R.color.colorCream));
                findViewById(R.id.flashcard_answer3).setBackgroundColor(getResources().getColor(R.color.colorCream));

            }
        });

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flashcardDatabase.deleteCard(((TextView) findViewById(R.id.flashcard_question)).getText().toString());
                        allFlashcards = flashcardDatabase.getAllCards();
                        if (allFlashcards.size()!=0) {
                            ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(0).getQuestion());
                            ((TextView) findViewById(R.id.flashcard_answer3)).setText(allFlashcards.get(0).getAnswer());
                            ((TextView) findViewById(R.id.flashcard_answer1)).setText(allFlashcards.get(0).getWrongAnswer1());
                            ((TextView) findViewById(R.id.flashcard_answer2)).setText(allFlashcards.get(0).getWrongAnswer2());
                        } else {
                            ((TextView) findViewById(R.id.flashcard_question)).setText("Please make a card");
                            (findViewById(R.id.flashcard_answer3)).setVisibility(INVISIBLE);
                            (findViewById(R.id.flashcard_answer1)).setVisibility(INVISIBLE);
                            (findViewById(R.id.flashcard_answer2)).setVisibility(INVISIBLE);
                            (findViewById(R.id.next)).setVisibility(INVISIBLE);
                            (findViewById(R.id.delete)).setVisibility(INVISIBLE);
                        }
                        if (allFlashcards.size()==1){
                            (findViewById(R.id.next)).setVisibility(INVISIBLE);
                            (findViewById(R.id.back)).setVisibility(INVISIBLE);
                        }
                    }
                });

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String question = data.getExtras().getString("String1"); // 'string1' needs to match the key we used when we put the string in the Intent
            String correctAnswer = data.getExtras().getString("String2");
            String incorrectAnswer1 = data.getExtras().getString("String3");
            String incorrectAnswer2 = data.getExtras().getString("String4");
            flashcardDatabase.insertCard(new Flashcard(question, correctAnswer, incorrectAnswer1, incorrectAnswer2 ));
            allFlashcards = flashcardDatabase.getAllCards();
            if (allFlashcards.size()==1){
                ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                ((TextView) findViewById(R.id.flashcard_answer3)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
                ((TextView) findViewById(R.id.flashcard_answer1)).setText(allFlashcards.get(currentCardDisplayedIndex).getWrongAnswer1());
                ((TextView) findViewById(R.id.flashcard_answer2)).setText(allFlashcards.get(currentCardDisplayedIndex).getWrongAnswer2());
                (findViewById(R.id.next)).setVisibility(INVISIBLE);
            } else {
                (findViewById(R.id.next)).setVisibility(VISIBLE);
            }
        } else if (requestCode == edit_card) {
            String question = data.getExtras().getString("String1"); // 'string1' needs to match the key we used when we put the string in the Intent
            String correctAnswer = data.getExtras().getString("String2");
            String incorrectAnswer1 = data.getExtras().getString("String3");
            String incorrectAnswer2 = data.getExtras().getString("String4");
            cardToEdit.setQuestion(question);
            cardToEdit.setAnswer(correctAnswer);
            cardToEdit.setWrongAnswer1(incorrectAnswer1);
            cardToEdit.setWrongAnswer2(incorrectAnswer2);

            flashcardDatabase.updateCard(cardToEdit);
            ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
            ((TextView) findViewById(R.id.flashcard_answer3)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
            ((TextView) findViewById(R.id.flashcard_answer1)).setText(allFlashcards.get(currentCardDisplayedIndex).getWrongAnswer1());
            ((TextView) findViewById(R.id.flashcard_answer2)).setText(allFlashcards.get(currentCardDisplayedIndex).getWrongAnswer2());



        }


    }
}
