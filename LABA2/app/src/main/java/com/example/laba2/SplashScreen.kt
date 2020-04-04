package com.example.laba2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.net.URL

class SplashScreen: AppCompatActivity() {
    private var flag: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()

        val link = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/data/techs.ruleset.json"
        if(!flag) {
            var url: URL? = null

            try {
                url = URL(link)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            DataLoader(this).execute(url)

            Thread(Runnable {
                Thread.sleep(2000)
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }).start()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putBoolean("flag", true)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        flag = savedInstanceState.getBoolean("flag")
    }
}