package com.example.laba_4

import android.app.AlarmManager
import android.app.Notification
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.*

class MyWidget: AppWidgetProvider(){

    companion object{
        val format = SimpleDateFormat("dd.MM.yyyy")

        val NAME = "wInfo"
        val COUNT = "daysCount"
        val DATE = "date"
        val DEFAULT = "00.00.0000"

        fun updateWidget(context: Context, idWidget: Int, date: Calendar){
            var countDays = calculationCountDays(date)

            var sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
            sharedPreferences.edit().putString(DATE + idWidget, format.format(date.time)).commit()
            sharedPreferences.edit().putInt(COUNT + idWidget, countDays).commit()

            val widgetView = RemoteViews(context.packageName, R.layout.widget)
            widgetView.setTextViewText(R.id.tv_date, format.format(date.time))
            widgetView.setTextViewText(R.id.tv_countDays, countDays.toString())

            AppWidgetManager.getInstance(context).updateAppWidget(idWidget, widgetView)
        }

        fun calculationCountDays(date: Calendar): Int {
            var countDays = 0
            val theseDate = Calendar.getInstance()

            if (date.after(theseDate)) {
                val millis: Long = date.time.time - theseDate.time.time
                countDays = ((millis/(24 * 60 * 60 * 1000)) + 1) as Int
            }
            return countDays
        }
    }

    override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)

        for (i in 0..appWidgetIds!!.size) {
            val currentWidgetId = appWidgetIds[i];

            val configIntent = Intent(context, CalendarDialog::class.java)
            configIntent.action = AppWidgetManager.ACTION_APPWIDGET_CONFIGURE
            configIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, currentWidgetId)
            configIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            val pIntent = PendingIntent.getActivity(context, currentWidgetId, configIntent, 0)

            val widgetView = RemoteViews(context!!.packageName, R.layout.widget)
            widgetView.setOnClickPendingIntent(R.id.rl_widget, pIntent)
            appWidgetManager!!.updateAppWidget(currentWidgetId, widgetView)

            val sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)//для сохранений
            val textDate = sharedPreferences.getString(DATE + currentWidgetId, DEFAULT)

            if (!textDate.equals(DEFAULT)){
                val thisDate = Calendar.getInstance()
                val chooseDate = Calendar.getInstance()

                chooseDate.clear()
                chooseDate.time = format.parse(textDate)
                chooseDate.set(Calendar.HOUR, 9)

                if (thisDate.after(chooseDate)) {// прощлое
                    val myNotofication = MyNotofication(context!!)
                    myNotofication.sendNotification()
                } else { //будущее
                    val alarmManager = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager

                    val intent = Intent(context!!, MainActivity::class.java)
                    intent.action = "Alarm"
                    intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, currentWidgetId)

                    val alarmIntent = PendingIntent.getBroadcast(context, currentWidgetId, intent, 0)

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, chooseDate.time.time, alarmIntent)
                    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        alarmManager.setExact(AlarmManager.RTC_WAKEUP, chooseDate.time.time, alarmIntent)
                    } else {
                        alarmManager.set(AlarmManager.RTC_WAKEUP, chooseDate.time.time, alarmIntent)
                    }
                }
                updateWidget(context, currentWidgetId, chooseDate)
            } else {
                widgetView.setTextViewText(R.id.tv_date, textDate)
                widgetView.setTextViewText(R.id.tv_countDays, "0")
                appWidgetManager.updateAppWidget(currentWidgetId, widgetView)
            }
        }
    }

    fun updateAfterAlarm(context: Context, idWidget: Int){
        var sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().putInt(COUNT + idWidget, 0).commit()

        val widgetView = RemoteViews(context.packageName, R.layout.widget)
        widgetView.setTextViewText(R.id.tv_countDays, "0")

        AppWidgetManager.getInstance(context).updateAppWidget(idWidget, widgetView)
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)

        if (intent!!.action.equals("Alarm")) {
            val notofication = MyNotofication(context!!)
            notofication.sendNotification()

            val idWidget = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, 0)
            updateAfterAlarm(context!!, idWidget)
        }
    }

    override fun onDeleted(context: Context?, appWidgetIds: IntArray?) {
        super.onDeleted(context, appWidgetIds)

        for (i in 0..appWidgetIds!!.size) {
            val currentWidgerId = appWidgetIds[i]

            val alarmManager = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager

            val intent = Intent(context!!, MyWidget::class.java)
            intent.action = "Alarm"

            val pIntent = PendingIntent.getBroadcast(context, currentWidgerId, intent,0)
            alarmManager.cancel(pIntent)

            val sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
            sharedPreferences.edit().remove(DATE + currentWidgerId).commit()
            sharedPreferences.edit().remove(COUNT + currentWidgerId).commit()
        }
    }
}