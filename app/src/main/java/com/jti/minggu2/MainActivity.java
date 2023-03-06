package com.jti.minggu2;

import androidx.appcompat.app.AppCompatActivity;

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

        editusername = findViewById(R.id.username);
        editpassword = findViewById(R.id.password);
        login = findViewById(R.id.login);
        pref = getSharedPreferences("data", MODE_PRIVATE);
        signUp = findViewById(R.id.signUp);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editusername.getText().toString();
                String password = editpassword.getText().toString();
                if (username.equals("admin") && password.equals("admin")){
                    Toast.makeText(MainActivity.this,"Login Berhasil", Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                     intent.putExtra("username", username);
                     SharedPreferences.Editor editor = pref.edit();
                     editor.putString("Username", username);
                     editor.commit();
                     startActivity(intent);
                     finish();
                }else{
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