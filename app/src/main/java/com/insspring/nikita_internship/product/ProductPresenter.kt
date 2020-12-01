package com.insspring.nikita_internship.product

import moxy.InjectViewState
import moxy.MvpPresenter
import com.insspring.nikita_internship.repository.ProductRepo

@InjectViewState
class ProductPresenter : MvpPresenter<ProductView>() {

    private val repo = ProductRepo()
    private val model = repo.getProduct()

    init {
        viewState.updateImages()
        viewState.updateProduct(model)
    }
}