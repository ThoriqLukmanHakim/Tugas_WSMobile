package com.jti.minggu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button btn22,btnk11;
        btnk11 = findViewById(R.id.btnke1);
        btnk11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this , MainActivity.class);
                Toast.makeText(ThirdActivity.this,"btn balik ke 1",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });
        btn22 = findViewById(R.id.btnke2);
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this , SecondActivity.class);
                Toast.makeText(ThirdActivity.this,"btn balik ke 2",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });
    }
}