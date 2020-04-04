package com.example.laba2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import java.io.InputStream
import java.net.URL

class DownloadImage(mImage: ImageView): AsyncTask<String, Void, Bitmap>() {
    val mImage = mImage

    override fun doInBackground(vararg urls: String?): Bitmap? {
        val urldisplay = urls[0]
        var mIcon11: Bitmap? = null
        try {
            val input: InputStream = URL(urldisplay).openStream()
            mIcon11 = BitmapFactory.decodeStream(input)
        } catch (e: Exception) {
            Log.e("ERROR TRANS", e.message)
            e.printStackTrace()
        }
        return mIcon11
    }

    override fun onPostExecute(result: Bitmap?) {
        mImage.setImageBitmap(result)
    }

}