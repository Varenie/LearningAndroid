package com.example.laba2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class PagerActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)

        val names_array = arrayOf(
            "Advanced Flight",
            "Alphabet",
            "Amphibious Warfare",
            "Astronomy",
            "Atomic Theory",
            "Automobile",
            "Banking",
            "Bridge Building",
            "Bronze Working",
            "Ceremonial Burial",
            "Chemistry",
            "Chivalry",
            "Code of Laws",
            "Combined Arms",
            "Combustion",
            "Communism",
            "Computers",
            "Conscription",
            "Construction",
            "Currency",
            "Democracy",
            "Economics",
            "Electricity",
            "Electronics"
        )

        val help_array = arrayOf(
            "null",
            "null",
            "null",
            "null",
            "null",
            "Increases the population contribution to pollution.",
            "null",
            "Allows roads to be built on river tiles.",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "Reduces the effect of Cathedrals.",
            "null",
            "null",
            "Allows Settlers, Workers and Engineers to build fortresses.",
            "null",
            "null",
            "null",
            "Improves the effect of Colosseums",
            "null"
        )

        val intent = intent
        val myAdapter = TechFragAdapter(supportFragmentManager, this, names_array, help_array)
        val viewPager = findViewById<ViewPager>(R.id.viewpager)

        viewPager.setAdapter(myAdapter)
        viewPager.setCurrentItem(intent.getIntExtra("position", 0))

    }
}