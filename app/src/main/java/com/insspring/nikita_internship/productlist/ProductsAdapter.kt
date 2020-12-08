package com.insspring.nikita_internship.productlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.delivery.ui.base.baseadapter.BaseListAdapter
import com.delivery.ui.base.baseadapter.BaseViewHolder
import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.model.ProductModel
import java.util.*

class ProductsAdapter(
    private var productsModelList: List<ProductModel>,
    var itemClicked: (ProductModel) -> Unit
) : BaseListAdapter<ProductModel>(), Filterable {
    private val getProductsModelListFiltered: List<ProductModel>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ProductModel> {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false),
            itemClicked
        )
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val filterResults = FilterResults()

                if ((charSequence == null) or (charSequence.length == 0)) {
                    filterResults.count = getProductsModelListFiltered.size
                    filterResults.values = getProductsModelListFiltered
                } else {
                    val searchCharSequence = charSequence.toString().toLowerCase(Locale.ROOT)
                    val resultData: MutableList<ProductModel> = ArrayList<ProductModel>()
                    for (productModel in getProductsModelListFiltered) {
                        if (productModel.productName?.toLowerCase(Locale.ROOT)
                                ?.contains(searchCharSequence) == true
                        ) {
                            resultData.add(productModel)
                        }
                    }
                    filterResults.count = resultData.size
                    filterResults.values = resultData
                }
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                productsModelList = filterResults.values as List<ProductModel>

            }
        }
    }

    init {
        getProductsModelListFiltered = productsModelList
    }
}