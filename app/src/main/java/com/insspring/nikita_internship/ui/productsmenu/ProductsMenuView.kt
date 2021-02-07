package com.insspring.nikita_internship.ui.productsmenu

import com.delivery.ui.base.BaseMvpView
import com.insspring.nikita_internship.model.ProductModel

interface ProductsMenuView : BaseMvpView {
    fun updateProducts(products: List<ProductModel>)
    fun updateImages()
    fun updateProductListView()
    fun goToProductScreen(productModel: ProductModel)
}
