package com.insspring.nikita_internship.ui.productsmenu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.delivery.ui.base.baseadapter.BaseListAdapter
import com.delivery.ui.base.baseadapter.BaseViewHolder
import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.model.ProductModel
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class ProductsMenuAdapter : BaseListAdapter<ProductModel>() {

    private val clickSubject: PublishSubject<ProductModel> = PublishSubject.create()
    val clickEvent: Observable<ProductModel> = clickSubject

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ProductModel> {

        return ProductsMenuViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product, parent, false),
            clickSubject
        )
    }

}