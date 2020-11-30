package orangeapplication.main.repository

import orangeapplication.main.model.ProductModel

class ProductRepo {

    // context

    fun getProduct(): ProductModel {

        return ProductModel(
                productName = "About Orange",
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
                bestSeller = "Best Seller: Sweet Products Ltd.",
                price = "$16.55")
    }

}