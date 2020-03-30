package com.example.laba2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class myRecyclerAdapter(names: Array<String>, context: Activity): RecyclerView.Adapter<myRecyclerAdapter.myVHolder>() {

    val context = context
    var size  =  names.size
    val techNames = names

    class myVHolder(itemView: View, context: Activity): RecyclerView.ViewHolder(itemView){

        init {
            super.itemView
            itemView.setOnClickListener(View.OnClickListener {
                val intent = Intent(context, PagerActivity::class.java)
                intent.putExtra("position", adapterPosition)
                context.startActivity(intent)
            })
        }

        fun bind(position: Int, mTech: Array<String>){
            val nameView: TextView = itemView.findViewById(R.id.name)
            nameView.text = mTech[position]
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myVHolder {
        
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.recycler_item, parent,false)

        return myVHolder(view, context)
    }

    override fun getItemCount(): Int {
        return size
    }

    override fun onBindViewHolder(holder: myVHolder, position: Int) {

        holder.bind(position, techNames)
    }


}