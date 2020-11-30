package orangeapplication.main.repository

import orangeapplication.main.model.ProductModel
import java.math.BigDecimal

class ProductRepo {

    // context
    fun getProduct(): ProductModel {
        return ProductModel(
            productName = "Orange",
            productInfo = "Oranges are tropical fruits that are actually some of the worlds" +
                    " most popular. There are different types of oranges, ranging from sweet to bitter." +
                    " Each type belongs to the citrus family of fruits and grows on trees." +
                    " Oranges are tropical fruits that are actually some of the worlds" +
                    " most popular. There are different types of oranges, ranging from sweet to bitter." +
                    " Each type belongs to the citrus family of fruits and grows on trees." +
                    " Oranges are tropical fruits that are actually some of the worlds" +
                    " most popular. There are different types of oranges, ranging from sweet to bitter." +
                    " Each type belongs to the citrus family of fruits and grows on trees." +
                    " Oranges are tropical fruits that are actually some of the worlds" +
                    " most popular. There are different types of oranges, ranging from sweet to bitter." +
                    " Each type belongs to the citrus family of fruits and grows on trees.\n\n ",
            bestSeller = "Sweet Products Ltd.",
            rateMark = BigDecimal.valueOf(5.6),
            price = BigDecimal.valueOf(19.99)
        )
    }

}