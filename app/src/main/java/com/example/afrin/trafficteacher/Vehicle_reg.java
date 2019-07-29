package com.example.afrin.trafficteacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class Vehicle_reg extends AppCompatActivity implements View.OnClickListener {

    private CardView cardView1,cardView2,cardView3;
    private TextView textView_one, textView_two, textView_three;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_reg);
        cardView1=findViewById(R.id.cardView_vehicle_one);
        cardView2=findViewById(R.id.cardView_vehicle_two);
        cardView3=findViewById(R.id.cardView_vehicle_three);



        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cardView_vehicle_one:
                startActivity(new Intent(this, Vehicle_reg_classification.class).putExtra("key","class_one"));
                break;

            case R.id.cardView_vehicle_two:
                startActivity(new Intent(this,Vehicle_reg_classification.class).putExtra("key","class_two"));
                break;
            case R.id.cardView_vehicle_three:
                startActivity(new Intent(this,Vehicle_reg_classification.class).putExtra("key","class_three"));
                break;
        }

    }
}
