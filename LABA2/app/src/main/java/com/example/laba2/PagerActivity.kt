package com.example.laba2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class PagerActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)
//
//        val names_array = arrayOf("Advanced Flight", "Alphabet", "Amphibious Warfare", "Astronomy",
//            "Atomic Theory", "Automobile", "Banking", "Bridge Building", "Bronze Working", "Ceremonial Burial",
//            "Chemistry", "Chivalry", "Code of Laws", "Combined Arms", "Combustion", "Communism", "Computers",
//            "Conscription", "Construction", "Currency", "Democracy", "Economics", "Electricity", "Electronics")
//
//        val help_array = arrayOf("", "", "", "", "", "Increases the population contribution to pollution.",
//            "", "Allows roads to be built on river tiles.", "", "", "", "", "", "", "",
//            "Reduces the effect of Cathedrals.", "", "", "Allows Settlers, Workers and Engineers to build fortresses.",
//            "", "", "", "Improves the effect of Colosseums", "")

        val intent = intent
        val myAdapter = TechFragAdapter(supportFragmentManager, this, 100)
        val viewPager = findViewById<ViewPager>(R.id.viewpager)

        viewPager.setAdapter(myAdapter)
        viewPager.setCurrentItem(intent.getIntExtra("position", 0))

    }
}