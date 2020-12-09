package com.insspring.nikita_internship.repo

import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.model.ProductModel
import java.math.BigDecimal

class ProductRepo {

    fun getProduct(): ProductModel {
        return ProductModel(
            productId = 1,
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
            productPrice = BigDecimal.valueOf(19.99),
            productImage = null
        )
    }

    fun getAllProducts(): MutableList<ProductModel> {
        return mutableListOf(
            ProductModel(
                productId = 1,
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
                rateMark = BigDecimal(5.6),
                productPrice = BigDecimal(19.99),
                productImage = R.drawable.pic_orange
            ),

            ProductModel(
                productId = 2,
                productName = "Lemon",
                productInfo = "Lemon are tropical fruits that are actually some of the worlds" +
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
                rateMark = BigDecimal(7.6),
                productPrice = BigDecimal(16.99),
                productImage = R.drawable.pic_lemon
            ),

            ProductModel(
                productId = 3,
                productName = "Apple",
                productInfo = "Apple are tropical fruits that are actually some of the worlds" +
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
                bestSeller = "Good Products Ltd.",
                rateMark = BigDecimal(6.6),
                productPrice = BigDecimal(9.99),
                productImage = R.drawable.pic_apple
            ),

            ProductModel(
                productId = 4,
                productName = "Pear",
                productInfo = "Pear are tropical fruits that are actually some of the worlds" +
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
                bestSeller = "Sweet Items Ltd.",
                rateMark = BigDecimal(3.1),
                productPrice = BigDecimal(29.99),
                productImage = R.drawable.pic_orange
            )
        )
    }

    // лист из 4 объектов ProductModel
    // добавление в лист через apply
    // переписать getProduct на возврат продуктов через id

}