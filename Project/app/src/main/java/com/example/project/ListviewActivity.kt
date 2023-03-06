package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_listview.*

class ListviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)
        var listUser = arrayListOf<User>()
        listUser.add(User("Kenthar",32))
        listUser.add(User("Kenthir",31))
        listUser.add(User("Kenthur",30))
        listUser.add(User("Kenther",29))
        listUser.add(User("Kenthor",28))


        lvuser.adapter = ListUserAdapter(this, listUser)
    }
}