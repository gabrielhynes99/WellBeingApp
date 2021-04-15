package com.example.wellbeingproject;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Tracker extends AppCompatActivity {
    private Toolbar toolbar;
    public TextToSpeech ttstracker;

    TextView sleep,wake;
    int shour,whour,sminute,wminute;


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
                            while (i == 0) {
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




        //assign variables
        sleep = findViewById(R.id.sleep);
        wake = findViewById(R.id.wake);

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        Tracker.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                shour = hourOfDay;
                                sminute = minute;
                                String time = shour + ":" + sminute;
                                SimpleDateFormat f24Hours = new SimpleDateFormat(
                                    "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);
                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    sleep.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        },12,0,false
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(shour,sminute);
                timePickerDialog.show();
            }
        });

        wake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        Tracker.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                whour = hourOfDay;
                                wminute = minute;
                                String time = whour + ":" + wminute;
                                SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);
                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    wake.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        },12,0,false
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(whour,wminute);
                timePickerDialog.show();
            }
        });
    }
}
