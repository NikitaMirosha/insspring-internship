package com.insspring.nikita_internship.product

import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.insspring.nikita_internship.R.*
import com.insspring.nikita_internship.addtobag.AddToBagActivity
import com.insspring.nikita_internship.model.ProductModel
import com.insspring.nikita_internship.productlist.ProductsListActivity
import kotlinx.android.synthetic.main.activity_product.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class ProductActivity : MvpAppCompatActivity(), ProductView {

    @InjectPresenter
    lateinit var productPresenter: ProductPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_product)

        initListeners()
    }

    private fun initListeners() {
        vLlUserProfile.setOnClickListener {
            openBackActivity()
        }

        vLlAddToBag.setOnClickListener {
            addToBagActivity()
        }
    }

    private fun openBackActivity() {
        val intent = Intent(this, ProductsListActivity::class.java)
        startActivity(intent)
    }

    private fun addToBagActivity() {
        val intent = Intent(this, AddToBagActivity::class.java)
        startActivity(intent)
    }

    override fun updateProduct(product: ProductModel) {
        vTvProductName.text = getString(string.about_orange, product.productName)
        vTvProductInfo.text = product.productInfo ?: ""
        vTvRateMark.text = getString(string.rate_mark, product.rateMark)
        vTvBestSeller.text = getString(string.best_seller, product.bestSeller)
        vTvPrice.text = getString(string.price, product.productPrice)
    }

    override fun updateImages() {
        Glide.with(this).load(drawable.ic_back_arrow).placeholder(drawable.ic_back_arrow).into(vIvArrow)
        Glide.with(this).load(drawable.ic_like_product).placeholder(drawable.ic_like_product).into(vIvHeart)
        Glide.with(this).load(drawable.ic_bag).placeholder(drawable.ic_bag).into(vIvBag)
        Glide.with(this).load(drawable.ic_user_rate).placeholder(drawable.ic_user_rate).into(vIvUserOne)
        Glide.with(this).load(drawable.ic_user_rate).placeholder(drawable.ic_user_rate).into(vIvUserTwo)
        Glide.with(this).load(drawable.ic_user_rate).placeholder(drawable.ic_user_rate).into(vIvUserThree)
        Glide.with(this).load(drawable.ic_star).placeholder(drawable.ic_star).into(vIvStar)
    }

}
