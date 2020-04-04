package com.example.laba2

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class DataLoader(context: Activity): AsyncTask<URL, Void, String>() { //error
    val context: Activity = context

    override fun doInBackground(vararg params: URL): String {
        var singleton: Singleton = Singleton.getInstance()!!

        try {
            val responseToQuery: String = DataConnect().query(params[0])

            var gson = Gson()

            val data = gson.fromJson(responseToQuery, Array<Tech>::class.java)
            var i = 0
            for(x in data){
                singleton.name[i] = x.name.toString()
                singleton.helptext[i] = x.helptext.toString()
                singleton.image[i] = x.graphic.toString()
                i++
            }
        }catch (e: JSONException){
            e.stackTrace
        }catch (e: IOException){
            e.stackTrace
        }


        return "0"
    }

}