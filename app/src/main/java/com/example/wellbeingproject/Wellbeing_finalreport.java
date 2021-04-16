package com.example.wellbeingproject;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Locale;

import static com.example.wellbeingproject.Wellbeing_emotions.emotion;

public class Wellbeing_finalreport extends AppCompatActivity {
    private Toolbar toolbar;
    public TextToSpeech t1;
    String finalreport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellbeing_finalreport);

        ImageView backbutton = findViewById(R.id.back_button);

        //submit button
        Button submit = findViewById(R.id.submit_report_button);

        //edittext
        final EditText freport = findViewById(R.id.finalreportText);

        //tts button
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
                                t1.speak("Say more about your day below", TextToSpeech.QUEUE_ADD, null, null);
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
                t1.stop();
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.stop();
                finalreport = freport.getText().toString();
                Wellbeing.aboutday_report = finalreport;
                Onsubreport(v);
                Intent intent = new Intent(Wellbeing_finalreport.this, MainActivity.class);
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
