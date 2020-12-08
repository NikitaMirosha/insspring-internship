package com.insspring.nikita_internship.ui.productsmenu

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter
import com.insspring.nikita_internship.model.ProductModel
import com.insspring.nikita_internship.repo.ProductRepo

@InjectViewState
class ProductMenuPresenter : BaseMvpPresenter<ProductMenuView>() {

    private val repo = ProductRepo()
    private val model = repo.getProduct()
    var productsListModel: MutableList<ProductModel> = ArrayList()
    var productsNames = arrayOf("Orange", "Apple", "Lemon", "Pear")

    init {

        productsNames.forEach {
            val productModel = ProductModel(productName = it)
            productsListModel.add(productModel)
        }

        viewState.updateProducts(productsListModel)
    }

    fun onTextChanged(text: String) {
        viewState.updateProducts(
            productsListModel.filter {
                it.productName?.contains (text, ignoreCase = true) == true
            }
        )
    }
}