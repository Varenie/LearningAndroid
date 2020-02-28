package com.example.lab_1

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

//abstract class CustomListAdapter(context: Context,list : List<String> ): BaseAdapter() {
//    var mContext: Context
//    var mList: List<String>
//
//    init {
//        mContext = context
//        mList = list
//    }
//
//    override fun getCount(): Int {
//        return mList.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return mList.get(position)
//    }
//
//    override fun getItemId(position: Int): Long {
//        return 0
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val view: View = View.inflate(mContext, R.layout.listview_item, null)
//
//        val noteTitle: TextView = TextView(view).findViewById(R.id.note_title)
//        noteTitle.setText(mList.get(position))
//        return view
//    }
//}