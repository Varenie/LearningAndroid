package com.example.lab_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter (var items: List<MainItem>, val callback: Callback):
    RecyclerView.Adapter<MainAdapter.MainHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MainHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val number = itemView.findViewById<TextView>(R.id.number)

        fun bind(item: MainItem){
            number.text = item.number

            itemView.setOnClickListener{
                if (adapterPosition != RecyclerView.NO_POSITION)
                    callback.onItemClicked(items[adapterPosition])
            }
        }
    }

    interface Callback {
        fun onItemClicked(item: MainItem)
    }
}

data class MainItem(
    val number: String
//    val image: Image
)