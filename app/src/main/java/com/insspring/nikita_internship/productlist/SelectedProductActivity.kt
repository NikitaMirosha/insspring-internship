package com.insspring.nikita_internship.productlist

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.insspring.nikita_internship.R

class SelectedProductActivity : AppCompatActivity() {

    var vTvSelectedProduct: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_product)

        vTvSelectedProduct = findViewById(R.id.vTvSelectedProduct)
        val intent = intent

        if (intent.extras != null) {
            val userModel = intent.getSerializableExtra("data") as ProductsModel
            vTvSelectedProduct?.setText(userModel.productName)
        }
    }
}