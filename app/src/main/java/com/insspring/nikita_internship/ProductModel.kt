package orangeapplication.main.model

import java.math.BigDecimal

data class ProductModel(
        var productName: String? = null,
        var productInfo: String? = null,
        var bestSeller: String? = null,
        var rateMark: BigDecimal? = null,
        var price: BigDecimal? = null
)