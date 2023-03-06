package com.example.notesapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.notesapp.NoteActivity
import kotlinx.android.synthetic.main.layout_listnote.view.*

class NoteAdapter : BaseAdapter {
    val ctx: Context
    val listnotes: ArrayList<Note>
    constructor(context: Context, listnotes:ArrayList<Note>){
        ctx = context
        this.listnotes = listnotes
    }

    override fun getCount(): Int {
        return listnotes.size
    }

    override fun getItem(position: Int): Any {
      return listnotes.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var id = listnotes.get(position).id
        var title = listnotes.get(position).title
        var content = listnotes.get(position).content

        val layoutInflater = LayoutInflater.from(ctx)
        val view = layoutInflater.inflate(com.example.notesapp.R.layout.layout_listnote, null)
        view.txtTitle.text = if (title == "") "[No Title]" else title
        view.txtContent.text = if (content == "") "[No Content]" else content
        view.setOnClickListener(){
            val intent = Intent(ctx, NoteActivity::class.java).putExtra("Type","Edit").putExtra("Id", id)
                .putExtra("Title", title).putExtra("Content",content)
            ctx.startActivity(intent)
        }
        return view
    }
}