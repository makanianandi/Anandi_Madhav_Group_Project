package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    private lateinit var  auth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth= FirebaseAuth.getInstance()
        val btnSignIn = findViewById<Button>(R.id.btnLogin)
        val forPass=findViewById<TextView>(R.id.txtForgotPassword);

        btnSignIn.setOnClickListener { view ->
            login(view)
        }
        forPass.setOnClickListener { view ->
            forgotPass(view)
        }
    }
    fun forgotPass(view: View) {
        val intent= Intent(this,forgotPassword::class.java)
        startActivity(intent)
    }
    fun login(view: View){

        val emailAdd = findViewById<TextInputEditText>(R.id.txtLoginEmail);
        val pass = findViewById<TextInputEditText>(R.id.txtLoginPassword);

        val email=emailAdd.text.toString();
        val password=pass.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty()){
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if(task.isSuccessful){
                    val intent= Intent(this,home::class.java)
                    startActivity(intent)
                    finish()
                }
            }.addOnFailureListener { exception ->
                Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this,"Empty fields are not allowed",Toast.LENGTH_LONG).show();
        }

    }
}