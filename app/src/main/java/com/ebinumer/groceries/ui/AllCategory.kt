package com.ebinumer.groceries.ui

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.ebinumer.groceries.R
import com.ebinumer.groceries.adapter.AllCategoryAdapter
import com.ebinumer.groceries.data.AllCategoryModel
import kotlinx.android.synthetic.main.activity_all_category.*
import java.util.ArrayList

class AllCategory : AppCompatActivity() {

    var allCategoryAdapter: AllCategoryAdapter? = null
    var allCategoryModelList: MutableList<AllCategoryModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_category)
        back.setOnClickListener(View.OnClickListener {
            val back = Intent(this@AllCategory, MainActivity::class.java)
            startActivity(back)
            finish()
        })


        // adding data to model
        allCategoryModelList = ArrayList<AllCategoryModel>()
        allCategoryModelList!!.add(AllCategoryModel(1, R.drawable.ic_fruits))
        allCategoryModelList!!.add(AllCategoryModel(2, R.drawable.ic_veggies))
        allCategoryModelList!!.add(AllCategoryModel(3, R.drawable.ic_meat))
        allCategoryModelList!!.add(AllCategoryModel(4, R.drawable.ic_fish))
        allCategoryModelList!!.add(AllCategoryModel(5, R.drawable.ic_spices))
        allCategoryModelList!!.add(AllCategoryModel(6, R.drawable.ic_egg))
        allCategoryModelList!!.add(AllCategoryModel(7, R.drawable.ic_drink))
        allCategoryModelList!!.add(AllCategoryModel(8, R.drawable.ic_cookies))
        allCategoryModelList!!.add(AllCategoryModel(8, R.drawable.ic_juce))
        setCategoryRecycler(allCategoryModelList)
    }

    private fun setCategoryRecycler(allcategoryModelList: List<AllCategoryModel>?) {
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 4)
        all_category!!.layoutManager = layoutManager
        all_category!!.addItemDecoration(GridSpacingItemDecoration(4, dpToPx(16), true))
        all_category!!.itemAnimator = DefaultItemAnimator()
        allCategoryAdapter = AllCategoryAdapter(this, allcategoryModelList!!)
        all_category!!.adapter = allCategoryAdapter
    }

    // now we need some item decoration class for manage spacing
    inner class GridSpacingItemDecoration(
        private val spanCount: Int,
        private val spacing: Int,
        private val includeEdge: Boolean
    ) :
        ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            val position = parent.getChildAdapterPosition(view) // item position
            val column = position % spanCount // item column
            if (includeEdge) {
                outRect.left =
                    spacing - column * spacing / spanCount // spacing - column * ((1f / spanCount) * spacing)
                outRect.right =
                    (column + 1) * spacing / spanCount // (column + 1) * ((1f / spanCount) * spacing)
                if (position < spanCount) { // top edge
                    outRect.top = spacing
                }
                outRect.bottom = spacing // item bottom
            } else {
                outRect.left = column * spacing / spanCount // column * ((1f / spanCount) * spacing)
                outRect.right =
                    spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private fun dpToPx(dp: Int): Int {
        val r = resources
        return Math.round(
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp.toFloat(),
                r.displayMetrics
            )
        )
    }
}


