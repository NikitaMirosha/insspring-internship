package com.insspring.nikita_internship.ui.productsmenu

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.delivery.ui.base.BaseMvpActivity
import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.model.ProductModel
import com.insspring.nikita_internship.ui.addtobag.AddToBagActivity
import com.insspring.nikita_internship.ui.product.ProductActivity
import com.insspring.nikita_internship.ui.productsmenu.adapter.ProductsMenuAdapter
import kotlinx.android.synthetic.main.activity_products_menu.*

class ProductsMenuActivity : BaseMvpActivity() {

    var productsListModel: MutableList<ProductModel> = ArrayList()
    var productsNames = arrayOf("Orange", "Apple", "Lemon", "Pear")
    lateinit var productsMenuAdapter: ProductsMenuAdapter

    override fun getLayoutId(): Int = R.layout.activity_products_menu

    override fun onCreateActivity(savedInstanceState: Bundle?) {

        updateImages()
        updateBottomNavigation()
        updateProductListView()

        initListener()

        // fix
        vSvSearchProduct.setBackgroundColor(Color.RED)

        for (i in productsNames) {
            val productModel = ProductModel(i)
            productsListModel.add(productModel)
        }

        productsMenuAdapter = ProductsMenuAdapter(productsListModel, itemClicked = {
            onLocationItemSelected(it)
        })
        vRvProductsList.adapter = productsMenuAdapter
    }

    private fun onLocationItemSelected(it: ProductModel) {
        val intent = Intent(this, ProductActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scroll_products, menu)
        val menuItem = menu.findItem(R.id.vSvSearch)
        val searchView = menuItem.actionView as SearchView
        searchView.maxWidth = Int.MAX_VALUE
        return true
    }

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
}
