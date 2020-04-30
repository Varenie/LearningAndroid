package com.example.laba_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        myRecycler.setHasFixedSize(true)
        myRecycler.layoutManager = LinearLayoutManager(this)

        myRecycler.adapter = MyAdapter(this)
    }
}