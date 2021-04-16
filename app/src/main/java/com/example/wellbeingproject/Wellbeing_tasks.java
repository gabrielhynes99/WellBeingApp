package com.example.wellbeingproject;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Locale;

import static com.example.wellbeingproject.Wellbeing_emotions.emotion;

public class Wellbeing_tasks extends AppCompatActivity {
    private Toolbar toolbar;
    public TextToSpeech t1;
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
        final ImageView tts_icon = findViewById(R.id.tts_icon);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);

                    tts_icon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while(i == 0) {
                                t1.speak("What made you feel" + emotion, TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Friends", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Games", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Weather", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Sleep", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Health", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Shopping", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Dancing", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Relationship", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Music", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Work", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Learning", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Other", TextToSpeech.QUEUE_ADD, null, null);
                                i++;
                            }
                        }
                    });
                }
            }
        });

        //display what emotion they have picked
        String emotion_sentence = "What made you feel "+ emotion + " ?";
        TextView emotion_Text = findViewById(R.id.emotionfeeling);
        emotion_Text.setText(emotion_sentence);

        //to access the back button
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.stop();
                finish();
            }
        });

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wellbeing.today_report = "friends";
                t1.stop();
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_moveto_report.class);
                startActivity(intent);
            }
        });

        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wellbeing.today_report = "games";
                t1.stop();
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_moveto_report.class);
                startActivity(intent);
            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wellbeing.today_report = "weather";
                t1.stop();
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_moveto_report.class);
                startActivity(intent);
            }
        });

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wellbeing.today_report = "sleep";
                t1.stop();
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_moveto_report.class);
                startActivity(intent);
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wellbeing.today_report = "health";
                t1.stop();
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_moveto_report.class);
                startActivity(intent);
            }
        });

        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wellbeing.today_report = "shopping";
                t1.stop();
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_moveto_report.class);
                startActivity(intent);
            }
        });

        dancing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wellbeing.today_report = "dancing";
                t1.stop();
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_moveto_report.class);
                startActivity(intent);
            }
        });

        relationshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wellbeing.today_report = "relationship";
                t1.stop();
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_moveto_report.class);
                startActivity(intent);
            }
        });


        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wellbeing.today_report = "music";
                t1.stop();
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_moveto_report.class);
                startActivity(intent);
            }
        });

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wellbeing.today_report = "work";
                t1.stop();
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_moveto_report.class);
                startActivity(intent);
            }
        });


        learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wellbeing.today_report = "learning";
                t1.stop();
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_moveto_report.class);
                startActivity(intent);
            }
        });


        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wellbeing.today_report = "other";
                t1.stop();
                Intent intent = new Intent(Wellbeing_tasks.this, Wellbeing_moveto_report.class);
                startActivity(intent);
            }
        });

    }
}
