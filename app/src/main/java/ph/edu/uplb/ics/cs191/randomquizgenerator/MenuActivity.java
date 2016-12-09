package ph.edu.uplb.ics.cs191.randomquizgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button buttonStart = (Button) findViewById(R.id.buttonStart);
        Button buttonHighscore = (Button) findViewById(R.id.buttonHelp);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, QuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonHighscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, HighscoreActivity.class);
                startActivity(intent);
            }
        });
    }
}
