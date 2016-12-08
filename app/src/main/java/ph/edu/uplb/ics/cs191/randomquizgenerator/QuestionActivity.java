package ph.edu.uplb.ics.cs191.randomquizgenerator;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class QuestionActivity extends AppCompatActivity {

    private int seconds;
    private boolean running;
    private int score;
    private String yourAnswer;
    private String correctAnswer;
    private int currentQuestion;
    private LinkedList<Question> questions;

    private Toast toastCorrect;
    private Toast toastWrong;
    private Toast toastNoTime;
    public static final int MIN_TIME = 10;
    public static final int NUM_QUESTIONS = 10;
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
        buttonNext = (Button) findViewById(R.id.buttonNext);

        questions = new LinkedList<Question>();
        running = false;
        currentQuestion = -1;
        score = 0;

        toastCorrect = Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT);
        toastWrong = Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT);
        toastNoTime = Toast.makeText(getApplicationContext(), "Time's up!", Toast.LENGTH_SHORT);

        try {
            SQLiteOpenHelper quizDatabaseHelper = new QuizDatabaseHelper(this);
            SQLiteDatabase db = quizDatabaseHelper.getReadableDatabase();

            Cursor cursor = db.query("QUESTION",
                new String[]{"QUESTION", "CHOICE_A", "CHOICE_B", "CHOICE_C", "CHOICE_D", "ANSWER"},
                null,
                null,
                null,
                null,
                "RANDOM()"
            );

            while(cursor.moveToNext()) {
                questions.add(new Question(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
                Log.v("question", questions.get(questions.size()-1).toString());
            }

            cursor.close();
            db.close();
        }
        catch(SQLiteException e){

        }

        final TextView textViewScore = (TextView) findViewById(R.id.textViewScore);


        View.OnClickListener onAnswer = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seconds > 0 && correctAnswer.equals(((Button)v).getText())) {
                    score++;
                    textViewScore.setText(String.valueOf(score));
                    toastCorrect.show();
                    nextQuestion();
                }
                else {
                    toastWrong.show();
                    seconds = -1;
                    buttonA.setEnabled(false);
                    buttonB.setEnabled(false);
                    buttonC.setEnabled(false);
                    buttonD.setEnabled(false);
                }
            }
        };

        buttonA.setOnClickListener(onAnswer);
        buttonB.setOnClickListener(onAnswer);
        buttonC.setOnClickListener(onAnswer);
        buttonD.setOnClickListener(onAnswer);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        });

        nextQuestion();
        runTimer();
    }

    private void runTimer() {
        final TextView textViewTime = (TextView) findViewById(R.id.textViewTime);
        final Handler handler = new Handler();

        running = true;

        handler.post(new Runnable(){
            @Override
            public void run() {
                if (running && seconds >= 0) {
                    textViewTime.setTextColor(
                            seconds > 10
                                    ? Color.GRAY
                                    : Color.RED
                    );
                    textViewTime.setText(String.valueOf(seconds));

                    if (seconds == 0) {
                        toastNoTime.show();
                    }

                    seconds--;

                }
                handler.postDelayed(this, 1000);

            }
        });
    }

    private void nextQuestion() {
        seconds = MIN_TIME;
        currentQuestion++;

        Question q = questions.get(currentQuestion);
        TextView textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);
        TextView textViewA = (TextView) findViewById(R.id.textViewA);
        TextView textViewB = (TextView) findViewById(R.id.textViewB);
        TextView textViewC = (TextView) findViewById(R.id.textViewC);
        TextView textViewD = (TextView) findViewById(R.id.textViewD);

        textViewQuestion.setText(q.getQuestion());
        textViewA.setText(q.getChoiceA());
        textViewB.setText(q.getChoiceB());
        textViewC.setText(q.getChoiceC());
        textViewD.setText(q.getChoiceD());

        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);

        correctAnswer = q.getAnswer();
    }
}
