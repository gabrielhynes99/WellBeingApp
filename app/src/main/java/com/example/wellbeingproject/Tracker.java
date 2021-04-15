package com.example.wellbeingproject;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    EditText stepsET, waterET;
    Button submit_tracker_report_button;

    TextView sleep,wake;
    int shour,whour,sminute,wminute;
    String steps, water, sleepingT;

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
                                ttstracker.speak("How many glasses of water did you drink today?", TextToSpeech.QUEUE_ADD, null, null);
                                ttstracker.playSilentUtterance(1000, TextToSpeech.QUEUE_ADD, null);
                                ttstracker.speak("Enter the time you went to sleep and the time you woke up", TextToSpeech.QUEUE_ADD, null, null);
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

        stepsET = findViewById(R.id.steps);
        waterET = findViewById(R.id.water);

        submit_tracker_report_button = findViewById(R.id.submit_tracker_report_button);

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
                                    sleep.setText(f24Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        },24,0,true
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
                                    wake.setText(f24Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        },24,0,true
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(whour,wminute);
                timePickerDialog.show();
            }
        });

        submit_tracker_report_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Onsubtrackreport(v);
                finish();
            }
        });
    }

    public void Onsubtrackreport(View view) {
        sleepingT = calculateTime();
        steps = stepsET.getText().toString();
        water = waterET.getText().toString();
        String type = "tracker";
        Databaseworker DBWorker = new Databaseworker(this);
        DBWorker.execute(type, MainActivity.username, sleepingT, water, steps, MainActivity.date);
    }

    public String calculateTime() {
        String totaltime;
        int thour = 0;
        int tmin = 0;
        String totalmin = "";
        String totalhour = "";

        tmin = (wminute - sminute) % 60;
        thour = (whour - shour + 24) % 24;

        if(tmin == 0 | tmin == 1 | tmin == 2 | tmin == 3 | tmin == 4 | tmin == 5
                | tmin == 6 | tmin == 7 | tmin == 8 | tmin == 9) {
            totalmin = "0"+tmin;
        }
        if(thour == 0 | thour == 1 | thour == 2 | thour == 3 | thour == 4 | thour == 5
                | thour == 6 | thour == 7 | thour == 8 | thour == 9) {
            totalhour = "0"+thour;
        }
        totaltime = totalhour + ":" + totalmin;
        return totaltime;

    }
}