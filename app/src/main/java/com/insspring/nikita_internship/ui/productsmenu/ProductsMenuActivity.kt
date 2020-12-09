package com.insspring.nikita_internship.ui.productsmenu

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.delivery.ui.base.BaseMvpActivity
import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.model.ProductModel
import com.insspring.nikita_internship.ui.product.ProductActivity
import com.insspring.nikita_internship.ui.productsmenu.adapter.ProductsMenuAdapter
import com.insspring.nikita_internship.ui.utils.SimpleTextWatcher
import kotlinx.android.synthetic.main.activity_products_menu.*

class ProductsMenuActivity : BaseMvpActivity(), ProductsMenuView {

    @InjectPresenter
    lateinit var productMenuPresenter: ProductsMenuPresenter

    lateinit var productsMenuAdapter: ProductsMenuAdapter

    override fun getLayoutId(): Int = R.layout.activity_products_menu

    override fun onCreateActivity(savedInstanceState: Bundle?) {

        initOnTextChangedListener()
        initProductListAdapter()
        updateBottomNavigation()

        productMenuPresenter.onCreate(productsMenuAdapter.clickEvent)
    }

    private fun initOnTextChangedListener() {
        vEtSearchProduct.addTextChangedListener(
            object : SimpleTextWatcher() {
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    productMenuPresenter.onTextChanged(s.toString())
                }
            }
        )
    }

    private fun initProductListAdapter() {
        productsMenuAdapter = ProductsMenuAdapter()
        vRvProductsList.adapter = productsMenuAdapter
    }

    override fun goToProductScreen(productModel: ProductModel) {
        startActivity(Intent(this, ProductActivity::class.java))
    }

    override fun updateProducts(products: List<ProductModel>) {
        productsMenuAdapter.setItems(products)
    }

    private fun updateBottomNavigation() {
        vBottomNavigation.background = null
    }

    override fun updateProductListView() {
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        vRvProductsList.layoutManager = linearLayoutManager
    }

    override fun updateImages() {
        Glide.with(this)
            .load(R.drawable.ic_user_profile)
            .placeholder(R.drawable.ic_user_profile)
            .into(vIvUserProfile)

        Glide.with(this)
            .load(R.drawable.ic_dots_menu)
            .placeholder(R.drawable.ic_dots_menu)
            .into(vIvDotsMenu)
    }
}
