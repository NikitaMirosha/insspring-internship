package com.insspring.nikita_internship.ui.productsmenu

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.delivery.ui.base.BaseMvpActivity
import com.insspring.nikita_internship.ui.utils.SimpleTextWatcher
import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.model.ProductModel
import com.insspring.nikita_internship.ui.addtobag.AddToBagActivity
import com.insspring.nikita_internship.ui.product.ProductActivity
import com.insspring.nikita_internship.ui.productsmenu.adapter.ProductsMenuAdapter
import kotlinx.android.synthetic.main.activity_products_menu.*

class ProductsMenuActivity : BaseMvpActivity(), ProductMenuView {


    lateinit var productsMenuAdapter: ProductsMenuAdapter

    override fun getLayoutId(): Int = R.layout.activity_products_menu

    @InjectPresenter
    lateinit var productMenuPresenter: ProductMenuPresenter

    override fun onCreateActivity(savedInstanceState: Bundle?) {

        updateImages()
        updateBottomNavigation()
        updateProductListView()

        initListener()
        initOnTextChangedListener()



        // presenter
        productsMenuAdapter = ProductsMenuAdapter(itemClicked = {
            onLocationItemSelected(it)
        })
        vRvProductsList.adapter = productsMenuAdapter
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

    private fun onLocationItemSelected(it: ProductModel) {
        val intent = Intent(this, ProductActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scroll_products, menu)
        return true
    }

    // потавить private
    // delete
    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        val menuItemId = menuItem.itemId
        return if (menuItemId == R.id.vSvSearch) {
            true
        } else super.onOptionsItemSelected(menuItem)
    }

    fun updateImages() {
        Glide.with(this).load(R.drawable.ic_user_profile).placeholder(R.drawable.ic_user_profile)
            .into(vIvUserProfile)
        Glide.with(this).load(R.drawable.ic_dots_menu).placeholder(R.drawable.ic_dots_menu)
            .into(vIvDotsMenu)
    }

    fun updateBottomNavigation() {
        vBottomNavigation.background = null
    }

    fun updateProductListView() {
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        vRvProductsList.layoutManager = linearLayoutManager
    }

    private fun initListener() {
        vFabAddToBag.setOnClickListener {
            addToBagActivity()
        }
    }

    private fun addToBagActivity() {
        val intent = Intent(this, AddToBagActivity::class.java)
        startActivity(intent)
    }

    override fun updateProducts(products: List<ProductModel>) {
        productsMenuAdapter.setItems(products)
    }
}
