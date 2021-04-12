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
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public TextToSpeech t1;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                            String data = "hello";
                            t1.speak(data, TextToSpeech.QUEUE_FLUSH, null, null);
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
                Intent intent = new Intent(MainActivity.this, Support.class);
                startActivity(intent);
            }
        });

        //access Wellbeing section
        wellbeing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                Intent intent = new Intent(MainActivity.this, Activities.class);
                startActivity(intent);
            }
        });

        //access Tracker section
        tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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