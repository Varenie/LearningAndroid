package com.example.laba2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*
import retrofit2.http.POST

class MyAdapter(val postlist: List<Tech>, val context: Context): RecyclerView.Adapter<MyAdapter.MyVHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyVHolder {
        return MyVHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MyAdapter.MyVHolder, position: Int) {

        holder.itemView.name.text = postlist.get(position).name
        holder.itemView.helptext.text = postlist.get(position).helptext
    }

    class MyVHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}