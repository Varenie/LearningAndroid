package com.example.laba_3

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random
import com.example.laba_3.DBReader.StudentTable

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
        ("Ефремов Михаил Сергеевич"),
        ("Касьяненько Константин Владимирович"),
        ("Корчемный Александр Владимирович"),
        ("Кужахметова Арина Сериковна"),
        ("Кузнецов Егор Глебович"),
        ("Курганов Александр Олегович"),
        ("Мозалев Максим Сергеевич"),
        ("Нефедов Андрей Алексеевич"),
        ("Осадчук Георгий Мирославович"),
        ("Павлов Дмитрий Владимирович"),
        ("Павлова Екатерина Владимировна"),
        ("Панков Владислав Михайлович"),
        ("Панькова Александра Игоревна"),
        ("Пономарев Андрей Романович"),
        ("Проселков Захар Сергеевич"),
        ("Семенихин Александр Олегович"),
        ("Сизов Даниил Юрьевич"),
        ("Стельмах Полина Геннадьевна"),
        ("Ткачев Антон Михайлович"),
        ("Шамян Георгий Григорьевич"),
        ("Шибзухов Астемир Аслонович")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        val dbHelper = DBHelper(this)
        val db = dbHelper.writableDatabase

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db.execSQL("DELETE FROM ${StudentTable.TABLE_NAME}")

        var date: Calendar
        var stringDate: String
        var n: Int
        var values: ContentValues
        for( i in 0..4) {
            date = Calendar.getInstance()
            stringDate = format.format(date.time).toString()

            n = Random.nextInt(names.size)

            values = ContentValues().apply {
                put(StudentTable.COLUMN_FIO, names.get(n))
                put(StudentTable.COLUMN_TIME, stringDate)
            }

            db.insert(StudentTable.TABLE_NAME, null, values)
        }
    }

    fun showInfo(view: View) {
        startActivity(Intent(this, ShowActivity::class.java))
    }

    fun changeInfo(view: View) {
        val dbHelper = DBHelper(this)
        val db = dbHelper.writableDatabase

        val cursor = db.rawQuery("SELECT MAX(${StudentTable.COLUMN_ID}) FROM ${StudentTable.TABLE_NAME}", null)
        cursor.moveToNext()

        val id = cursor.getInt(0)

        val values = ContentValues().apply {
            put(StudentTable.COLUMN_FIO, "Иванов Иван Иванович")
        }
        db.update(StudentTable.TABLE_NAME, values, StudentTable.COLUMN_ID + "=" + id, null)
    }

    fun updateInfo(view: View) {
        val dbHelper = DBHelper(this)
        val db = dbHelper.writableDatabase

        var date: Calendar
        var stringDate: String
        var n: Int
        var values: ContentValues

        date = Calendar.getInstance()
        stringDate = format.format(date.time).toString()

        n = Random.nextInt(names.size)

        values = ContentValues().apply {
            put(StudentTable.COLUMN_FIO, names.get(n))
            put(StudentTable.COLUMN_TIME, stringDate)
        }

        db.insert(StudentTable.TABLE_NAME, null, values)
    }
}
