package com.example.laba2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

class myRecyclerAdapter(size: Int): RecyclerView.Adapter<myRecyclerAdapter.myVHolder>() {
    val size = size
    private val singleton: Singleton = Singleton.getInstance()!!

    class myVHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val context = itemView.context
        init {
            super.itemView
            itemView.setOnClickListener(View.OnClickListener {

                val intent = Intent(context, PagerActivity::class.java)
                intent.putExtra("position", adapterPosition)
                context.startActivity(intent)
            })
        }

        fun bind(position: Int, singleton: Singleton){
            val url = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + singleton.image[position]
            val nameView: TextView = itemView.findViewById(R.id.name)
            val imageView: ImageView = itemView.findViewById(R.id.techImage)

            nameView.text = singleton.name[position]
            DownloadImage(imageView).execute(url)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myVHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.recycler_item, parent,false)

        return myVHolder(view)
    }

    override fun getItemCount(): Int {
        return size
    }

    override fun onBindViewHolder(holder: myVHolder, position: Int) {

        holder.bind(position + 1, singleton)
    }


}