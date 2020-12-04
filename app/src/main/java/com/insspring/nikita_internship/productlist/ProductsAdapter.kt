package com.insspring.nikita_internship.productlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.insspring.nikita_internship.R
import com.insspring.nikita_internship.productlist.ProductsAdapter.UsersAdapterVh
import java.util.*

class ProductsAdapter(
    private var productsModelList: List<ProductsModel>,
    selectedProduct: SelectedProduct
) : RecyclerView.Adapter<UsersAdapterVh>(), Filterable {
    private val getProductsModelListFiltered: List<ProductsModel>
    private var context: Context? = null
    private val selectedProduct: SelectedProduct
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapterVh {
        context = parent.context
        return UsersAdapterVh(
            LayoutInflater.from(context).inflate(R.layout.activity_products_scroll, null)
        )
    }

    override fun onBindViewHolder(holder: UsersAdapterVh, position: Int) {
        val (username) = productsModelList[position]
        val prefix = username.substring(0, 1)
        holder.tvUsername.text = username
        holder.tvPrefix.text = prefix
    }

    override fun getItemCount(): Int {
        return productsModelList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val filterResults = FilterResults()
                // (charSequence == null | charSequence.length() == 0)
                if ((charSequence == null) or (charSequence.length == 0)) {
                    filterResults.count = getProductsModelListFiltered.size
                    filterResults.values = getProductsModelListFiltered
                } else {
                    val searchChr = charSequence.toString().toLowerCase()
                    val resultData: MutableList<ProductsModel> = ArrayList<ProductsModel>()
                    for (userModel in getProductsModelListFiltered) {
                        if (userModel.productName.toLowerCase().contains(searchChr)) {
                            resultData.add(userModel)
                        }
                    }
                    filterResults.count = resultData.size
                    filterResults.values = resultData
                }
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                productsModelList = filterResults.values as List<ProductsModel>
                notifyDataSetChanged()
            }
        }
    }

    interface SelectedProduct {
        fun selectedProduct(productsModel: ProductsModel?)
    }

    inner class UsersAdapterVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvPrefix: TextView
        var tvUsername: TextView

        init {
            tvPrefix = itemView.findViewById(R.id.vTvPrefixCard)
            tvUsername = itemView.findViewById(R.id.vTvProductNameCard)
            itemView.setOnClickListener {
                selectedProduct.selectedProduct(
                    productsModelList[adapterPosition]
                )
            }
        }
    }

    init {
        getProductsModelListFiltered = productsModelList
        this.selectedProduct = selectedProduct
    }
}