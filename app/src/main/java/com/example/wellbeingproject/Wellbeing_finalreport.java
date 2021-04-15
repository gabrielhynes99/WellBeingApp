package com.example.wellbeingproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import static com.example.wellbeingproject.Wellbeing_emotions.emotion;

public class Wellbeing_finalreport extends AppCompatActivity {
    private Toolbar toolbar;
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
        DBWorker.execute(type, MainActivity.userID, Wellbeing.day_report, Wellbeing.feeling_report, Wellbeing.today_report, Wellbeing.aboutday_report, MainActivity.date);
    }
}
