package com.insspring.nikita_internship.product

import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.insspring.nikita_internship.addtobag.AddToBagActivity
import com.insspring.nikita_internship.R.*
import kotlinx.android.synthetic.main.activity_product.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import com.insspring.nikita_internship.productlist.ProductListActivity
import com.insspring.nikita_internship.model.ProductModel

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
        val intent = Intent(this, ProductListActivity::class.java)
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
        vTvPrice.text = getString(string.price, product.price)
    }

    override fun updateImages() {
        Glide.with(this).load(drawable.ic_arrow).placeholder(drawable.ic_arrow).into(vIvArrow)
        Glide.with(this).load(drawable.ic_heart).placeholder(drawable.ic_heart).into(vIvHeart)
        Glide.with(this).load(drawable.ic_bag).placeholder(drawable.ic_bag).into(vIvBag)
        Glide.with(this).load(drawable.ic_user).placeholder(drawable.ic_user).into(vIvUserOne)
        Glide.with(this).load(drawable.ic_user).placeholder(drawable.ic_user).into(vIvUserTwo)
        Glide.with(this).load(drawable.ic_user).placeholder(drawable.ic_user).into(vIvUserThree)
        Glide.with(this).load(drawable.ic_star).placeholder(drawable.ic_star).into(vIvStar)
    }

}
