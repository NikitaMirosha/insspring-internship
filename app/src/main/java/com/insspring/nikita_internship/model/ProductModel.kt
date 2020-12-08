package com.insspring.nikita_internship.model

import android.widget.ImageView
import java.math.BigDecimal

data class ProductModel(
        var productName: String? = null,
        var productInfo: String? = null,
        var bestSeller: String? = null,
        var rateMark: BigDecimal? = null,
        var productPrice: BigDecimal? = null,
        var productImage: ImageView? = null
)