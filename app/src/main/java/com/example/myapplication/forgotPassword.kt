package com.example.myapplication

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class forgotPassword : AppCompatActivity() {
//    create firebase object testing
    var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val btnresetpass = findViewById<Button>(R.id.btnResetPass)

        mAuth = FirebaseAuth.getInstance()

        btnresetpass.setOnClickListener(View.OnClickListener { resetPassword() })
    }
    private fun resetPassword() : Boolean{
        var txtemail = findViewById<TextInputEditText>(R.id.txtForgotEmail)
        var email = txtemail!!.text.toString()

            mAuth!!.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if (txtemail!!.length()<1){
                    txtemail!!.error="This Field is Required"
//                    Toast.makeText(this@forgotPassword,"Please Enter Valid Email ID!",Toast.LENGTH_LONG).show()
                }
                if (task.isSuccessful) {
                    Toast.makeText(
                        this@forgotPassword,
                        "Check your email to reset your password!",
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(Intent(this@forgotPassword, login::class.java))
                } else {
                    Toast.makeText(
                        this@forgotPassword,
                        "Try Again ! Something wrong happned!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        return true
        }
    }
