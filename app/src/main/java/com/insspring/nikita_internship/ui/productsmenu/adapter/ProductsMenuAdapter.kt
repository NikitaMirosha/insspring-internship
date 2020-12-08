package com.insspring.nikita_internship.ui.productsmenu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.delivery.ui.base.baseadapter.BaseListAdapter
import com.delivery.ui.base.baseadapter.BaseViewHolder
import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.model.ProductModel
import com.insspring.nikita_internship.ui.productsmenu.viewholder.ProductsMenuViewHolder

class ProductsMenuAdapter(
    productsModelList: List<ProductModel>,
    var itemClicked: (ProductModel) -> Unit
): BaseListAdapter<ProductModel>(productsModelList), Filterable {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ProductModel> {
        return ProductsMenuViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false),
            itemClicked
        )
    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }

}