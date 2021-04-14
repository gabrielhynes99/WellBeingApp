package com.example.wellbeingproject;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Wellbeing extends AppCompatActivity {
    private Toolbar toolbar;
    public static String day_report;
    public static String feeling_report;
    public static String today_report;
    public static String aboutday_report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellbeing);
        aboutday_report = "";

        ImageView backbutton = findViewById(R.id.back_button);

        //enjoy setup
        CardView reallyGood = findViewById(R.id.wellbeing_amazing);
        CardView good = findViewById(R.id.wellbeing_good);
        CardView okay = findViewById(R.id.wellbeing_ok);
        CardView bad = findViewById(R.id.wellbeing_bad);
        CardView reallyBad = findViewById(R.id.wellbeing_really_bad);

        //to access the back button
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //reallyGood is pressed
        reallyGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day_report = "really good";
                Intent intent = new Intent(Wellbeing.this, Wellbeing_emotions.class);
                startActivity(intent);
            }
        });

        //good is pressed
        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day_report = "good";
                Intent intent = new Intent(Wellbeing.this, Wellbeing_emotions.class);
                startActivity(intent);
            }
        });

        //okay is pressed
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day_report = "okay";
                Intent intent = new Intent(Wellbeing.this, Wellbeing_emotions.class);
                startActivity(intent);
            }
        });

        //bad is pressed
        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day_report = "bad";
                Intent intent = new Intent(Wellbeing.this, Wellbeing_emotions.class);
                startActivity(intent);
            }
        });

        //really bad is pressed
        reallyBad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day_report = "really bad";
                Intent intent = new Intent(Wellbeing.this, Wellbeing_emotions.class);
                startActivity(intent);
            }
        });

    }
}
