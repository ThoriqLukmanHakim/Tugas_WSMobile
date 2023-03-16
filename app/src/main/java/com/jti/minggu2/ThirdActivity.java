package com.jti.minggu2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    SharedPreferences pref;
    Button btnfragment1, btnfragment2,btnk1back,btn2logout,btn3detail,btn4lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        btnk1back = findViewById(R.id.btnback);
        btnk1back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            onBackPressed();
            }
        });
        btn2logout = findViewById(R.id.btnlogout);
        btn2logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this , MainActivity.class);
                pref = getSharedPreferences("data",MODE_PRIVATE);
                pref.edit().remove("Username").commit();
                Toast.makeText(ThirdActivity.this,"Logout",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });
        btn3detail = findViewById(R.id.btndetail);
        btn3detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this , SecondActivity.class);
                Toast.makeText(ThirdActivity.this,"Ke Detail",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });
        btnfragment1 = findViewById(R.id.firstFragment);
        btnfragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loadFragment(new FirstFragment());
            }
        });
        btnfragment2 = findViewById(R.id.secondFragment);
        btnfragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SecondFragment());
            }
        });
        btn4lv=findViewById(R.id.btnlv);
        btn4lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new ItemFragment());
            }
        });

    }
    private void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

    }
}