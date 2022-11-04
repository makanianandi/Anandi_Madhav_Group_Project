package com.example.myapplication
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class ProductAdapter(val context: Context, val product: FirebaseRecyclerOptions<product>):FirebaseRecyclerAdapter<product,ProductAdapter.ProductHolder>(product) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ProductHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int, model: product) {

        Glide.with(holder.imgProduct.context).load(model.image).into(holder.imgProduct)
        holder.txtProductName.text = model.name
        holder.txtProductDesc.text = model.desc
        holder.txtProductPrice.text = model.price

        holder.itemView.setOnClickListener{
                val intent = Intent(context, productDetails::class.java);
                intent.putExtra("proName", model.name)
                intent.putExtra("proPrice", model.price)
                intent.putExtra("proDesc", model.desc)
                intent.putExtra("proImg", model.image)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                context!!.startActivity(intent)


        }

    }
    class ProductHolder(inflater: LayoutInflater, parent: ViewGroup)
        : RecyclerView.ViewHolder(inflater.inflate(R.layout.layout_row_product, parent, false))
    {
        val txtProductName : TextView = itemView.findViewById(R.id.txtProductName)
        val txtProductDesc : TextView = itemView.findViewById(R.id.txtProductDesc)
        val txtProductPrice : TextView = itemView.findViewById(R.id.txtProductPrice)
        val imgProduct : ImageView = itemView.findViewById(R.id.imgProduct)
    }
}
