package com.example.project

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.layout_viewuser.view.*

class ListUserAdapter : BaseAdapter {
    val ctx:Context
    val list:ArrayList<User>

    constructor(context: Context, listUser:ArrayList<User>) {
        list = listUser
        ctx = context

    }
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(ctx)
        val view = layoutInflater.inflate(R.layout.layout_viewuser, null)
        view.nama.text=list.get(p0).nama
        view.umur.text=list.get(p0).age.toString()
        view.button.setOnClickListener(){
            list.removeAt(p0)
            notifyDataSetChanged()
        }
        return view
    }
}