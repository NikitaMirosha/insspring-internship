package presenter

import moxy.InjectViewState
import moxy.MvpPresenter
import orangeapplication.main.repository.ProductRepo
import orangeapplication.main.view.ProductView

@InjectViewState
class ProductPresenter : MvpPresenter<ProductView>() {

    private val repo = ProductRepo()
    private val model = repo.getProduct()

    init {
        viewState.updateImages()
        viewState.updateProduct(model)
    }
}