package com.example.laba2

import android.content.Context
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class TechFragAdapter(fm: FragmentManager, context: Context, names: Array<String>, helptext: Array<String>)
    : FragmentPagerAdapter(fm){
    val TECH_NAMES = "tech_names"
    val TECH_HELPTEXT = "tech_helptext"
    private val mTechNames: Array<String> = names
    private val mTechHelp: Array<String> = helptext



    override fun getItem(position: Int): Fragment {
        val arguments = Bundle()

        arguments.putString(TECH_NAMES, mTechNames[position])
        arguments.putString(TECH_HELPTEXT,mTechHelp[position])

        val techFrag = TechFragment()
        techFrag.setArguments(arguments)

        return  techFrag
    }

    override fun getCount(): Int {
        return mTechNames.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTechNames[position]
    }
}