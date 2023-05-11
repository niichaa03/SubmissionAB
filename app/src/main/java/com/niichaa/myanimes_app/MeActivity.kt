package com.niichaa.myanimes_app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MeActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ABOUT_ME = "extra_about_me"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_me)

        val tvMe:TextView = findViewById(R.id.tv_me)

        val me = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_ABOUT_ME, Me::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_ABOUT_ME)
        }
        if (me != null) {
            val text = "${me.name.toString()} \n ${me.email}"
            tvMe.text = text
        }
    }
}