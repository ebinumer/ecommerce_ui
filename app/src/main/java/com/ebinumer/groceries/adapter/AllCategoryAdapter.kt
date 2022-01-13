package com.ebinumer.groceries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ebinumer.groceries.R
import com.ebinumer.groceries.data.AllCategoryModel

class AllCategoryAdapter(var context: Context, categoryList: List<AllCategoryModel>) :
    RecyclerView.Adapter<AllCategoryAdapter.AllCategoryViewHolder>() {
    var categoryList: List<AllCategoryModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCategoryViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.all_category_row_items, parent, false)
        return AllCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllCategoryViewHolder, position: Int) {
        categoryList[position].imageurl?.let { holder.categoryImage.setImageResource(it) }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class AllCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var categoryImage: ImageView

        init {
            categoryImage = itemView.findViewById(R.id.categoryImage)
        }
    }

    init {
        this.categoryList = categoryList
    }
}
