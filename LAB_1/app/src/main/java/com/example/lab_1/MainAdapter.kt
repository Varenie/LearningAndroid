package com.example.lab_1

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.text.StringBuilder

class MainAdapter (size: Int): RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var size: Int

    init {
        this.size = size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val context: Context = parent.context

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.recycler_item, parent, false)

        return MainHolder(view)
    }

    override fun getItemCount(): Int {
        return size
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.bind(position + 1)
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val number: TextView = itemView.findViewById(R.id.numberView)

        fun bind(n: Int) {// распределение цветов по четным и нечетным номерам
            var num = n

            if (num % 2 != 0) {
                number.setBackgroundColor(Color.GRAY)
                number.text = num.toString()
            } else {
                number.text = num.toString()
                number.setBackgroundColor(Color.WHITE)
            }

        }
    }
}