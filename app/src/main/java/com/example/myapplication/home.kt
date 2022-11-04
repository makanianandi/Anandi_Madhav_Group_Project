package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import com.firebase.ui.database.FirebaseRecyclerOptions

class home : AppCompatActivity() {
    private var adapter: ProductAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val query = FirebaseDatabase.getInstance().reference.child("product")
        val product = FirebaseRecyclerOptions.Builder<product>().setQuery(query, product::class.java).build()
//        Log.e("Personal Data", "onCreate: ${product.snapshots.size}")

        adapter = ProductAdapter(applicationContext,product)

        val rView : RecyclerView = findViewById(R.id.rView)
        rView.layoutManager = LinearLayoutManager(this)
        rView.adapter = adapter
    }
    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }
}