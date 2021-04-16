package com.example.wellbeingproject;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Locale;

public class Wellbeing_emotions extends AppCompatActivity {
    private Toolbar toolbar;
    public static String emotion;
    public TextToSpeech t1;

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
                                t1.speak("How are you feeling today?", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Happy", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Good", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Okay", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Bad", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Sad", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Sick", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Angry", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Anxious", TextToSpeech.QUEUE_ADD, null, null);
                                i++;
                            }
                        }
                    });
                }
            }
        });

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
                t1.stop();
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
                t1.stop();
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
                t1.stop();
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
                t1.stop();
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
                t1.stop();
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
                t1.stop();
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
                t1.stop();
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
                t1.stop();
                startActivity(intent);
            }
        });

    }
}
