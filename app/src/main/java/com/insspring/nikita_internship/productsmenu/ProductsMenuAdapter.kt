package com.insspring.nikita_internship.productsmenu

import android.view.LayoutInflater
import android.view.ViewGroup
import com.delivery.ui.base.baseadapter.BaseListAdapter
import com.delivery.ui.base.baseadapter.BaseViewHolder
import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.model.ProductModel

class ProductsMenuAdapter(
    productsModelList: List<ProductModel>,
    var itemClicked: (ProductModel) -> Unit
): BaseListAdapter<ProductModel>(productsModelList) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ProductModel> {
        return ProductsMenuViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false),
            itemClicked
        )
    }

}