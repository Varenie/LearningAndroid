package com.example.laba_3

import android.provider.BaseColumns

object DBReader {
    object StudentTable: BaseColumns{
        const val TABLE_NAME = "Students"
        const val COLUMN_ID = "student_id"
        const val COLUMN_FIO = "fio"
        const val COLUMN_TIME = "time"
    }
}