package com.insspring.nikita_internship.repo

import com.insspring.nikita_internship.model.ProductModel
import java.math.BigDecimal

class ProductRepo {

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
            productPrice = BigDecimal.valueOf(19.99)
        )
    }

    // getAllProducts()
    // лист из 4 объектов ProductModel
    // добавление в лист через apply
    // переписать getProduct на возврат продуктов через id
    // добавить в ProductModel id (int)

}