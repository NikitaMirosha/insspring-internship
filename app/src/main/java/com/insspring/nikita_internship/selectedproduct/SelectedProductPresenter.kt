package com.insspring.nikita_internship.selectedproduct

import moxy.InjectViewState
import moxy.MvpPresenter
import com.insspring.nikita_internship.repository.ProductRepo

@InjectViewState
class SelectedProductPresenter : MvpPresenter<SelectedProductView>() {

    private val repo = ProductRepo()
    private val model = repo.getProduct()

    init {
        viewState.updateImages()
        viewState.updateProduct(model)
    }
}