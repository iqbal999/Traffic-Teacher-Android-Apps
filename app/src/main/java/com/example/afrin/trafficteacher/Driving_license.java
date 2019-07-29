package com.example.afrin.trafficteacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Driving_license extends AppCompatActivity implements View.OnClickListener {

    CardView process1,process2,process3,process4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving_license);
        process1=findViewById(R.id.cardView_li);
        process2=findViewById(R.id.cardView_nob);
        process3=findViewById(R.id.cardView_info);
        process4=findViewById(R.id.cardView_fee);

        process1.setOnClickListener(this);
        process2.setOnClickListener(this);
        process3.setOnClickListener(this);
        process4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cardView_li:
                startActivity(new Intent(this, All_Details.class).putExtra("key","dl1"));
                break;
            case R.id.cardView_nob:
                startActivity(new Intent(this,All_Details.class).putExtra("key","dl2"));
                break;
            case R.id.cardView_info:
                startActivity(new Intent(this,All_Details.class).putExtra("key","dl3"));
                break;
            case R.id.cardView_fee:
                startActivity(new Intent(this,All_Details.class).putExtra("key","dl4"));
                break;
        }
    }
}
