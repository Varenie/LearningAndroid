package com.example.laba_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val format = SimpleDateFormat("HH:mm:ss")

    var names: Array<String> = arrayOf(
        ("Коротких Александр Станиславович"), // добавить больше имен
        ("Попова Елизавета Владимировна"),
        ("Белуга Никита Сергеевич"),
        ("Карягина Анастасия Егоровна"),
        ("Груздева Валерия Дмитриевна"),
        ("Безуглаый Масим Викторович"),
        ("Беликов Дмитрий Владиславович"),
        ("Белькова Евгения Александровна"),
        ("Беспечная Юлия Владимировна"),
        ("Бубнова Валерия Алексеевна"),
        ("Горелкин Александр Сергеевич"),
        ("Груздева Валерия Дмитриевна")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db: AppDatabase? = App.instance!!.database
        db!!.studentDao().deleteAll()

        for(i in 0..1){
            val n = Random.nextInt(0, names.size)
            val time = Calendar.getInstance()
            val data = format.format(time.time)

            var student: Student = Student(i, names[n], data)

            db.studentDao().insertAll(students = *arrayOf(student))
        }

        Log.d("SIZE",db.studentDao().count().toString())
    }

    fun showInfo(view: View) {
        startActivity(Intent(this, ShowActivity::class.java))
    }

}
