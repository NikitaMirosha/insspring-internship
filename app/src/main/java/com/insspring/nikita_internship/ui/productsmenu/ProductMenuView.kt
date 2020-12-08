package com.insspring.nikita_internship.ui.productsmenu

import com.delivery.ui.base.BaseMvpView
import com.insspring.nikita_internship.model.ProductModel

interface ProductMenuView : BaseMvpView {
    fun updateProducts(products: List<ProductModel>)
}
