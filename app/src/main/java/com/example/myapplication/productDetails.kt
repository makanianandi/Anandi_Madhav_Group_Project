package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class productDetails : AppCompatActivity() {

    var imgMinusButton: ImageButton? = null
    var imgPlusButton:ImageButton? = null
    var imgProductFullView: ImageView? = null
    var txtProDetailsPrice: TextView? =null;
    var txtProDetailsName:TextView? = null;
    var txtProDetails:TextView? = null;
    var txtProDetailsQty:TextView? = null;
    var quantity = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        imgProductFullView = findViewById<ImageView>(R.id.imgProductFullView)
        txtProDetailsName = findViewById<TextView>(R.id.txtProDetailsName)
        txtProDetailsPrice = findViewById<TextView>(R.id.txtProDetailsPrice)
        txtProDetails=findViewById<TextView>(R.id.txtProDetails)
        txtProDetailsQty = findViewById<TextView>(R.id.txtProDetailsQty)
        imgMinusButton = findViewById(R.id.imgMinusButton)
        imgPlusButton = findViewById(R.id.imgPlusButton)

        txtProDetailsName!!.text = intent.getStringExtra("proName")
        txtProDetailsPrice!!.text = intent.getStringExtra("proPrice")?.drop(1)
        txtProDetails!!.text = intent.getStringExtra("proDesc")
        Glide.with(applicationContext).load(intent.getStringExtra("proImg")).into(imgProductFullView!!)

        val price: String = txtProDetailsPrice!!.getText().toString()
        val baseprice = price.toDouble()


        imgPlusButton!!.setOnClickListener {
            quantity++
            displayQuantity()
            val detailprice = baseprice * quantity
            val setnewPrice = detailprice.toString()
            txtProDetailsPrice!!.setText(setnewPrice)
        }

        imgMinusButton!!.setOnClickListener {
            if (quantity == 1) {
                Toast.makeText(
                    this,
                    "The Quantity Should be atleast 1",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                quantity--
                displayQuantity()
                val detailprice = baseprice * quantity
                val setnewPrice = detailprice.toString()
                txtProDetailsPrice!!.setText(setnewPrice)
            }
        }

        val btnAddToCart = findViewById<Button>(R.id.btnAddToCart)
        btnAddToCart.setOnClickListener {
            var intent: Intent = Intent(applicationContext, payment::class.java)
            startActivity(intent)
        }

    }
    private fun displayQuantity() {
        txtProDetailsQty!!.setText(quantity.toString())
    }
}

private fun ImageView.setImageURI(stringExtra: String?) {

}
