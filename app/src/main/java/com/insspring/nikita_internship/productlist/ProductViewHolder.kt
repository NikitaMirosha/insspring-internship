package com.insspring.nikita_internship.productlist

import android.view.View
import com.delivery.ui.base.baseadapter.BaseViewHolder
import com.insspring.nikita_internship.model.ProductModel
import kotlinx.android.synthetic.main.item_product.view.*

class ProductViewHolder(itemView: View, val itemClicked: (ProductModel) -> Unit) :
    BaseViewHolder<ProductModel>(itemView) {

    override fun bind(model: ProductModel) {
        itemView.vTvProductNameCard.text = model.productName
        itemView.vTvProductPriceCard.text = model.productPrice.toString()

        setOnClickListener {
            itemClicked(model)
        }
    }
}

//        vTvProductName.text = getString(R.string.about_orange, product.productName)
//        vTvProductInfo.text = product.productInfo ?: ""
//        vTvRateMark.text = getString(R.string.rate_mark, product.rateMark)
//        vTvBestSeller.text = getString(R.string.best_seller, product.bestSeller)
//        vTvPrice.text = getString(R.string.price, product.price)