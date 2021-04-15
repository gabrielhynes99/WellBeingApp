package com.example.wellbeingproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;
import android.view.View.OnKeyListener;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    public static boolean logged_in;
    EditText ETusername, ETpassword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        logged_in = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //assigning edit text id and button id
        ETusername = findViewById(R.id.username);
        ETpassword = findViewById(R.id.password);
        login = findViewById(R.id.login);

    }

    public void OnLogin(View view) {

        String username = ETusername.getText().toString();
        String password = ETpassword.getText().toString();
        String type = "login";
        Databaseworker DBWorker = new Databaseworker(this);
        DBWorker.execute(type, username, password);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Loggedin();
            }
        },500);
    }

    //forward to home page
    public synchronized void Loggedin() {

        if(logged_in) {
            finish();
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }
    }
}