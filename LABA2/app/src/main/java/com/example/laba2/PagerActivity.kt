package com.example.laba2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class PagerActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)

        val intent = intent
        val myAdapter = TechFragAdapter(supportFragmentManager, this, 100)
        val viewPager = findViewById<ViewPager>(R.id.viewpager)

        viewPager.setAdapter(myAdapter)
        viewPager.setCurrentItem(intent.getIntExtra("position", 0))

    }
}