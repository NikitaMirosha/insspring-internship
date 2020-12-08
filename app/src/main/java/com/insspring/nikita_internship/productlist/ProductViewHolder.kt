package com.insspring.nikita_internship.productlist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.delivery.ui.base.baseadapter.BaseViewHolder
import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.model.ProductModel
import kotlinx.android.synthetic.main.item_product.*

class ProductViewHolder(itemView: View, val itemClicked: (ProductModel) -> Unit) :
    BaseViewHolder<ProductModel>(itemView) {

    override fun bind(model: ProductModel) {
        vTvProductNameCard.text = model.productName
        vTvProductPriceCard.text = model.productPrice.toString()

        setOnClickListener {
            itemClicked(model)
        }
    }

    interface SelectedProduct {
        fun selectedProduct(productModel: ProductModel?)
    }
}