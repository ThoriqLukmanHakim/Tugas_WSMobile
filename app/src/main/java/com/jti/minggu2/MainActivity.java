package com.jti.minggu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText editusername, editpassword;
    Button login, signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences pref;
        pref = getSharedPreferences("data", Context.MODE_PRIVATE);
        String j = pref.getString("Username",null );

        //Default is 0 so autologin is disabled
        if(j != null){
            Intent activity = new Intent(getApplicationContext(), ThirdActivity.class);
            startActivity(activity);
        }


        editusername = findViewById(R.id.username);
        editpassword = findViewById(R.id.password);
        login = findViewById(R.id.login);
        pref = getSharedPreferences("data", MODE_PRIVATE);
        signUp = findViewById(R.id.signUp);
        SharedPreferences finalPref = pref;
        SharedPreferences finalPref1 = pref;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editusername.getText().toString();
                String password = editpassword.getText().toString();
                if (username.equals("Thoriq") && password.equals("admin")){
                    Toast.makeText(MainActivity.this,"Login Berhasil", Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                     SharedPreferences.Editor editor = finalPref1.edit();
                     SharedPreferences.Editor editor2 = finalPref1.edit();
                     editor.putString("Username", username);
                     editor2.putString("Alamat", "Perumahan Mastrip Blok EE - 7");
                     editor.commit();
                     editor2.commit();
                     startActivity(intent);
                     finish();
                }
                else {
                    Toast.makeText(MainActivity.this,"Salah password e bro yopo se", Toast.LENGTH_SHORT).show();
                }
            }
        });

    signUp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Toast.makeText(
                MainActivity.this,"signup",Toast.LENGTH_SHORT).show();
        }
    });

    }
}