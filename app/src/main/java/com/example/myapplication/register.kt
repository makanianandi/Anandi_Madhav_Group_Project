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

class register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        val alreadyAcc=findViewById<TextView>(R.id.txtAlreadyAccount);
        btnSignUp.setOnClickListener { view ->
            register(view)
        }
        alreadyAcc.setOnClickListener { view ->
            openlogin(view)
        }
    }
    fun openlogin(view: View)
    {
        val intent= Intent(this,login::class.java)
        startActivity(intent)
    }
    fun register(view: View) {

        val emailAdd = findViewById<TextInputEditText>(R.id.txtEmail);
        val pass = findViewById<TextInputEditText>(R.id.txtPass);
        val conpass = findViewById<TextInputEditText>(R.id.txtConPass);

        var email = emailAdd.text.toString();
        var password = pass.text.toString();
        var conPass = conpass.text.toString();


        if(email.isNotEmpty() && password.isNotEmpty() && conPass.isNotEmpty())
        {
            if(password.equals(conPass))
            {
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                    if(it.isSuccessful)
                    {
                        Toast.makeText(this, "You clicked me.", Toast.LENGTH_LONG).show();
                        Toast.makeText(this,"Register Successfully",Toast.LENGTH_LONG).show()
                        val intent= Intent(this,login::class.java)
                        startActivity(intent)
                    }
                    else
                    {
                        Toast.makeText(this,it.exception.toString(),Toast.LENGTH_LONG).show()
                    }
                }
            }
            else
            {
                Toast.makeText(this,"Password does not match",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this,"Empty fields are not allowed",Toast.LENGTH_LONG).show();
        }

//        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
//            if(task.isSuccessful){
//                val intent= Intent(this,MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
//        }.addOnFailureListener { exception ->
//            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
//        }
//    }
//    fun goToLogin(view: View){
//        val intent= Intent(this,login::class.java)
//        startActivity(intent)
//    }
    }
}