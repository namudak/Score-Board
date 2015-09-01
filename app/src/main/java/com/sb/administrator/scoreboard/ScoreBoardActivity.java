package com.sb.administrator.scoreboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ScoreBoardActivity extends AppCompatActivity {
    private final int SCORE0= 0, SCORE1= 1, SCORE2= 2, SCORE3= 3;

    // Declare member fields for Score sum and count
    private TextView mScoreTeamATextView;
    private TextView mScoreTeamBTextView;

    private int mScoreSumTeamA;
    private int mScoreSumTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        // Create member fields for Team A
        mScoreTeamATextView = (TextView)findViewById(R.id.score_teama);
        // Create member fields for Team B
        mScoreTeamBTextView = (TextView)findViewById(R.id.score_teamb);

        // Initialize member fields(total score)  as 0
        mScoreSumTeamA= mScoreSumTeamB= 0;

        // Set Listener for each button
        findViewById(R.id.score1_teama_button).setOnClickListener(mClickListener);
        findViewById(R.id.score2_teama_button).setOnClickListener(mClickListener);
        findViewById(R.id.score3_teama_button).setOnClickListener(mClickListener);

        findViewById(R.id.score1_teamb_button).setOnClickListener(mClickListener);
        findViewById(R.id.score2_teamb_button).setOnClickListener(mClickListener);
        findViewById(R.id.score3_teamb_button).setOnClickListener(mClickListener);

        findViewById(R.id.score_reset_button).setOnClickListener(mClickListener);

    }

    Button.OnClickListener mClickListener= new View.OnClickListener() {
        public void onClick(View view) {

            // Manage multi view using one listener
            switch (view.getId()) {
                case R.id.score1_teama_button:
                    mScoreSumTeamA+= SCORE1;
                    break;
                case R.id.score2_teama_button:
                    mScoreSumTeamA+= SCORE2;
                    break;
                case R.id.score3_teama_button:
                    mScoreSumTeamA+= SCORE3;
                    break;
                case R.id.score1_teamb_button:
                    mScoreSumTeamB+= SCORE1;
                    break;
                case R.id.score2_teamb_button:
                    mScoreSumTeamB+= SCORE2;
                    break;
                case R.id.score3_teamb_button:
                    mScoreSumTeamB+= SCORE3;
                    break;

                case R.id.score_reset_button:
                    mScoreSumTeamA= SCORE0;
                    mScoreSumTeamB= SCORE0;
                    break;
            }
            // Set the score edittext box to current sum each
            mScoreTeamATextView.setText(Integer.toString(mScoreSumTeamA));
            mScoreTeamBTextView.setText(Integer.toString(mScoreSumTeamB));

        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_score_board, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
