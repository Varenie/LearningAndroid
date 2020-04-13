package com.example.laba_3

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "FIO") var fio: String?,
    @ColumnInfo(name = "time") var time: String?
)