package com.example.wellbeingproject;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Locale;

public class Wellbeing extends AppCompatActivity {
    private Toolbar toolbar;
    public static String day_report;
    public static String feeling_report;
    public static String today_report;
    public static String aboutday_report;
    public TextToSpeech t1;

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
                                t1.speak("How was your day?", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Really good", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Good", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Okay", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Bad", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Really bad", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(300, TextToSpeech.QUEUE_ADD, null);
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

        //reallyGood is pressed
        reallyGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day_report = "really good";
                t1.stop();
                Intent intent = new Intent(Wellbeing.this, Wellbeing_emotions.class);
                startActivity(intent);
            }
        });

        //good is pressed
        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day_report = "good";
                t1.stop();
                Intent intent = new Intent(Wellbeing.this, Wellbeing_emotions.class);
                startActivity(intent);
            }
        });

        //okay is pressed
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day_report = "okay";
                t1.stop();
                Intent intent = new Intent(Wellbeing.this, Wellbeing_emotions.class);
                startActivity(intent);
            }
        });

        //bad is pressed
        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day_report = "bad";
                t1.stop();
                Intent intent = new Intent(Wellbeing.this, Wellbeing_emotions.class);
                startActivity(intent);
            }
        });

        //really bad is pressed
        reallyBad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day_report = "really bad";
                t1.stop();
                Intent intent = new Intent(Wellbeing.this, Wellbeing_emotions.class);
                startActivity(intent);
            }
        });

    }
}
