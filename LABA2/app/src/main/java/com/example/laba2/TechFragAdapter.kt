package com.example.laba2

import android.content.Context
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class TechFragAdapter(fm: FragmentManager, context: Context, size: Int)
    : FragmentPagerAdapter(fm){
    val TECH_NAMES = "tech_names"
    val TECH_HELPTEXT = "tech_helptext"
    val size = size
    private val singleton = Singleton().getInstance()



    override fun getItem(position: Int): Fragment {
        val arguments = Bundle()

        arguments.putString(TECH_NAMES, singleton.name[position])
        arguments.putString(TECH_HELPTEXT,singleton.helptext[position])

        val techFrag = TechFragment()
        techFrag.setArguments(arguments)

        return  techFrag
    }

    override fun getCount(): Int {
        return size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return singleton.name[position]
    }
}