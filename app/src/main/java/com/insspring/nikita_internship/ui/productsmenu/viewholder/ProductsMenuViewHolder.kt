package com.insspring.nikita_internship.ui.productsmenu.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.delivery.ui.base.baseadapter.BaseViewHolder
import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.model.ProductModel
import kotlinx.android.synthetic.main.item_product.*

class ProductsMenuViewHolder(itemView: View, val itemClicked: (ProductModel) -> Unit) :
    BaseViewHolder<ProductModel>(itemView) {

    override fun bind(model: ProductModel) {
        vTvProductNameCard.text = model.productName
        vTvProductPriceCard.text = model.productPrice.toString()

        Glide.with(itemView).load(R.drawable.ic_like_product_list)
            .placeholder(R.drawable.ic_like_product_list).into(vIvLikeProductList)

        setOnClickListener {
            itemClicked(model)
        }
    }

}