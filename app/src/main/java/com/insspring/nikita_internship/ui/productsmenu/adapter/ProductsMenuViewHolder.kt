package com.insspring.nikita_internship.ui.productsmenu.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.delivery.ui.base.baseadapter.BaseViewHolder
import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.model.ProductModel
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_product.*

class ProductsMenuViewHolder(
    itemView: View,
    private val itemClicked: PublishSubject<ProductModel>
) : BaseViewHolder<ProductModel>(itemView) {

    override fun bind(model: ProductModel) {

        setupProductNameCard(model)
        setupProductPriceCard(model)
        updateImage()
        initClickListener(model)
    }

    private fun setupProductNameCard(model: ProductModel) {
        vTvProductNameCard.text = model.productName
    }

    private fun setupProductPriceCard(model: ProductModel) {
        vTvProductPriceCard.text = model.productPrice.toString()
    }

    private fun updateImage() {
        Glide.with(itemView)
            .load(R.drawable.ic_like_product_list)
            .placeholder(R.drawable.ic_like_product_list)
            .into(vIvLikeProductList)
    }

    private fun initClickListener(model: ProductModel) {
        setOnClickListener {
            itemClicked.onNext(model)
        }
    }

}