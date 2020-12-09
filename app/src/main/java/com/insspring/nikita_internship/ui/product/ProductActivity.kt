package com.insspring.nikita_internship.ui.product

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.delivery.ui.base.BaseMvpActivity
import com.insspring.nikita_internship.R.*
import com.insspring.nikita_internship.model.ProductModel
import com.insspring.nikita_internship.ui.addtobag.AddToBagActivity
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : BaseMvpActivity(), ProductView {

    @InjectPresenter
    lateinit var productPresenter: ProductPresenter

    override fun getLayoutId(): Int = layout.activity_product

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        initListeners()
    }

    private fun initListeners() {
        vLlBackArrow.setOnClickListener {
            productPresenter.onBackButtonClicked()
        }

        vLlAddToBag.setOnClickListener {
            productPresenter.onAddToBagClicked()
        }
    }

    override fun openAddToBagActivity() {
        startActivity(Intent(this, AddToBagActivity::class.java))
    }

    override fun backToPrevScreen() {
        finish()
    }

    override fun updateProduct(product: ProductModel) {
        vTvProductName.text = getString(string.about_orange, product.productName)
        vTvProductInfo.text = product.productInfo ?: ""
        vTvRateMark.text = getString(string.rate_mark, product.rateMark)
        vTvBestSeller.text = getString(string.best_seller, product.bestSeller)
        vTvPrice.text = getString(string.price, product.productPrice)
    }

    override fun updateImages() {
        Glide.with(this)
            .load(drawable.ic_back_arrow)
            .placeholder(drawable.ic_back_arrow)
            .into(vIvArrow)

        Glide.with(this)
            .load(drawable.ic_like_product)
            .placeholder(drawable.ic_like_product)
            .into(vIvHeart)

        Glide.with(this)
            .load(drawable.ic_bag)
            .placeholder(drawable.ic_bag)
            .into(vIvBag)

        Glide.with(this)
            .load(drawable.ic_user_rate)
            .placeholder(drawable.ic_user_rate)
            .into(vIvUserOne)

        Glide.with(this)
            .load(drawable.ic_user_rate)
            .placeholder(drawable.ic_user_rate)
            .into(vIvUserTwo)

        Glide.with(this)
            .load(drawable.ic_user_rate)
            .placeholder(drawable.ic_user_rate)
            .into(vIvUserThree)

        Glide.with(this)
            .load(drawable.ic_star)
            .placeholder(drawable.ic_star)
            .into(vIvStar)
    }

}
