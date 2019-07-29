package com.example.afrin.trafficteacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class All_Details extends AppCompatActivity {
    TextView textView_title, textView_body;
    String key;
    public static final String MR1 = "নতুন মোটরযানের নিবন্ধন";
    public static final String MR2 = "রিকন্ডিশন মোটরযানের নিবন্ধন";
    public static final String MR3 = "নিলামে ক্রয়কৃত মোটরযানের নিবন্ধন";
    public static final String MR4 = "ক্রয় সূত্রে";
    public static final String MR5 = "উত্তররাধিকার সুূত্রে";
    public static final String MR6 = "দান সূত্রে";
    public static final String MR7 = "ফিটনেস নবায়ন";
    public static final String MR8 = "টেক্স টোকেন নবায়ন";
    public static final String MR9 = "রুট পারমিট নবায়ন";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_details);
        Intent i = getIntent();
        key = i.getStringExtra("key");

        textView_title = findViewById(R.id.text_title);
        textView_body = findViewById(R.id.textBody);

        switch (key) {

            case "dl1":
                textView_title.setText(R.string.license_process_title);
                textView_body.setText(R.string.license_process);
                break;
            case "dl2":
                textView_title.setText(R.string.license_nob_title);
                textView_body.setText(R.string.license_nob);
                break;
            case "dl3":
                textView_title.setText(R.string.license_inf_title);
                textView_body.setText(R.string.license_inf);
                break;
            case "dl4":
                textView_title.setText(R.string.license_fee_title);
                textView_body.setText(R.string.license_fee);
                break;
            case MR1:
                textView_title.setText(R.string.mr1_title);
                textView_body.setText(R.string.mr1_desc);
                break;
            case MR2:
                textView_title.setText(R.string.mr2_title);
                textView_body.setText(R.string.mr2_desc);
                break;
            case MR3:
                textView_title.setText(R.string.mr3_title);
                textView_body.setText(R.string.mr3_desc);
                break;
            case MR4:
                textView_title.setText(R.string.mr4_title);
                textView_body.setText(R.string.mr4_desc);
                break;
            case MR5:
                textView_title.setText(R.string.mr5_title);
                textView_body.setText(R.string.mr5_desc);
                break;
            case MR6:
                textView_title.setText(R.string.mr6_title);
                textView_body.setText(R.string.mr6_desc);
                break;
            case MR7:
                textView_title.setText(R.string.mr7_title);
                textView_body.setText(R.string.mr7_desc);
                break;
            case MR8:
                textView_title.setText(R.string.mr8_title);
                textView_body.setText(R.string.mr8_desc);
                break;
            case MR9:
                textView_title.setText(R.string.mr9_title);
                textView_body.setText(R.string.mr9_desc);
                break;

        }
    }
}
