package ph.edu.uplb.ics.cs191.randomquizgenerator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuizDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Quiz";
    private static final int DB_VERSION = 1;

    public QuizDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
            "CREATE TABLE QUESTION(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "QUESTION TEXT, " +
            "CHOICE_A TEXT, " +
            "CHOICE_B TEXT, " +
            "CHOICE_C TEXT, " +
            "CHOICE_D TEXT, " +
            "ANSWER INT);"
        );

        populateQuestions(db);

        db.execSQL(
            "CREATE TABLE HIGHSCORE(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NAME TEXT, " +
            "SCORE INT); "
        );

        populateHighscores(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertQuestion(SQLiteDatabase db, String question, String[] choices, int answer) {
        ContentValues questionInfo = new ContentValues();
        questionInfo.put("QUESTION", question);
        questionInfo.put("CHOICE_A", choices[0]);
        questionInfo.put("CHOICE_B", choices[1]);
        questionInfo.put("CHOICE_C", choices[2]);
        questionInfo.put("CHOICE_D", choices[3]);
        questionInfo.put("ANSWER", answer);

        db.insert("QUESTION", null, questionInfo);
    }

    public void editQuestion(SQLiteDatabase db, int id, String question, String[] choices, String answer) {
        ContentValues questionInfo = new ContentValues();
        questionInfo.put("QUESTION", question);
        questionInfo.put("CHOICE_A", choices[0]);
        questionInfo.put("CHOICE_B", choices[1]);
        questionInfo.put("CHOICE_C", choices[2]);
        questionInfo.put("CHOICE_D", choices[3]);
        questionInfo.put("ANSWER", answer);

        db.update("QUESTION", questionInfo, "_id=?", new String[]{String.valueOf(id)});
    }

    public void deleteQuestion(SQLiteDatabase db, int id) {
        db.delete("QUESTION", "_id=?", new String[]{String.valueOf(id)});
    }
    private void populateQuestions(SQLiteDatabase db) {
        insertQuestion(db,
            "What is 1+1?",
            new String[]{"1", "2", "3", "4"},
            1
        );
        insertQuestion(db,
            "There are _____ islands in the Philippines.",
            new String[]{"3", "1701", "7107", "7117"},
            2
        );
        insertQuestion(db,
            "When was Facebook founded?",
            new String[]{"April 2, 2004", "March 13, 2004", "December 25, 2004", "February 4, 2004"},
            3
        );
    }

    public void insertHighscore(SQLiteDatabase db, String name, int score) {
        ContentValues highscoreInfo = new ContentValues();
        highscoreInfo.put("NAME", name);
        highscoreInfo.put("SCORE", score);

        db.insert("HIGHSCORE", null, highscoreInfo);
    }
    private void populateHighscores(SQLiteDatabase db) {

    }

}
