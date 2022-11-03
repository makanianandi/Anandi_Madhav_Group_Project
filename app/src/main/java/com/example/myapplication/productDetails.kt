package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class productDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val imgProductFullView: ImageView? = null
        var imgPlusButton:android.widget.ImageView? = null
        var imgMinusButton:android.widget.ImageView? = null;

        val txtProDetailsPrice: TextView? =null
        var txtProDetailsName:TextView? = null
        var txtProDetails:TextView? = null
        var txtSizeDesc:TextView? = null
        var txtMaterial:TextView? = null
        var txtProDetailsQty:TextView? = null

        val btnAddToCart: Button? = null

    }
}