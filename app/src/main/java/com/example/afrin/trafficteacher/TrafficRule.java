package com.example.afrin.trafficteacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class TrafficRule extends AppCompatActivity implements View.OnClickListener {

    CardView cardView1, cardView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_rule);

        cardView1 = findViewById(R.id.cardView_rule1);
        cardView2 = findViewById(R.id.cardView_rule2);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cardView_rule1:
                startActivity(new Intent(this, Dhara_rule.class));
                break;

            case R.id.cardView_rule2:
                startActivity(new Intent(this, New_rule.class));
                break;
        }
    }
}
