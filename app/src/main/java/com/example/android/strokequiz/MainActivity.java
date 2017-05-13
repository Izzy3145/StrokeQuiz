package com.example.android.strokequiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    RadioButton q2answer1;
    RadioButton q2answer2;
    RadioButton q2answer3;
    RadioButton q2answer4;
    RadioGroup question2answers;
    /**
     * initialise the final score and member variables
     */
    private int finalScore;
    private String answerThree = "FAST";

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        /**
         * make question 2 member variables so that findViewById doesnt need to be called every time question 2 is answered
         */
        q2answer1 = (RadioButton) findViewById(R.id.q2a1);
        q2answer2 = (RadioButton) findViewById(R.id.q2a2);
        q2answer3 = (RadioButton) findViewById(R.id.q2a3);
        q2answer4 = (RadioButton) findViewById(R.id.q2a4);
        question2answers = (RadioGroup) findViewById(R.id.question2answers);
    }

    /**
     * define onClick methods seen in question2, to make sure only one RadioButton is highlighted at one time
     */

    public void answer1Click(View view) {
        q2answer2.setChecked(false);
        q2answer3.setChecked(false);
        q2answer4.setChecked(false);
    }

    public void answer2Click(View view) {
        q2answer1.setChecked(false);
        q2answer3.setChecked(false);
        q2answer4.setChecked(false);
    }

    public void answer3Click(View view) {
        q2answer2.setChecked(false);
        q2answer1.setChecked(false);
        q2answer4.setChecked(false);
    }

    public void answer4Click(View view) {
        q2answer2.setChecked(false);
        q2answer3.setChecked(false);
        q2answer1.setChecked(false);
    }

    /**
     * open map when second button pressed
     */

    public void findHospital(View view) {
        String uri = "geo:" + 51.5 + "," + -0.12;
        startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));
    }

    /**
     * calculate and display score when Get Results button pressed
     */

    public void submitAnswers(View view) {
        finalScore = 0;

        /**
         * question 1 score
         */

        CheckBox question1A = (CheckBox) findViewById(R.id.q1a2);
        CheckBox question1B = (CheckBox) findViewById(R.id.q1a4);
        if (question1A.isChecked() && question1B.isChecked()) {
            finalScore += 2;
        } else if (question1A.isChecked() || question1B.isChecked()) {
            finalScore += 1;
        } else {
            finalScore +=0;
        }

        /**
         * uncheck other radio buttons when one is selected on question 2
         */


        /**
         * question 2 score
         */

        if (q2answer3.isChecked()) {
            finalScore = finalScore + 1;
        }

        /**
         * question 3 score
         */

        EditText text = (EditText) findViewById(R.id.question_three);
        String name = text.getText().toString();
        if (name.equalsIgnoreCase(answerThree)) {
            finalScore = finalScore + 1;
        }

        /**
         * question 4 score
         */

        RadioButton questionFour = (RadioButton) findViewById(R.id.q4a2);
        if (questionFour.isChecked()) {
            finalScore = finalScore + 1;
        }

        /**
         * question 5 score
         */

        RadioButton questionFive = (RadioButton) findViewById(R.id.q5a1);
        if (questionFive.isChecked()) {
            finalScore = finalScore + 1;
        }

        /**
         * question 6 score
         */

        RadioButton questionSix = (RadioButton) findViewById(R.id.q6a3);
        if (questionSix.isChecked()) {
            finalScore = finalScore + 1;
        }

        /**
         * question 7 score
         */

        RadioButton questionSeven = (RadioButton) findViewById(R.id.q7a1);
        if (questionSeven.isChecked()) {
            finalScore = finalScore + 1;
        }

        /**
         *  display score when button pressed
         */

        Toast toast = Toast.makeText(this, "You have scored " + finalScore + " out of 8.", Toast.LENGTH_LONG);
        toast.show();
    }
}