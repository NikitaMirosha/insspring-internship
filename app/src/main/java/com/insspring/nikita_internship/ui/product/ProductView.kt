package com.insspring.nikita_internship.ui.product

import com.delivery.ui.base.BaseMvpView
import com.insspring.nikita_internship.model.ProductModel

interface ProductView : BaseMvpView {
    fun updateProduct(product: ProductModel)
    fun updateImages()
}
