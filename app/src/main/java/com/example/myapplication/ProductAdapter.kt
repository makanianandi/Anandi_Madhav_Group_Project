package com.example.myapplication
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.storage.FirebaseStorage

class ProductAdapter(public val product: FirebaseRecyclerOptions<product>):FirebaseRecyclerAdapter<product,ProductAdapter.ProductHolder>(product) {

    var onItemClick : ((product) -> Unit)? = null

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
//        onItemClick?.invoke(product)
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