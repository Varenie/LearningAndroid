package com.example.laba2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TechFragment: Fragment() {
    val TECH_NAMES = "tech_names"
    val TECH_HELPTEXT = "tech_helptext"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.pager_fragment, container,false)

        val arguments = arguments
        if(arguments != null){
            val techName = arguments.getString(TECH_NAMES)
            val techHelp = arguments.getString(TECH_HELPTEXT)

            displayValues(view, techName.toString(), techHelp.toString())
        }
        return view
    }

    private fun displayValues(v: View, name: String, help: String){
        val nameView = v.findViewById<TextView>(R.id.nameP)
        val helpView = v.findViewById<TextView>(R.id.helptextP)

        nameView.text = name
        helpView.text = help
    }
}