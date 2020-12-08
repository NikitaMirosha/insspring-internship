package com.insspring.nikita_internship.productsmenu

import android.view.View
import com.delivery.ui.base.baseadapter.BaseViewHolder
import com.insspring.nikita_internship.model.ProductModel
import kotlinx.android.synthetic.main.item_product.*

class ProductsMenuViewHolder(itemView: View, val itemClicked: (ProductModel) -> Unit) :
    BaseViewHolder<ProductModel>(itemView) {

    override fun bind(model: ProductModel) {
        vTvProductNameCard.text = model.productName
        vTvProductPriceCard.text = model.productPrice.toString()

        setOnClickListener {
            itemClicked(model)
        }
    }

}