package com.example.android.strokequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.strokequiz.R.string.question1;

public class MainActivity extends AppCompatActivity {
    /**
     * should add in functionality so that score refreshes to 0 upon hitting the button and before calculating new score
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * initialise the final score
     */
    private int finalScore = 0;
    private String answerThree = "FAST";

    /**
     * calculate score when Results button pressed
     */

    public void submitAnswers (View view) {
        finalScore = 0;
        CheckBox question1A = (CheckBox) findViewById(R.id.q1a2);
        CheckBox question1B = (CheckBox) findViewById(R.id.q1a4);
        if (question1A.isChecked() && question1B.isChecked()) {
            finalScore = finalScore + 2;
        } else if (question1A.isChecked() || question1B.isChecked()) {
            finalScore = finalScore + 1;
        } else {
            finalScore = finalScore +0;
        }

        RadioButton questionTwo = (RadioButton) findViewById(R.id.q2a3);
        if(questionTwo.isChecked()) {
            finalScore = finalScore +1;
        }

        EditText text = (EditText)findViewById(R.id.question_three);
        String name = text.getText().toString();
        if (name.equalsIgnoreCase(answerThree)) {
            finalScore = finalScore + 1;
        }


        RadioButton questionFour = (RadioButton) findViewById(R.id.q4a2);
        if(questionFour.isChecked()) {
            finalScore = finalScore +1;
        }

        RadioButton questionFive = (RadioButton) findViewById(R.id.q5a1);
        if(questionFive.isChecked()) {
            finalScore = finalScore +1;
        }
        RadioButton questionSix = (RadioButton) findViewById(R.id.q6a3);
        if(questionSix.isChecked()) {
            finalScore = finalScore +1;
        }

        RadioButton questionSeven = (RadioButton) findViewById(R.id.q7a1);
        if(questionSeven.isChecked()) {
            finalScore = finalScore +1;
        }

        Toast toast = Toast.makeText(this, "You have scored " + finalScore + " out of 8.", Toast.LENGTH_LONG);
        toast.show();
    }

}
