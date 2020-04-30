package com.example.laba_3

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laba_3.DBReader.StudentTable

class MyAdapter(context: Context): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    val dbHelper = DBHelper(context)
    val db = dbHelper.writableDatabase
    var size: Int
    var cursor: Cursor

    init {
        cursor = db.rawQuery("SELECT COUNT(*) FROM ${StudentTable.TABLE_NAME}", null)
        cursor.moveToFirst()

        size = cursor.getInt(0)

        cursor = db.rawQuery("SELECT * FROM ${StudentTable.TABLE_NAME}", null)
        cursor.moveToFirst()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textId: TextView = itemView.findViewById(R.id.idText)
        val textFio: TextView = itemView.findViewById(R.id.fioText)
        val textTime: TextView = itemView.findViewById(R.id.timeText)

        fun bind(cursor: Cursor){
            if(!cursor.isAfterLast){
                textId.text = cursor.getInt(0).toString()
                textFio.text = cursor.getString(1)
                textTime.text = cursor.getString(2)

                cursor.moveToNext()
            } else {
                cursor.close()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.recycler_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(cursor)
    }
}