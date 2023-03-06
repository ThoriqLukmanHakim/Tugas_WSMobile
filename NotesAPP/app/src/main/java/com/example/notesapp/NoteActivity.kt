package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_note.*
import kotlinx.android.synthetic.main.layout_listnote.*

class NoteActivity : AppCompatActivity() {
    lateinit var db:DBHelper
    lateinit var type : String
    var id = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        type = intent.getStringExtra("Type").toString()
        db = DBHelper(this)

        if (type == "Add"){
            txtdelete.isVisible = false
        }
        else if (type == "Edit") {
            id = intent.getIntExtra("id", -1)
            if (id == 1){
                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Error")
                    .setMessage("Item Not Found")
                    .setPositiveButton("OK", null)
                finish()
            }
            txtTitle.setText(intent.getStringExtra("Title"))
            txtContent.setText(intent.getStringExtra("Content"))
        }
        txtback.setOnClickListener(){
            onBackAction()
        }
        txtdelete.setOnClickListener(){
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("DELETE !?!?!??!?!?!")
                .setMessage("Beneran mau delete nieh ?")
                .setPositiveButton("IYH", { dialog, which ->
                    db.deletenote(id)
                    finish()
                }).setNegativeButton("G Dech",null).create().show()
        }
    }
    fun onBackAction (){
        var title = txtTitle.text.toString()
        var content =txtContent.text.toString()
        if (type == "Add"){
            if (!(title == "" && content == ""))
            {
                db.insertNoteData(title,content)
            }
            finish()
        }
        else if (type == "Edit"){
            if (title == "" && content == ""){
                //delete
                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("DELETE !?!?!??!?!?!")
                    .setMessage("Beneran mau delete nieh ?")
                    .setPositiveButton("IYH", { dialog, which ->
                        db.deletenote(id)
                        finish()
                    }).setNegativeButton("G Dech",null).create().show()
            }
        else {
            if (intent.getStringExtra("Title") == txtTitle.text.toString() && intent.getStringExtra("Content")
            == txtContent.text.toString())
            {
                finish()
            }
                else {
                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("EDIT !?!?!??!?!?!")
                    .setMessage("Beneran mau EDIT nieh ?")
                    .setPositiveButton("IYH", { dialog, which ->
                        db.updateNoteData(id,title,content)
                        finish()
                    }).setNegativeButton("G Dech",null).create().show()

            }
        }
    }}}
