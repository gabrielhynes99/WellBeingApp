package com.example.wellbeingproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import static com.example.wellbeingproject.Wellbeing_emotions.emotion;

public class Wellbeing_tasks extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellbeing_tasks);

        ImageView backbutton = findViewById(R.id.back_button);

        //set up task emoji
        CardView friends = findViewById(R.id.wellbeing_friends);
        CardView games = findViewById(R.id.wellbeing_games);
        CardView weather = findViewById(R.id.wellbeing_weather);
        CardView sleep = findViewById(R.id.wellbeing_sleep);
        CardView health = findViewById(R.id.wellbeing_health);
        CardView shopping = findViewById(R.id.wellbeing_shopping);
        CardView dancing = findViewById(R.id.wellbeing_dancing);
        CardView relationshop = findViewById(R.id.wellbeing_relationship);
        CardView music = findViewById(R.id.wellbeing_music);
        CardView work = findViewById(R.id.wellbeing_work);
        CardView learning = findViewById(R.id.wellbeing_Learning);
        CardView other = findViewById(R.id.wellbeing_other);

        //display what emotion they have picked
        String emotion_sentence = "What made you feel "+ emotion + " ?";
        TextView emotion_Text = findViewById(R.id.emotionfeeling);
        emotion_Text.setText(emotion_sentence);

        //to access the back button
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_finalreport.class);
                startActivity(intent);
            }
        });

        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_finalreport.class);
                startActivity(intent);
            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_finalreport.class);
                startActivity(intent);
            }
        });

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_finalreport.class);
                startActivity(intent);
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_finalreport.class);
                startActivity(intent);
            }
        });

        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_finalreport.class);
                startActivity(intent);
            }
        });

        dancing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_finalreport.class);
                startActivity(intent);
            }
        });

        relationshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_finalreport.class);
                startActivity(intent);
            }
        });


        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_finalreport.class);
                startActivity(intent);
            }
        });

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_finalreport.class);
                startActivity(intent);
            }
        });


        learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_finalreport.class);
                startActivity(intent);
            }
        });


        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_finalreport.class);
                startActivity(intent);
            }
        });

    }
}
