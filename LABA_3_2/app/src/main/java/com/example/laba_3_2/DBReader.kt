package com.example.laba_3_2

import android.provider.BaseColumns

object DBReader {
    object StudentTable: BaseColumns{
        const val TABLE_NAME = "Students"
        const val COLUMN_ID = "student_id"
        const val COLUMN_FIRST_NAME = "first_name"
        const val COLUMN_MIDDLE_NAME = "middle_name"
        const val COLUMN_LAST_NAME = "last_name"
        const val COLUMN_FIO = "fio"
        const val COLUMN_TIME = "time"
    }
}