package com.example.project

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinneritem()
        val checked = arrayListOf<String>()


        radiogender.setOnCheckedChangeListener { group, checkid ->
            if (checkid == R.id.radiomale){
                Toast.makeText( this,"Kamu memilih Male ", Toast.LENGTH_SHORT).show()
            }
            else if(checkid==R.id.radiofemale) {
                Toast.makeText( this,"Kamu memilih Female ", Toast.LENGTH_SHORT).show()
            }
        }
        cekbox1.setOnCheckedChangeListener { buttonview, ischeked ->
            if (ischeked) checked.add("Satu")
            else checked.remove("Satu")
        }
        cekbox2.setOnCheckedChangeListener { buttonview, ischeked ->
            if (ischeked) checked.add("Dua")
            else checked.remove("Dua")
        }
        cekbox3.setOnCheckedChangeListener { buttonview, ischeked ->
            if (ischeked) checked.add("Tiga")
            else checked.remove("Tiga")
        }
        
        btn.setOnClickListener(){
            Log.d("Testing","Berhasil di CLick")
            var gender:String = if (radiomale.isChecked()) "titit" else if (radiofemale.isChecked())"sel telur" else "keGoblougan"
            Toast.makeText( this,"Halooo " + txtnama.text +" Kamu punya "+gender +" "+ Spinner.selectedItem.toString() + checked.toString(), Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Switch nya ke - "+sw.isChecked.toString(), Toast.LENGTH_SHORT).show()
            
        }
        btn_login.setOnClickListener(){
            var intent= Intent(this,HomeActivity::class.java).putExtra("username",txtnama.text.toString())
            startActivity(intent)
            Toast.makeText(this, "Selamat Datang "+txtnama.text, Toast.LENGTH_SHORT).show()
            finish()
        }


    }
    override fun onBackPressed() {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Keluar")
            .setMessage("Apakah anda yakin ingin keluar dari Aplikasi ??")
            .setPositiveButton("Ya", DialogInterface.OnClickListener { dialog, i ->finish()  })
            .setNegativeButton("Tidak", DialogInterface.OnClickListener { dialog, i ->null  }).create().show()
    }
    fun spinneritem(){
        val spinnerItems = arrayOf("Anjay","Babi","Blog")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerItems)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        Spinner.adapter = adapter
    }

}