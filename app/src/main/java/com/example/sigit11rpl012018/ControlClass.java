package com.example.sigit11rpl012018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class ControlClass extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);

        if (sharedPreferences.getString("email", "").isEmpty() ||
                sharedPreferences.getString("email", "").equalsIgnoreCase("")){
            //login dulu
            startActivity(new Intent(getApplicationContext(), Login.class));
            finish();
        }else{
            startActivity(new Intent(getApplicationContext(), MainMenu.class));
            finish();
        }
    }
}