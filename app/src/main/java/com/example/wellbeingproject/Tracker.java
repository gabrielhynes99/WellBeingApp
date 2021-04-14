package com.example.wellbeingproject;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Tracker extends AppCompatActivity {
    private Toolbar toolbar;
    public TextToSpeech ttstracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracker);

        ImageView backbutton = findViewById(R.id.back_button);

        //to access the back button
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final ImageView tts_icon = findViewById(R.id.tts_icon);

        ttstracker = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    ttstracker.setLanguage(Locale.UK);

                    tts_icon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while(i == 0) {
                                ttstracker.speak("How many steps did you take today?", TextToSpeech.QUEUE_ADD, null, null);
                                ttstracker.playSilentUtterance(1000, TextToSpeech.QUEUE_ADD, null);
                                ttstracker.speak("How much water did you drink today?", TextToSpeech.QUEUE_ADD, null, null);
                                ttstracker.playSilentUtterance(1000, TextToSpeech.QUEUE_ADD, null);
                                ttstracker.speak("Track Sleep with Track Sleep Button ", TextToSpeech.QUEUE_ADD, null, null);
                                ttstracker.playSilentUtterance(1000, TextToSpeech.QUEUE_ADD, null);
                                i++;
                            }
                        }
                    });
                }
            }
        });

    }
}
