package com.example.afrin.trafficteacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class TrafficSignClassification extends AppCompatActivity implements View.OnClickListener{

    CardView cardView1, cardView2, cardView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_sign_classification);

        cardView1 = findViewById(R.id.cardView_speak);
        cardView2 = findViewById(R.id.cardView_no_speak);
        cardView3 = findViewById(R.id.cardView_alert);


        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cardView_speak:
                startActivity(new Intent(this, TrafficSignSpeak.class));
            break;

            case R.id.cardView_no_speak:
                startActivity(new Intent(this, TrafficSignNoSpeak.class));
            break;

            case R.id.cardView_alert:
                startActivity(new Intent(this, TrafficSignAlert.class));
            break;
        }
    }
}
