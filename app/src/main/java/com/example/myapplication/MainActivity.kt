package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEmailSignUp = findViewById<Button>(R.id.btnEmailSignUp)

        btnEmailSignUp.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        Toast.makeText(applicationContext,"You Can't Go Back From This Page!", Toast.LENGTH_SHORT).show()
    }
}