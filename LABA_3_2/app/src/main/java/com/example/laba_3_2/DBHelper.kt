package com.example.laba_3_2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.laba_3_2.DBReader.StudentTable

class DBHelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object{
        val DB_NAME = "Students.db"
        val DB_VERSION = 2
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE ${StudentTable.TABLE_NAME} (" +
                "${StudentTable.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${StudentTable.COLUMN_LAST_NAME} TEXT," +
                "${StudentTable.COLUMN_FIRST_NAME} TEXT," +
                "${StudentTable.COLUMN_MIDDLE_NAME} TEXT," +
                "${StudentTable.COLUMN_TIME} TEXT);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("ALTER TABLE ${StudentTable.TABLE_NAME} RENAME TO Students_old")

        db!!.execSQL("CREATE TABLE ${StudentTable.TABLE_NAME} (" +
                "${StudentTable.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${StudentTable.COLUMN_LAST_NAME} TEXT," +
                "${StudentTable.COLUMN_FIRST_NAME} TEXT," +
                "${StudentTable.COLUMN_MIDDLE_NAME} TEXT," +
                "${StudentTable.COLUMN_TIME} TEXT);")

        val cursor = db.rawQuery("SELECT * FROM Students_old", null)

        var fio: String
        var massFIO: List<String>
        while(!cursor.isAfterLast) {
            fio = cursor.getString(1)
            massFIO = fio.split(" ")

            db.execSQL("INSERT INTO ${StudentTable.TABLE_NAME} VALUES (" +
                    "${cursor.getInt(0)}, ${massFIO[0]}, ${massFIO[1]}, ${massFIO[2]}, ${cursor.getString(2)});")

            cursor.moveToNext()
        }

        cursor.close()

        db!!.execSQL("DROP TABLE Students_old")
    }
}