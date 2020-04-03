package com.example.laba2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val names_array = arrayOf("Advanced Flight", "Alphabet", "Amphibious Warfare", "Astronomy",
//        "Atomic Theory", "Automobile", "Banking", "Bridge Building", "Bronze Working", "Ceremonial Burial",
//        "Chemistry", "Chivalry", "Code of Laws", "Combined Arms", "Combustion", "Communism", "Computers",
//        "Conscription", "Construction", "Currency", "Democracy", "Economics", "Electricity", "Electronics")

        myRecycler.setHasFixedSize(true)
        myRecycler.layoutManager = LinearLayoutManager(this)

        myRecycler.adapter = myRecyclerAdapter(100)
    }
}
