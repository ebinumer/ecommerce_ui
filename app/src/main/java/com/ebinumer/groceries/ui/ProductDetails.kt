package com.ebinumer.groceries.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ebinumer.groceries.R
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetails : AppCompatActivity() {
    var name: String? = null
    var price: String? = null
    var desc: String? = null
    var mQty: String? = null
    private var mUnit: String? = null
    var image = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val i = intent
        name = i.getStringExtra("name")
        image = i.getIntExtra("image", R.drawable.b1)
        price = i.getStringExtra("price")
        desc = i.getStringExtra("desc")
        mQty = i.getStringExtra("qty")
        mUnit = i.getStringExtra("unit")



        productName.text = name
        prodPrice.text = price
        prodDesc.text = desc
        qty.text = mQty
        unit.text = mUnit
        big_image.setImageResource(image)
        back2.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ProductDetails, MainActivity::class.java)
            startActivity(i)
            finish()
        })
    } // this tutorial has been completed
    // see you in the next.
}
