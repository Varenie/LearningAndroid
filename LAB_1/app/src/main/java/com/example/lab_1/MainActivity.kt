package com.example.lab_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecycler.setHasFixedSize(true)//массив неизменной длины
        myRecycler.layoutManager = LinearLayoutManager(this)

        myRecycler.adapter = MainAdapter(1_000_000)
    }


}
