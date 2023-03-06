package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sqlite.*

class SqliteActivity : AppCompatActivity() {
    lateinit var db:DBHelper
    var ListUser : ArrayList<usersql> = ArrayList<usersql>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)
        db= DBHelper(this)
        insert.setOnClickListener(){
           var res = db.InsertUser(editNama.text.toString(),editUmur.text.toString().toInt())
            if (!res){
                Log.d("Insert","Failed")
            }
            else{
                Log.d("Insert","Success")
                Toast.makeText(this, "BERHASILLLLLLLLLLLLLLLL",Toast.LENGTH_SHORT).show()
            }
        }
        update.setOnClickListener(){
           db.updateUser(1,editNama.text.toString(),editUmur.text.toString().toInt())
        }
        read.setOnClickListener(){
            var cursor = db.getUser()
            ListUser = ArrayList<usersql>()
            while (cursor.moveToNext()){
                ListUser.add(usersql(cursor.getInt(0),cursor.getString(1),cursor.getInt(2)));
            }
            textvvvvi.text=""
            for(user:usersql in ListUser){
                textvvvvi.text = textvvvvi.text.toString() + user.ID+ " "+user.Name+" "+user.Age+ "\n";
            }
        }

        delete.setOnClickListener(){
            db.deleteUser(editNama.text.toString().toInt())
        }
    }
}