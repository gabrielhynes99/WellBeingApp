package com.example.wellbeingproject;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Locale;

import static com.example.wellbeingproject.Wellbeing_emotions.emotion;

public class Wellbeing_moveto_report extends AppCompatActivity {
    private Toolbar toolbar;
    public TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellbeing_moveto_report);

        ImageView backbutton = findViewById(R.id.back_button);
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
                                t1.speak("Would you like to say more about your day?", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("Yes", TextToSpeech.QUEUE_ADD, null, null);
                                t1.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null);
                                t1.speak("No", TextToSpeech.QUEUE_ADD, null, null);
                                i++;
                            }
                        }
                    });
                }
            }
        });

        //yes no buttons
        Button yes_button = findViewById(R.id.wellbeing_yes);
        Button no_button = findViewById(R.id.wellbeing_no);

        //to access the back button
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_moveto_report.this, Wellbeing_finalreport.class);
                startActivity(intent);
            }
        });

        no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Onsubreport(v);
                Intent intent = new Intent(Wellbeing_moveto_report.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }

    public void Onsubreport(View view) {
        String type = "subreport";
        Databaseworker DBWorker = new Databaseworker(this);
        DBWorker.execute(type, MainActivity.username, Wellbeing.day_report, Wellbeing.feeling_report, Wellbeing.today_report, Wellbeing.aboutday_report, MainActivity.date);
    }
}
