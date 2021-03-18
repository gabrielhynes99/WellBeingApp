package com.example.wellbeingproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import static com.example.wellbeingproject.Wellbeing_emotions.emotion;

public class Wellbeing_finalreport extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellbeing_finalreport);

        ImageView backbutton = findViewById(R.id.back_button);

        //submit button
        Button submit = findViewById(R.id.submit_report_button);


        //to access the back button
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellbeing_finalreport.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
