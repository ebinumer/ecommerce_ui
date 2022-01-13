package com.ebinumer.groceries.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.ebinumer.groceries.R
import com.ebinumer.groceries.data.RecentlyViewed
import com.ebinumer.groceries.ui.ProductDetails

class RecentlyViewedAdapter(var context: Context, var recentlyViewedList: List<RecentlyViewed>) :
    RecyclerView.Adapter<RecentlyViewedAdapter.RecentlyViewedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentlyViewedViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.recently_viewed_items, parent, false)
        return RecentlyViewedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecentlyViewedViewHolder, position: Int) {
        holder.name.setText(recentlyViewedList[position].name)
        holder.description.setText(recentlyViewedList[position].description)
        holder.price.setText(recentlyViewedList[position].price)
        holder.qty.setText(recentlyViewedList[position].quantity)
        holder.unit.setText(recentlyViewedList[position].unit)
        holder.bg.setBackgroundResource(recentlyViewedList[position].imageUrl)
        holder.itemView.setOnClickListener {
            val i = Intent(context, ProductDetails::class.java)
            i.putExtra("name", recentlyViewedList[position].name)
            i.putExtra("image", recentlyViewedList[position].bigimageurl)
            i.putExtra("price", recentlyViewedList[position].price)
            i.putExtra("desc", recentlyViewedList[position].description)
            i.putExtra("qty", recentlyViewedList[position].quantity)
            i.putExtra("unit", recentlyViewedList[position].unit)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return recentlyViewedList.size
    }

    class RecentlyViewedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var description: TextView
        var price: TextView
        var qty: TextView
        var unit: TextView
        var bg: ConstraintLayout

        init {
            name = itemView.findViewById(R.id.product_name)
            description = itemView.findViewById(R.id.description)
            price = itemView.findViewById(R.id.price)
            qty = itemView.findViewById(R.id.qty)
            unit = itemView.findViewById(R.id.unit)
            bg = itemView.findViewById(R.id.recently_layout)
        }
    }

}
