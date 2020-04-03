package com.example.laba2

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class DataLoader(context: Activity): AsyncTask<URL, Void, String>() { //error
    val context: Activity = context

    override fun doInBackground(vararg params: URL): String {
        var singleton: Singleton = Singleton().getInstance()

//        try {
//            val url = URL("www.android.com")
////            val con = url.openConnection() as HttpURLConnection
////
////            val datas = con.inputStream.bufferedReader().readText()
////
////            val json = JSONObject(datas)
////            val blockList = json.getJSONObject("blockList")
////            val warning = json.get("warnMessage").toString()
////            val keys = blockList.keys()
////            var permission = HashMap<String, Array<String?>>()

            val link = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/data/techs.ruleset.json"
            val url = URL(link)

            val conection = url.openConnection() as HttpsURLConnection
            val input = conection.inputStream.bufferedReader().readText()
//            val responseToQuery = DataConnect().query(params[0])

            var user: JSONObject
            val jsonResponse = JSONObject(input) // error
            val response = jsonResponse.getJSONObject("")
            val items = response.getJSONArray("")

            for (i in 0..items.length()) {
                user = items.getJSONObject(i)
                singleton.name[i] = user.getString("name")
                singleton.helptext[i] = user.getString("helptext")

            }
//        }catch (e: JSONException){
//            e.stackTrace
//        }catch (e: IOException){
//            e.stackTrace
//        }


        return "0"
    }

}