package com.example.laba_3

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Query("SELECT * FROM student")
    fun getAll(): List<Student>

    @Query("DELETE FROM student")
    fun deleteAll()

    @Query("SELECT COUNT(*) FROM student")
    fun count(): Int

    @Insert
    fun insertAll(vararg students: Student)
}

