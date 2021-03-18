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
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Activities extends FragmentActivity implements OnMapReadyCallback {

    //Map variables
    GoogleMap mapAPI;
    SupportMapFragment mapFragment;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities);

        //Show map in fragment
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapAPI);
        mapFragment.getMapAsync(this);

        ImageView backbutton = findViewById(R.id.back_button);

        //to access the back button
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //References for activities buttons
        CardView physical = findViewById(R.id.physical_activities);
        CardView gardening = findViewById(R.id.gardening_activities);
        CardView arts = findViewById(R.id.arts_activities);
        CardView cooking = findViewById(R.id.cooking_activities);

        //Physical activities button
        physical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vimeo.com/showcase/7534147"));
                startActivity(intent);
            }
        });

        //Gardening activities button
        gardening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vimeo.com/showcase/7230699"));
                startActivity(intent);
            }
        });

        //Arts & crafts activities button
        arts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vimeo.com/showcase/7230737"));
                startActivity(intent);
            }
        });

        //Cooking activities button
        cooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vimeo.com/showcase/7230708"));
                startActivity(intent);
            }
        });

    }

    //Map settings
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapAPI = googleMap;
        LatLng sjog = new LatLng(53.28427788032826, -6.190988054941779);
        mapAPI.addMarker(new MarkerOptions().position(sjog).title("sjog"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLngZoom(sjog, 15));
    }
}
