package com.insspring.nikita_internship.productlist

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.internal.ContextUtils.getActivity
import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.productlist.ProductsAdapter.SelectedProduct
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.activity_products_list.*
import kotlinx.android.synthetic.main.activity_products_list.vBottomNavigation

class ProductsListActivity : AppCompatActivity(), SelectedProduct {

    var vTbSearchProduct: Toolbar? = null
    var vRvProductsList: RecyclerView? = null
    var productsListModel: MutableList<ProductsModel> = ArrayList()
    var productsNames = arrayOf("Orange", "Apple", "Lemon", "Pear")
    var productsAdapter: ProductsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)

        updateImages()
        updateBottomNavigation()
        updateSearchToolbar()
        updateProductListView()

        for (i in productsNames) {
            val productsModel = ProductsModel(i)
            productsListModel.add(productsModel)
        }

        productsAdapter = ProductsAdapter(productsListModel, this)
        vRvProductsList?.setAdapter(productsAdapter)
    }

    override fun selectedProduct(productsModel: ProductsModel?) {
        startActivity(
            Intent(
                this@ProductsListActivity,
                SelectedProductActivity::class.java
            )
                .putExtra("data", productsModel)
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scroll_products, menu)
        val menuItem = menu.findItem(R.id.vSvSearch)
        val searchView = menuItem.actionView as SearchView
        searchView.maxWidth = Int.MAX_VALUE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newSearchText: String): Boolean {
                productsAdapter?.filter?.filter(newSearchText)
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        val menuItemId = menuItem.itemId
        return if (menuItemId == R.id.vSvSearch) {
            true
        } else super.onOptionsItemSelected(menuItem)
    }

    fun updateImages() {
        Glide.with(this).load(R.drawable.ic_user_profile).placeholder(R.drawable.ic_user_profile).into(vIvUserProfile)
        Glide.with(this).load(R.drawable.ic_dots_menu).placeholder(R.drawable.ic_dots_menu).into(vIvDotsMenu)
    }

    fun updateBottomNavigation() {
        vBottomNavigation.background = null
        vBottomNavigation.menu.getItem(2).isEnabled = false
    }

    fun updateSearchToolbar() {
        vTbSearchProduct = findViewById(R.id.vTbSearchProduct)
        setSupportActionBar(vTbSearchProduct)
        this.supportActionBar?.title = "Search..."
    }

    fun updateProductListView() {
        vRvProductsList = findViewById(R.id.vRvProductsList)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        vRvProductsList?.layoutManager = linearLayoutManager
    }
}