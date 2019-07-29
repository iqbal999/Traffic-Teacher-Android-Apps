package com.example.afrin.trafficteacher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartQuiz extends AppCompatActivity {

    Intent i,intent;
    private static final int REQUEST_CODE_QUIZ_NORMAL = 1;
    private static final int REQUEST_CODE_QUIZ_IMAGE = 2;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE_NORMAL = "keyHighscoreNormal";
    public static final String KEY_HIGHSCORE_IMAGE = "keyHighscoreImage";

    private TextView textViewYourscore, textViewHighscore, textViewQuizTitle;

    private int highscore;
    String quiz_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);
        i = getIntent();
        quiz_type = i.getStringExtra("quiz_type");

        textViewHighscore = findViewById(R.id.text_view_highscore);
        textViewQuizTitle = findViewById(R.id.text_view_quiz_title);
        textViewYourscore = findViewById(R.id.text_view_yourscore);

        if(quiz_type.equals("normal")){
            textViewQuizTitle.setText(R.string.normal_quiz);
        }else if(quiz_type.equals("image")){
            textViewQuizTitle.setText(R.string.image_quiz);
        }

        loadHighscore();

        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
    }

    private void startQuiz() {
        if(quiz_type.equals("normal")){
            intent = new Intent(StartQuiz.this, QuizActivity.class);
            startActivityForResult(intent, REQUEST_CODE_QUIZ_NORMAL);
        }else if(quiz_type.equals("image")){
            intent = new Intent(StartQuiz.this, QuizActivityImage.class);
            startActivityForResult(intent, REQUEST_CODE_QUIZ_IMAGE);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ_NORMAL) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE_NORMAL, 0);
                textViewYourscore.setText("Your Score: "+score);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }else if (requestCode == REQUEST_CODE_QUIZ_IMAGE) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivityImage.EXTRA_SCORE_IMAGE, 0);
                textViewYourscore.setText("Your Score: "+score);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }
    }

    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        if(quiz_type.equals("normal")){
            highscore = prefs.getInt(KEY_HIGHSCORE_NORMAL, 0);
        }else if(quiz_type.equals("image")){
            highscore = prefs.getInt(KEY_HIGHSCORE_IMAGE, 0);
        }
        textViewHighscore.setText("Highscore: " + highscore);
    }

    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("Highscore: " + highscore);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        if(quiz_type.equals("normal")){
            editor.putInt(KEY_HIGHSCORE_NORMAL, highscore);
        }else if(quiz_type.equals("image")){
            editor.putInt(KEY_HIGHSCORE_IMAGE, highscore);
        }

        editor.apply();
    }
}
