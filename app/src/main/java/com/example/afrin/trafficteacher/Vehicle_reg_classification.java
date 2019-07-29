package com.example.afrin.trafficteacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class Vehicle_reg_classification extends AppCompatActivity implements View.OnClickListener {

    private CardView cardView_one, cardView_two, cardView_three;
    private TextView textView_one, textView_two, textView_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_reg_classification);
        Intent i = getIntent();

        textView_one = findViewById(R.id.text_view_one);
        textView_two = findViewById(R.id.text_view_two);
        textView_three = findViewById(R.id.text_view_three);

        cardView_one = findViewById(R.id.cardView_vehicle_one);
        cardView_two = findViewById(R.id.cardView_vehicle_two);
        cardView_three = findViewById(R.id.cardView_vehicle_three);

        cardView_one.setOnClickListener(this);
        cardView_two.setOnClickListener(this);
        cardView_three.setOnClickListener(this);

        switch (i.getStringExtra("key")) {
            case "class_one":
                textView_one.setText(R.string.mr1);
                textView_two.setText(R.string.mr2);
                textView_three.setText(R.string.mr3);
                break;
            case "class_two":
                textView_one.setText(R.string.mr4);
                textView_two.setText(R.string.mr5);
                textView_three.setText(R.string.mr6);
                break;

            case "class_three":
                textView_one.setText(R.string.mr7);
                textView_two.setText(R.string.mr8);
                textView_three.setText(R.string.mr9);
                break;
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cardView_vehicle_one:
                startActivity(new Intent(this, All_Details.class).putExtra("key", textView_one.getText()));
                break;
            case R.id.cardView_vehicle_two:
                startActivity(new Intent(this, All_Details.class).putExtra("key", textView_two.getText()));
                break;
            case R.id.cardView_vehicle_three:
                startActivity(new Intent(this, All_Details.class).putExtra("key", textView_three.getText()));
                break;
        }
    }
}
