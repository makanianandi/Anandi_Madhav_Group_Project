package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class payment : AppCompatActivity() {


    var personfullname: TextInputEditText? = null
    var txtProvince:TextInputEditText? = null
    var txtPincode:TextInputEditText? = null
    var addressstreet1:TextInputEditText? = null
    var addressstreet2:TextInputEditText? = null
    var addresscity:TextInputEditText? = null
    var cardnumber:TextInputEditText? = null
    var expirydate:TextInputEditText? = null
    var cvvnumber:TextInputEditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val btnPayNow = findViewById<Button>(R.id.btnPayNow)

        personfullname = findViewById<TextInputEditText>(R.id.personfullname)
        txtProvince = findViewById<TextInputEditText>(R.id.txtProvince)
        txtPincode = findViewById<TextInputEditText>(R.id.txtPincode)
        addressstreet1 = findViewById<TextInputEditText>(R.id.addressstreet1)
        addressstreet2 = findViewById<TextInputEditText>(R.id.addressstreet2)
        addresscity = findViewById<TextInputEditText>(R.id.addresscity)
        cardnumber = findViewById<TextInputEditText>(R.id.cardnumber)
        expirydate = findViewById<TextInputEditText>(R.id.expirydate)
        cvvnumber = findViewById<TextInputEditText>(R.id.cvvnumber)

        btnPayNow.setOnClickListener {
            if (cardnumber!!.getText().toString().trim { it <= ' ' }.isEmpty()) {
                cardnumber!!.requestFocus()
                Toast.makeText(this, "Enter Card Number!", Toast.LENGTH_LONG).show()
            } else if (personfullname!!.getText().toString().trim { it <= ' ' }.isEmpty()) {
                personfullname!!.requestFocus()
                Toast.makeText(this, "Enter Full Name!", Toast.LENGTH_LONG).show()
            } else if (expirydate!!.getText().toString().trim { it <= ' ' }.isEmpty()) {
                expirydate!!.requestFocus()
                Toast.makeText(this, "Enter Expiry Date!", Toast.LENGTH_LONG).show()
            } else if (cvvnumber!!.getText().toString().trim { it <= ' ' }.isEmpty()) {
                cvvnumber!!.requestFocus()
                Toast.makeText(this, "Enter CVV Number!", Toast.LENGTH_LONG).show()
            } else if (addressstreet1!!.getText().toString().trim { it <= ' ' }.isEmpty()) {
                addressstreet1!!.requestFocus()
                Toast.makeText(this, "Enter Street Line 1!", Toast.LENGTH_LONG).show()
            } else if (addressstreet2!!.getText().toString().trim { it <= ' ' }.isEmpty()) {
                addressstreet2!!.requestFocus()
                Toast.makeText(this, "Enter Street Line 2!", Toast.LENGTH_LONG).show()
            } else if (addresscity!!.getText().toString().trim { it <= ' ' }.isEmpty()) {
                addresscity!!.requestFocus()
                Toast.makeText(this, "Enter Your City!", Toast.LENGTH_LONG).show()
            } else if (txtProvince!!.getText().toString().trim { it <= ' ' }.isEmpty()) {
                txtProvince!!.requestFocus()
                Toast.makeText(this, "Enter Your Province!", Toast.LENGTH_LONG).show()
            } else if (txtPincode!!.getText().toString().trim { it <= ' ' }.isEmpty()) {
                txtPincode!!.requestFocus()
                Toast.makeText(this, "Enter Pincode!", Toast.LENGTH_LONG).show()
            }  else {
                var intent: Intent = Intent(applicationContext, activity_successful::class.java)
                startActivity(intent)
            }
        }
    }
    override fun onBackPressed() {
        val intent= Intent(this,productDetails::class.java)
        startActivity(intent)
    }
}