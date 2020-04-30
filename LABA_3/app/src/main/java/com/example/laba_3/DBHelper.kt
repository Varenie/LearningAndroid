package com.example.laba_3

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.laba_3.DBReader.StudentTable

class DBHelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object{
        val DB_NAME = "Students.db"
        val DB_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE ${StudentTable.TABLE_NAME} (" +
                "${StudentTable.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${StudentTable.COLUMN_FIO} TEXT," +
                "${StudentTable.COLUMN_TIME} TEXT);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS ${StudentTable.TABLE_NAME}")
        onCreate(db)
    }
}