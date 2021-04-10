package com.example.wellbeingproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private Toolbar toolbar;
    public static boolean logged_in = false;
    EditText ETusername, ETpassword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //assigning edit text id and button id
        ETusername = findViewById(R.id.username);
        ETpassword = findViewById(R.id.password);
        login = findViewById(R.id.login);

    }

    public void Login(View view) {
        String username = ETusername.getText().toString();
        String password = ETpassword.getText().toString();
        String type = "login";
        Databaseworker DBWorker = new Databaseworker(this);
        DBWorker.execute(type, username, password);
        if(logged_in == true)
        {
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
