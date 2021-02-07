package com.insspring.nikita_internship.ui.productsmenu

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter
import com.insspring.nikita_internship.model.ProductModel
import com.insspring.nikita_internship.repo.ProductRepo
import io.reactivex.Observable

@InjectViewState
class ProductsMenuPresenter : BaseMvpPresenter<ProductsMenuView>() {

    private var productRepo: ProductRepo = ProductRepo()
    private var productsListModel: MutableList<ProductModel> = productRepo.getAllProducts()

    fun onCreate(clickEvent: Observable<ProductModel>) {

        initOnProductClickListener(clickEvent)
        updateProducts()
        updateImages()
        updateProductListView()

    }

    private fun initOnProductClickListener(clickEvent: Observable<ProductModel>) {
        clickEvent.subscribe { product ->
            viewState.goToProductScreen(product)
        }
    }

    private fun updateProducts() {
        viewState.updateProducts(productsListModel)
    }

    private fun updateImages() {
        viewState.updateImages()
    }

    private fun updateProductListView() {
        viewState.updateProductListView()
    }

    fun onTextChanged(text: String) {
        viewState.updateProducts(
            productsListModel.filter {
                it.productName?.contains (text, ignoreCase = true) == true
            }
        )
    }
}