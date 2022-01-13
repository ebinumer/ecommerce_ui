package com.ebinumer.groceries.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebinumer.groceries.R
import com.ebinumer.groceries.adapter.CategoryAdapter
import com.ebinumer.groceries.adapter.DiscountedProductAdapter
import com.ebinumer.groceries.adapter.RecentlyViewedAdapter
import com.ebinumer.groceries.data.Category
import com.ebinumer.groceries.data.DiscountedProducts
import com.ebinumer.groceries.data.RecentlyViewed
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
 
    var discountedProductAdapter: DiscountedProductAdapter? = null
    var discountedProductsList: MutableList<DiscountedProducts>? = null
    var categoryAdapter: CategoryAdapter? = null
    var categoryList: MutableList<Category>? = null
    var recentlyViewedAdapter: RecentlyViewedAdapter? = null
    var recentlyViewedList: MutableList<RecentlyViewed>? = null
  
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        allCategoryImage.setOnClickListener(View.OnClickListener {
            val i = Intent(this@MainActivity, AllCategory::class.java)
            startActivity(i)
        })

        // adding data to model
        discountedProductsList = ArrayList<DiscountedProducts>()
        discountedProductsList!!.add(DiscountedProducts(1, R.drawable.discountberry))
        discountedProductsList!!.add(DiscountedProducts(2, R.drawable.discountbrocoli))
        discountedProductsList!!.add(DiscountedProducts(3, R.drawable.discountmeat))
        discountedProductsList!!.add(DiscountedProducts(4, R.drawable.discountberry))
        discountedProductsList!!.add(DiscountedProducts(5, R.drawable.discountbrocoli))
        discountedProductsList!!.add(DiscountedProducts(6, R.drawable.discountmeat))

        // adding data to model
        categoryList = ArrayList<Category>()
        categoryList!!.add(Category(1, R.drawable.ic_home_fruits))
        categoryList!!.add(Category(2, R.drawable.ic_home_fish))
        categoryList!!.add(Category(3, R.drawable.ic_home_meats))
        categoryList!!.add(Category(4, R.drawable.ic_home_veggies))
        categoryList!!.add(Category(5, R.drawable.ic_home_fruits))
        categoryList!!.add(Category(6, R.drawable.ic_home_fish))
        categoryList!!.add(Category(7, R.drawable.ic_home_meats))
        categoryList!!.add(Category(8, R.drawable.ic_home_veggies))

        // adding data to model
        recentlyViewedList = ArrayList<RecentlyViewed>()
        recentlyViewedList!!.add(
            RecentlyViewed(
                "Watermelon",
                "Watermelon has high water content and also provides some fiber.",
                "₹ 80",
                "1",
                "KG",
                R.drawable.card4,
                R.drawable.b4
            )
        )
        recentlyViewedList!!.add(
            RecentlyViewed(
                "Papaya",
                "Papayas are spherical or pear-shaped fruits that can be as long as 20 inches.",
                "₹ 85",
                "1",
                "KG",
                R.drawable.card3,
                R.drawable.b3
            )
        )
        recentlyViewedList!!.add(
            RecentlyViewed(
                "Strawberry",
                "The strawberry is a highly nutritious fruit, loaded with vitamin C.",
                "₹ 30",
                "1",
                "KG",
                R.drawable.card2,
                R.drawable.b1
            )
        )
        recentlyViewedList!!.add(
            RecentlyViewed(
                "Kiwi",
                "Full of nutrients like vitamin C, vitamin K, vitamin E, folate, and potassium.",
                "₹ 30",
                "1",
                "PC",
                R.drawable.card1,
                R.drawable.b2
            )
        )
        setDiscountedRecycler(discountedProductsList)
        setCategoryRecycler(categoryList)
        setRecentlyViewedRecycler(recentlyViewedList)
    }

    private fun setDiscountedRecycler(dataList: List<DiscountedProducts>?) {
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        discountedRecycler!!.layoutManager = layoutManager
        discountedProductAdapter = dataList?.let { DiscountedProductAdapter(this, it) }
        discountedRecycler!!.adapter = discountedProductAdapter
    }

    private fun setCategoryRecycler(categoryDataList: List<Category>?) {
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryRecycler!!.layoutManager = layoutManager
        categoryAdapter = categoryDataList?.let { CategoryAdapter(this, it) }
        categoryRecycler!!.adapter = categoryAdapter
    }

    private fun setRecentlyViewedRecycler(recentlyViewedDataList: List<RecentlyViewed>?) {
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recently_item!!.layoutManager = layoutManager
        recentlyViewedAdapter = recentlyViewedDataList?.let { RecentlyViewedAdapter(this, it) }
        recently_item!!.adapter = recentlyViewedAdapter
    } //Now again we need to create a adapter and model class for recently viewed items.
    // lets do it fast.
}
