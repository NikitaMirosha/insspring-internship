package orangeapplication.main.view

import orangeapplication.main.model.ProductModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ProductView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun updateProduct(product: ProductModel)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun updateImages()
}
