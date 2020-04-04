package com.example.laba2

import android.util.Log
import java.net.URL
import java.util.*
import javax.net.ssl.HttpsURLConnection

class DataConnect {
    fun query(url: URL): String{
        val conection = url.openConnection() as HttpsURLConnection

        try {
            val input = conection.inputStream
            val scanner = Scanner(input)
            scanner.useDelimiter("\\A")

            return scanner.next()
        }finally {
            conection.disconnect()
        }
    }
}