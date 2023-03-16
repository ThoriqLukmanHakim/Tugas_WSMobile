package com.jti.minggu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    TextView tvJudul, tvDeskripsi;
    ImageView image;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this , ThirdActivity.class);
                Toast.makeText(DetailActivity.this,"Kembali Ke Home",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });
    }

    public void init(){
        btnBack = findViewById(R.id.back);
        tvJudul = findViewById(R.id.tvJudul);
        tvDeskripsi = findViewById(R.id.tvDeskripsi);
        image = findViewById(R.id.image);


        String judul = getIntent().getStringExtra("id");
        String deskripsi = getIntent().getStringExtra("content");
        String nopung = getIntent().getStringExtra("nopung");
        String image = getIntent().getStringExtra("image");
        String nat = getIntent().getStringExtra("Nat");

        tvJudul.setText(judul);
        tvDeskripsi.setText("Dia adalah "+judul +" Dan dia Bermain Sebagai "+deskripsi + " di klub Manchester United dengan Nomor Punggung " + nopung
        +" Dan dia Pemain Berkebangsaan " +nat);
        this.image.setImageResource(this.image.getContext().getResources().getIdentifier(image, "drawable", this.image.getContext().getPackageName()));
    }
}