package com.example.project

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val username = intent.getStringExtra("username")
        txtxt.text = username
        btn_logout.setOnClickListener() {
            var intent = Intent(this, MainActivity::class.java)

            val alert = AlertDialog.Builder(this)
            alert.setTitle("Logout!?!?!?!?!?")
                .setMessage("Yakin Logout nieh!@?!@?!@?!?")
                .setPositiveButton(
                    "iyhh mff yh",
                    DialogInterface.OnClickListener { dialogInterface, i ->
                        startActivity(intent);
                        Toast.makeText(this, "Berhasil Logout ", Toast.LENGTH_SHORT).show()
                    })
                .setNegativeButton(
                    "mmmm gjd dech",
                    DialogInterface.OnClickListener { dialogInterface, i -> null }).create().show()
        }
        Listttt.setOnClickListener(){
            var intent= Intent(this,ListviewActivity::class.java)
            startActivity(intent)
            finish()
        }
        sqlite.setOnClickListener(){
            var intent= Intent(this,SqliteActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}