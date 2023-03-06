package com.example.notesapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class DBHelper :SQLiteOpenHelper {
    constructor(context: Context) : super(context, "Note.db", null, 1){

    }

    override fun onCreate(db: SQLiteDatabase?) {
      if (db != null) {
          db.execSQL("CREATE TABLE Notes(ID INTEGER PRIMARY KEY AUTOINCREMENT, Title TEXT, Content TEXT)")
      }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db != null){
            db.execSQL("DROP TABLE IF EXISTS Notes")
        }
    }
    public fun insertNoteData(title: String, content:String):Boolean {
        var db = this.writableDatabase
        var values = ContentValues()
        values.put("Title",title)
        values.put("Content",content)
        var result = db.insert("Notes",null,values)
        if (result == -1.toLong()){
            return false
        }
        return true
    }
    public fun updateNoteData(id:Int ,title: String, content:String):Boolean {
        var db = this.writableDatabase
        var values = ContentValues()
        values.put("Title",title)
        values.put("Content",content)
        var result = db.update("Notes",values,"ID=?", Array<String>(size = 1){id.toString()})
        if (result == -1){
            return false
        }
        return true
    }

    public fun deletenote(id:Int):Boolean{
        var db= this.writableDatabase
        var result = db.delete("Notes","ID=?",Array<String>(size = 1){id.toString()})
        if (result == -1){
            return false
        }
        return true
    }

    public fun  getnotes(): Cursor? {
        var db = this.writableDatabase
        var cursor = db.rawQuery("SELECT * FROM Notes", null)
        return cursor
    }
}