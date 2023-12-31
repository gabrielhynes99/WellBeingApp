package com.example.wellbeingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.speech.tts.TextToSpeech;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public TextToSpeech t1;
    private Toolbar toolbar;
    public static String date;
    public static String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        //home and mentor references
        ImageView backbutton = findViewById(R.id.back_button);
        ImageView mentorButton = findViewById(R.id.mentor);

        //References to the other home buttons
        CardView calendar = findViewById(R.id.calendar_home);
        CardView support = findViewById(R.id.support_home);
        CardView wellbeing = findViewById(R.id.wellbeing_home);
        CardView activities = findViewById(R.id.activities_home);
        CardView tracker = findViewById(R.id.tracker_home);
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
                                t1.speak("Calender", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(1000, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Support", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(1000, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Wellbeing", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(1000, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Activities", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(1000, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Tracker", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(1000, TextToSpeech.QUEUE_ADD, null);
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
                Toast.makeText(MainActivity.this, "Back button", Toast.LENGTH_SHORT).show();
            }
        });

        //access mentor section
        mentorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.stop();
                if(Login.logged_in == false)
                {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this, Mentor.class);
                    startActivity(intent);
                }
            }
        });

        //access calendar section
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.stop();
                if(Login.logged_in == false)
                {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this, Calendar.class);
                    startActivity(intent);
                }
            }
        });

        //access support section
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.stop();
                Intent intent = new Intent(MainActivity.this, Support.class);
                startActivity(intent);
            }
        });

        //access Wellbeing section
        wellbeing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.stop();
                if(Login.logged_in == false)
                {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this, Wellbeing.class);
                    startActivity(intent);
                }
            }
        });

        //access Activities section
        activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.stop();
                Intent intent = new Intent(MainActivity.this, Activities.class);
                startActivity(intent);
            }
        });

        //access Tracker section
        tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.stop();
                if(Login.logged_in == false)
                {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this, Tracker.class);
                    startActivity(intent);
                }
            }
        });
    }
}