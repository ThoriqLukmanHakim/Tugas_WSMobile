package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.notesapp.adapters.Note
import com.example.notesapp.adapters.NoteAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var listnotes:ArrayList<Note> = arrayListOf<Note>()
    override fun onRestart() {
        super.onRestart()
        listnotes = loadnotedata()
        lvnotes.adapter = NoteAdapter(this,listnotes)
        var size = listnotes.size
        txtNoteCount.text = if(size < 2) "$size Note" else "$size Notes"

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listnotes = loadnotedata()
        lvnotes.adapter = NoteAdapter(this,listnotes)
        var size = listnotes.size
        txtNoteCount.text = if(size < 2) "$size Note" else "$size Notes"
        ButtonAdd.setOnClickListener(){
            var intent= Intent(this,NoteActivity::class.java).putExtra("Type","Add")
            startActivity(intent)
        }
        editSearch.doOnTextChanged{text, start, before , count ->
            lvnotes.adapter = NoteAdapter(this,listnotes.filter { note: Note ->note.title.toLowerCase().contains(text.toString().toLowerCase())==true ||
            note.content.toLowerCase().contains(text.toString().toLowerCase() )== true}as ArrayList<Note>)
        }
    }

    fun loadnotedata(): ArrayList<Note>{
        var list = ArrayList<Note>()
        var db = DBHelper(this)
        var cursor = db.getnotes()
        while (cursor!!.moveToNext()){
            list.add(Note(cursor.getInt(0),cursor.getString(1),cursor.getString(2)))
        }
        return list
    }
}