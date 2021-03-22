package com.example.wellbeingproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Support extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support);

        ImageView backbutton = findViewById(R.id.back_button);

        //to access the back button
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //References for support buttons
        CardView emergency = findViewById(R.id.emergency);
        CardView hse = findViewById(R.id.hse);
        CardView olympics = findViewById(R.id.olympics);

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
