package com.example.laba2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class TechFragment: Fragment() {
    val TECH_NAMES = "tech_names"
    val TECH_HELPTEXT = "tech_helptext"
    val TECH_IMAGES = "tech_images"

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
            val techName = arguments.getString(TECH_NAMES).toString()
            val techHelp = arguments.getString(TECH_HELPTEXT).toString()
            val techIm = arguments.getString(TECH_IMAGES).toString()

            displayValues(view, techName, techHelp, techIm)
        }
        return view
    }

    private fun displayValues(v: View, name: String, help: String, image: String){
        val url = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + image

        val nameView = v.findViewById<TextView>(R.id.nameP)
        val helpView = v.findViewById<TextView>(R.id.helptextP)
        val imageView = v.findViewById<ImageView>(R.id.picture)

        nameView.text = name
        helpView.text = help

        DownloadImage(imageView).execute(url)
    }
}