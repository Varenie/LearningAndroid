package com.example.lab_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var array = Array(1_000_000,{i -> (i).toString()})

        val adapter = ArrayAdapter(this, R.layout.listview_item, array)

        val listView:ListView = findViewById(R.id.listView)
        listView.setAdapter(adapter)

    }


}
