package com.ebinumer.groceries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ebinumer.groceries.R
import com.ebinumer.groceries.data.DiscountedProducts

class DiscountedProductAdapter(
    var context: Context,
    var discountedProductsList: List<DiscountedProducts>
) :
    RecyclerView.Adapter<DiscountedProductAdapter.DiscountedProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountedProductViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.discounted_row_items, parent, false)
        return DiscountedProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiscountedProductViewHolder, position: Int) {
        discountedProductsList[position].imageurl?.let {
            holder.discountImageView.setImageResource(
                it
            )
        }
    }

    override fun getItemCount(): Int {
        return discountedProductsList.size
    }

    class DiscountedProductViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var discountImageView: ImageView

        init {
            discountImageView = itemView.findViewById(R.id.discountImage)
        }
    }

}
