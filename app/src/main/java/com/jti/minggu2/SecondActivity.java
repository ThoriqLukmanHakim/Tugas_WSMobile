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
        String usernameAlamat= pref.getString("Alamat",null);
        TextView txt = findViewById(R.id.txtnama );
        txt.setText("Nama: "+ usernamedata);
        TextView txt2 = findViewById(R.id.txtalamat);
        txt2.setText("Alamat : "+ usernameAlamat);
        Button btnback;
        btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                Toast.makeText(SecondActivity.this,"Back To Dashboard", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });

    }
}