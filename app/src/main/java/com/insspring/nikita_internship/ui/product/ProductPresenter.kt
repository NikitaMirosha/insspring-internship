package com.insspring.nikita_internship.ui.product

import moxy.InjectViewState
import moxy.MvpPresenter
import com.insspring.nikita_internship.repo.ProductRepo

@InjectViewState
class ProductPresenter : MvpPresenter<ProductView>() {

    private val repo = ProductRepo()
    private val model = repo.getProduct()

    init {
        viewState.updateImages()
        viewState.updateProduct(model)
    }
}