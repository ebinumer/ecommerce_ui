package com.ebinumer.groceries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ebinumer.groceries.R
import com.ebinumer.groceries.data.Category

class CategoryAdapter(var context: Context, categoryList: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    var categoryList: List<Category>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.category_row_items, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        categoryList[position].imageurl?.let { holder.categoryImage.setImageResource(it) }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var categoryImage: ImageView

        init {
            categoryImage = itemView.findViewById(R.id.categoryImage)
        }
    }

    init {
        this.categoryList = categoryList
    }
}