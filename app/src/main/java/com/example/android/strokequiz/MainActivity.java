package com.example.android.strokequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.R.attr.name;
import static com.example.android.strokequiz.R.string.question1;

public class MainActivity extends AppCompatActivity {
    /**
     * initialise the final score
     */
    private int finalScore = 0;
    private String answerThree = "FAST";

    /**
     * should add in functionality so that score refreshes to 0 upon hitting the button and before calculating new score
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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
            finalScore = finalScore + 2;
        } else if (question1A.isChecked() || question1B.isChecked()) {
            finalScore = finalScore + 1;
        } else {
            finalScore = finalScore + 0;
        }

        /**
         * uncheck other radio buttons when one is selected on question 2
         */

        RadioGroup question2answers = (RadioGroup) findViewById(R.id.question2answers);

        RadioButton q2answer1 = (RadioButton) findViewById(R.id.q2a1);
        boolean wrongAnswer1 = q2answer1.isChecked();
        RadioButton q2answer2 = (RadioButton) findViewById(R.id.q2a2);
        boolean wrongAnswer2 = q2answer2.isChecked();
        RadioButton q2answer3 = (RadioButton) findViewById(R.id.q2a3);
        boolean rightAnswer3 = q2answer3.isChecked();
        RadioButton q2answer4 = (RadioButton) findViewById(R.id.q2a4);
        boolean wrongAnswer4 = q2answer4.isChecked();

        if (wrongAnswer1) {
            question2answers.clearCheck();
        } else if (wrongAnswer2) {
            question2answers.clearCheck();
        } else if (rightAnswer3) {
            question2answers.clearCheck();
        } else if (wrongAnswer4) {
            question2answers.clearCheck();
        }

        /**
         * question 2 score
         */

        if (rightAnswer3) {
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
         * display score when button pressed
         */

        Toast toast = Toast.makeText(this, "You have scored " + finalScore + " out of 8.", Toast.LENGTH_LONG);
        toast.show();
    }
}