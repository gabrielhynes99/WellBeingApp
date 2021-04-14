package com.example.wellbeingproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Wellbeing_emotions extends AppCompatActivity {
    private Toolbar toolbar;
    public static String emotion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellbeing_emotions);

        ImageView backbutton = findViewById(R.id.back_button);

        //emoji setup
        CardView happy = findViewById(R.id.wellbeing_happyE);
        CardView good = findViewById(R.id.wellbeing_goodE);
        CardView okay = findViewById(R.id.wellbeing_OkayE);
        CardView bad = findViewById(R.id.wellbeing_badE);
        CardView sad = findViewById(R.id.wellbeing_sadE);
        CardView sick = findViewById(R.id.wellbeing_sickE);
        final CardView angry = findViewById(R.id.wellbeing_angryE);
        CardView anxious = findViewById(R.id.wellbeing_anxiousE);

        //to access the back button
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //when happy is selected
        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_emotions.this, Wellbeing_tasks.class);
                emotion = "happy";
                Wellbeing.feeling_report = "happy";
                startActivity(intent);
            }
        });

        //when good is selected
        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_emotions.this, Wellbeing_tasks.class);
                emotion = "good";
                Wellbeing.feeling_report = "good";
                startActivity(intent);
            }
        });

        //when okay is selected
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_emotions.this, Wellbeing_tasks.class);
                emotion = "okay";
                Wellbeing.feeling_report = "okay";
                startActivity(intent);
            }
        });

        //when bad is selected
        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_emotions.this, Wellbeing_tasks.class);
                emotion = "bad";
                Wellbeing.feeling_report = "bad";
                startActivity(intent);
            }
        });

        //when sad is selected
        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_emotions.this, Wellbeing_tasks.class);
                emotion = "sad";
                Wellbeing.feeling_report = "sad";
                startActivity(intent);
            }
        });

        //when sick is selected
        sick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_emotions.this, Wellbeing_tasks.class);
                emotion = "sick";
                Wellbeing.feeling_report = "sick";
                startActivity(intent);
            }
        });

        //when angry is selected
        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_emotions.this, Wellbeing_tasks.class);
                emotion = "angry";
                Wellbeing.feeling_report = "angry";
                startActivity(intent);
            }
        });

        //when anxious is selected
        anxious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_emotions.this, Wellbeing_tasks.class);
                emotion = "anxious";
                Wellbeing.feeling_report = "anxious";
                startActivity(intent);
            }
        });

    }
}
