package com.example.laba2

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class SplashScreen: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()

        Thread(Runnable {
            Thread.sleep(2000)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }).start()
    }
}