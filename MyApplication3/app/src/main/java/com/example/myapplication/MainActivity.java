package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tulisnama, tulisbelakang, tulisemail;
    EditText txt_nama, txt_belakang,txt_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onbtnclick (View view) {
         tulisnama = findViewById(R.id.Nama_Depan);
         tulisbelakang = findViewById(R.id.Nama_Belakang);
         tulisemail = findViewById(R.id.Email);
         txt_nama = findViewById(R.id.txt_namadepan);
         txt_belakang = findViewById(R.id.txt_namabelakang);
         txt_email = findViewById(R.id.txt_email);

        tulisnama.setText("Nama Depan : "+txt_nama.getText().toString());
        tulisbelakang.setText("Nama Belakang : "+txt_belakang.getText().toString());
        tulisemail.setText("Email : "+txt_email.getText().toString());
    }
}