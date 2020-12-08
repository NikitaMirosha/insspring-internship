package com.insspring.nikita_internship.productlist

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.model.ProductModel
import kotlinx.android.synthetic.main.activity_products_list.*
import moxy.MvpAppCompatActivity

class ProductsListActivity : MvpAppCompatActivity() {

    var vTbSearchProduct: Toolbar? = null
    var productsListModel: MutableList<ProductModel> = ArrayList()
    var productsNames = arrayOf("Orange", "Apple", "Lemon", "Pear")
    lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)

        updateImages()
        updateBottomNavigation()
        updateSearchToolbar()
        updateProductListView()

//        productsAdapter = ProductsAdapter(
//            itemClicked = {
//                onLocationItemSelected(it)
//        })

        for (i in productsNames) {
            val productsModel = ProductModel(i)
            productsListModel.add(productsModel)
        }

        productsAdapter = ProductsAdapter(productsListModel, itemClicked = {})
        //productsAdapter.setItems(productsListModel)
        vRvProductsList.adapter = productsAdapter
    }

    private fun onLocationItemSelected(it: ProductModel) {
        // ereretg
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
        Glide.with(this).load(R.drawable.ic_user_profile).placeholder(R.drawable.ic_user_profile)
            .into(vIvUserProfile)
        Glide.with(this).load(R.drawable.ic_dots_menu).placeholder(R.drawable.ic_dots_menu)
            .into(vIvDotsMenu)
        //Glide.with(this).load(R.drawable.ic_like_product_list).placeholder(R.drawable.ic_like_product_list).into(vIvLikeProductList)
    }

    fun updateBottomNavigation() {
        vBottomNavigation.background = null
    }

    fun updateSearchToolbar() {
        vTbSearchProduct = findViewById(R.id.vTbSearchProduct)
        setSupportActionBar(vTbSearchProduct)
        this.supportActionBar?.title = "Search..."
    }

    fun updateProductListView() {
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        vRvProductsList.layoutManager = linearLayoutManager
    }
}