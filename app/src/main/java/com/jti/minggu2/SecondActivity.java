package com.jti.minggu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_avtivity);
        pref = getSharedPreferences("data",MODE_PRIVATE);
        String usernamedata = pref.getString("Username",null);
        Intent intent = getIntent();
        String data = intent.getStringExtra("username");
        TextView txt = findViewById(R.id.txtSecondActivity );
        txt.setText("Helllooooooo ini dr sharedpref "+ usernamedata);
        Button btnlog,btn2,btn3;
                btnlog = findViewById(R.id.btnGoToFirstActivity);
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                Toast.makeText(SecondActivity.this,"Logout nieh", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });
        btn2 = findViewById(R.id.btn2);
       btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this,"Halohalohalo", Toast.LENGTH_SHORT).show();
            }
        });

       btn3 = findViewById(R.id.btn3);
       btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                Toast.makeText(SecondActivity.this,"Ke 3 yaaa", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });

    }
}