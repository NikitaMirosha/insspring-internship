package com.insspring.nikita_internship.ui.product

import com.insspring.nikita_internship.model.ProductModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ProductView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun updateProduct(product: ProductModel)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun updateImages()
}
