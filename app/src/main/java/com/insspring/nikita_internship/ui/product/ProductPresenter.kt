package com.insspring.nikita_internship.ui.product

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter
import com.insspring.nikita_internship.repo.ProductRepo

@InjectViewState
class ProductPresenter : BaseMvpPresenter<ProductView>() {

    private val repo = ProductRepo()
    private val productModel = repo.getProduct()

    init {
        viewState.updateImages()
        viewState.updateProduct(productModel)
    }

    fun onAddToBagClicked() {
        viewState.openAddToBagActivity()
    }

    fun onBackButtonClicked() {
        viewState.backToPrevScreen()
    }
}