package com.example.android.scoretracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String SCORE_A_ID = "scoreTeamA";
    static final String SCORE_B_ID = "scoreTeamB";
    int scoreTeamA;
    int scoreTeamB;

    //saving data on orientation change
    //huge thanks to Dagger for this bit
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(SCORE_A_ID, scoreTeamA);
        savedInstanceState.putInt(SCORE_B_ID, scoreTeamB);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }


    //one way of restoring value -> overriding onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Always call the superclass first

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            scoreTeamA = savedInstanceState.getInt(SCORE_A_ID);
            scoreTeamB = savedInstanceState.getInt(SCORE_B_ID);
        } else {
            // Initialize members with default values for a new instance
            scoreTeamA = 0;
            scoreTeamB = 0;
        }
        setContentView(R.layout.activity_main);

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {

        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }


    public void Reset(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        EditText teamNameA = findViewById(R.id.team_a_name);
        teamNameA.setText("");
        EditText teamNameB = findViewById(R.id.team_b_name);
        teamNameB.setText("");
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
        EditText teamNameA = findViewById(R.id.team_a_name);
        String teamA = teamNameA.getText().toString();
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {

        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
        EditText teamNameB = findViewById(R.id.team_b_name);
        String teamB = teamNameB.getText().toString();
    }

}