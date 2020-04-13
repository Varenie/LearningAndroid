package com.example.laba_3

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Student::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun studentDao(): StudentDao
}