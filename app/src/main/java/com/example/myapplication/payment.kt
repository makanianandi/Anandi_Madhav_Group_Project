package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val btnPayNow = findViewById<Button>(R.id.btnPayNow)
        btnPayNow.setOnClickListener {
//            var intent: Intent = Intent(applicationContext, MainActivity::class.java)
//            startActivity(intent)
        }
    }
}