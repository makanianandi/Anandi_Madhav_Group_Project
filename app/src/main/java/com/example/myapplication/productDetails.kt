package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class productDetails : AppCompatActivity() {

    var imgProductFullView: ImageView? = null
    var txtProDetailsPrice: TextView? =null;
    var txtProDetailsName:TextView? = null;
    var txtProDetails:TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        imgProductFullView = findViewById<ImageView>(R.id.imgProductFullView)
        txtProDetailsName = findViewById<TextView>(R.id.txtProDetailsName)
        txtProDetailsPrice = findViewById<TextView>(R.id.txtProDetailsPrice)
        txtProDetails=findViewById<TextView>(R.id.txtProDetails)

        txtProDetailsName!!.text = intent.getStringExtra("proName")
        txtProDetailsPrice!!.text = intent.getStringExtra("proPrice")
        txtProDetails!!.text = intent.getStringExtra("proDesc")
        Glide.with(applicationContext).load(intent.getStringExtra("proImg")).into(imgProductFullView!!)


    }
}

private fun ImageView.setImageURI(stringExtra: String?) {

}
