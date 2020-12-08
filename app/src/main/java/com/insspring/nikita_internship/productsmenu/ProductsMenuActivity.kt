package com.insspring.nikita_internship.productsmenu

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.model.ProductModel
import com.insspring.nikita_internship.selectedproduct.SelectedProductActivity
import kotlinx.android.synthetic.main.activity_products_menu.*
import moxy.MvpAppCompatActivity

class ProductsMenuActivity : MvpAppCompatActivity() {

    var productsListModel: MutableList<ProductModel> = ArrayList()
    var productsNames = arrayOf("Orange", "Apple", "Lemon", "Pear")
    lateinit var productsMenuAdapter: ProductsMenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_menu)

        updateImages()
        updateSearchToolbar()
        updateBottomNavigation()
        updateProductListView()

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
        val intent = Intent(this, SelectedProductActivity::class.java)
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
//        Glide.with(this).load(R.drawable.ic_like_product_list)
//            .placeholder(R.drawable.ic_like_product_list).into(vIvLikeProductList)
    }

    fun updateSearchToolbar() {
        setSupportActionBar(vTbSearchProduct)
        this.supportActionBar?.title = "Search..."
    }

    fun updateBottomNavigation() {
        vBottomNavigation.background = null
    }

    fun updateProductListView() {
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        vRvProductsList.layoutManager = linearLayoutManager
    }
}