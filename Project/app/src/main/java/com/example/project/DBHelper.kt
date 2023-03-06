package com.example.project

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper : SQLiteOpenHelper {
    constructor(context: Context) : super(context, "user.db",null,1) {

    }
    override fun onCreate(db: SQLiteDatabase?) {
        if(db!=null){
            db.execSQL("CREATE TABLE user(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, AGE INTEGER)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        if (db!=null){
            db.execSQL("DROP TABLE IF EXISTS user")
        }
    }
    public  fun InsertUser(name:String,Age:Int) : Boolean{
        var db=this.writableDatabase
        var value=ContentValues()
        value.put("Name",name);
        value.put("AGE",Age);
        var res = db.insert("user",null,value);
        if (res == -1.toLong()){
            return false
        }
        return true
    }
    public fun getUser():Cursor{
        var db=this.writableDatabase
        var cursor = db.rawQuery("SELECT * FROM user",null)
        return  cursor
    }
    public fun updateUser(id:Int,name:String,Age: Int):Boolean{
        var db=this.writableDatabase
        var values =ContentValues()
        values.put("Name",name);
        values.put("AGE",Age);
        var res = db.update("user",values,"ID=?", Array<String>(1){id.toString()})
        if (res  == -1){
            return false
        }
        return true

    }

    public fun deleteUser(id: Int):Boolean{
        var db = this.writableDatabase
        var result = db.delete("user","ID=?",Array<String>(1){id.toString()})
        if (result == -1){
            return false
        }
        return true
    }
}