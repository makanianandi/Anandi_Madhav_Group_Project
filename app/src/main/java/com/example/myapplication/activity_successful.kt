package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class activity_successful : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_successful)

        val btncontinueshop = findViewById<Button>(R.id.btncontinueshop)
        btncontinueshop.setOnClickListener {
            var intent: Intent = Intent(applicationContext, home::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        Toast.makeText(applicationContext,"You Can't Go Back From This Page!", Toast.LENGTH_SHORT).show()
    }
}