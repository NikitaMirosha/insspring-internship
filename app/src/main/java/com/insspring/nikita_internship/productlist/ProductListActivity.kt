package com.insspring.nikita_internship.productlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.bumptech.glide.Glide
import com.insspring.nikita_internship.R
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.activity_product_cards.*
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        //Glide.with(this).load(R.drawable.ic_user).placeholder(R.drawable.ic_user).into(vIvUserProfile)

        val posts: ArrayList<String> = ArrayList()
        for (i in 1..10) {
            posts.add("Card #$i")
        }

        vRvProductList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        vRvProductList.adapter = ProductAdapter(posts)

        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(vRvProductList)
    }
}