package com.example.laba_4

import android.app.Activity
import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Process.killProcess
import android.os.Process.myPid
import java.util.*

class CalendarDialog: Activity() {

   

    var idWidget = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        idWidget = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, 0)

        //creating date dialog
        val thisDate = Calendar.getInstance()
        var dateDialog = DatePickerDialog(this, dateDialogListener,thisDate.get(Calendar.YEAR), thisDate.get(Calendar.MONTH), thisDate.get(Calendar.DAY_OF_MONTH))
        dateDialog.setCancelable(false)

        val listener =
            DialogInterface.OnClickListener { dialog, which ->
                killProcessApp()
            }
        dateDialog.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Отмена", listener)

        dateDialog.show()
    }
    
    val dateDialogListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

        fun onDataSet(view: DatePickerDialog, year: Int, month: Int, day: Int){
            val date = Calendar.getInstance()
            date.set(year, month, day, 9, 0)

            val alarmManager =
                this@CalendarDialog.getSystemService(Context.ALARM_SERVICE) as AlarmManager

            val intent = Intent(this@CalendarDialog, MainActivity::class.java)
            intent.action = "Alarm"
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, idWidget)

            val pIntent = PendingIntent.getBroadcast(this@CalendarDialog, idWidget, intent, 0)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, date.time.time, pIntent);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, date.time.time, pIntent);
            } else {
                alarmManager.set(AlarmManager.RTC_WAKEUP, date.time.time, pIntent);
            }


            MyWidget.updateWidget(this@CalendarDialog, idWidget, date);
            killProcessApp();
        }
    }

    fun killProcessApp(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.finishAndRemoveTask();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                finishAffinity();
            } else {
                finish();
            }
        }
        killProcess(myPid())
    }
}