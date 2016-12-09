package ph.edu.uplb.ics.cs191.randomquizgenerator;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EndActivity extends AppCompatActivity {
    private EditText editTextName;
    private Button buttonSubmit;
    private boolean is_highscore;
    private String name;
    private int score;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);


        final TextView textViewScore = (TextView) findViewById(R.id.textViewScore);
        final Button buttonPlayAgain = (Button) findViewById(R.id.buttonPlayAgain);

        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        score = getIntent().getIntExtra("score", 0);

        textViewScore.setText(String.valueOf(score));
        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });


        try {
            int i = 0;
            final QuizDatabaseHelper quizDatabaseHelper = new QuizDatabaseHelper(this);
            final SQLiteDatabase db = quizDatabaseHelper.getReadableDatabase();

            final Cursor cursor = quizDatabaseHelper.getHighscores();
            int[] scores = new int[quizDatabaseHelper.HIGHSCORE_LIMIT];
            int[] ids = new int[quizDatabaseHelper.HIGHSCORE_LIMIT];

            while(cursor.moveToNext()) {
                ids[i] = cursor.getInt(0);
                scores[i++] = cursor.getInt(2);
                Log.i("highscore", i + ") [" + ids[i-1] + "] " + cursor.getString(1) + ": " + scores[i-1]);
            }

            final int highscoreLength = i;
            if (score > 0) {
                if (highscoreLength < quizDatabaseHelper.HIGHSCORE_LIMIT) {
                    hasHighscore();
                }
                else if (score >= scores[highscoreLength-1]) {
                    hasHighscore();
                    for (id = highscoreLength-1; id >= 0; id--) {
                        if (score == scores[id]) {
                            id = ids[id];
                            break;
                        }
                    }
                }
            }

            if(is_highscore) {
                buttonSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        name = editTextName.getText().toString().trim();
                        buttonSubmit.setEnabled(true);

                        quizDatabaseHelper.insertHighscore(db, name, score);

                        buttonSubmit.setEnabled(false);
                        editTextName.setEnabled(false);
                    }
                });
            }
        }
        catch(SQLiteException e) {}
    }

    private void hasHighscore() {
        Toast.makeText(getApplicationContext(), "HIGH SCORE!", Toast.LENGTH_SHORT).show();

        editTextName.setVisibility(View.VISIBLE);
        buttonSubmit.setVisibility(View.VISIBLE);
        is_highscore = true;
    }
}
