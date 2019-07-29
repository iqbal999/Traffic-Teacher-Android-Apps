package com.example.afrin.trafficteacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class ChooseQuiz extends AppCompatActivity implements View.OnClickListener{
    private CardView cardView_quiz_normal, cardView_quiz_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_quiz);
        cardView_quiz_normal = findViewById(R.id.cardView_quiz_normal);
        cardView_quiz_image = findViewById(R.id.cardView_quiz_image);

        cardView_quiz_normal.setOnClickListener(this);
        cardView_quiz_image.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cardView_quiz_normal:
                startActivity(new Intent(this, StartQuiz.class).putExtra("quiz_type","normal"));
                break;
            case R.id.cardView_quiz_image:
                startActivity(new Intent(this, StartQuiz.class).putExtra("quiz_type","image"));
                break;
        }
    }
}
