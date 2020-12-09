package com.insspring.nikita_internship.ui.productsmenu

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter
import com.insspring.nikita_internship.model.ProductModel
import io.reactivex.Observable

@InjectViewState
class ProductsMenuPresenter : BaseMvpPresenter<ProductsMenuView>() {

    private var productsListModel: MutableList<ProductModel> = ArrayList()
    // доставать из repo
    private var productsNames = arrayOf("Orange", "Apple", "Lemon", "Pear")

    fun onCreate(clickEvent: Observable<ProductModel>) {

        // в отдельный метод
        productsNames.forEach {
            val productModel = ProductModel(productName = it)
            productsListModel.add(productModel)
        }

        initOnProductClickListener(clickEvent)

        // каждый в отдельный метод
        viewState.updateProducts(productsListModel)
        viewState.updateImages()
        viewState.updateProductListView()

    }

    private fun initOnProductClickListener(clickEvent: Observable<ProductModel>) {
        clickEvent.subscribe { product ->
            viewState.goToProductScreen(product)
        }
    }

    fun onTextChanged(text: String) {
        viewState.updateProducts(
            productsListModel.filter {
                it.productName?.contains (text, ignoreCase = true) == true
            }
        )
    }
}