package com.tawfiq.tictactoeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home__page.*

class Home_Page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home__page)

        button1.setOnClickListener { playvsplay() }
        button2.setOnClickListener { playvscom() }
    }

    fun playvscom() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("multi", "false")
        startActivity(intent)
    }

    fun playvsplay() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("multi", "true")
        startActivity(intent)
    }
}
