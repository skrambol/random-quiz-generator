package ph.edu.uplb.ics.cs191.randomquizgenerator;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class HighscoreActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listViewHighscore = getListView();

        try {
            QuizDatabaseHelper quizDatabaseHelper = new QuizDatabaseHelper(this);

            Cursor cursor = quizDatabaseHelper.getHighscores();
            CursorAdapter cursorAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,
                cursor,
                new String[]{"NAME", "SCORE"},
                new int[]{android.R.id.text1, android.R.id.text2}
            );

            listViewHighscore.setAdapter(cursorAdapter);

        }
        catch(SQLiteException e) {}
    }
}
