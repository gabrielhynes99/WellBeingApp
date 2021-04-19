package com.example.wellbeingproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Locale;

public class Support extends AppCompatActivity {
    private Toolbar toolbar;
    public TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support);


        ImageView backbutton = findViewById(R.id.back_button);

        //to access the back button
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.stop();
                finish();
            }
        });

        //References for support buttons
        CardView emergency = findViewById(R.id.emergency);
        CardView hse = findViewById(R.id.hse);
        CardView olympics = findViewById(R.id.olympics);
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
                                t1.speak("Emergency Services", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(1000, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("HSE", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(1000, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Special Olympics", TextToSpeech.QUEUE_ADD, null, null);
                                i++;
                            }
                        }
                    });
                }
            }
        });

        //Emergency button
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gov.ie/en/service/89da6-how-to-contact-emergency-services-in-ireland/#"));
                startActivity(intent);
            }
        });

        //HSE button
        hse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hse.ie/eng/services/list/4/disability/"));
                startActivity(intent);
            }
        });

        //Olympics button
        olympics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.specialolympics.ie/"));
                startActivity(intent);
            }
        });
    }
}
