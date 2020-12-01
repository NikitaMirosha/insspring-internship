package com.insspring.nikita_internship.productlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.insspring.nikita_internship.R
import kotlinx.android.synthetic.main.activity_product_cards.view.*

class ProductAdapter(val posts: ArrayList<String>) :
    RecyclerView.Adapter<ProductAdapter.PostsViewHolder>() {

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.username.text = posts[position]
    }

    override fun getItemCount() = posts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_product_cards, parent, false)
        return PostsViewHolder(view)
    }

    class PostsViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val username: TextView = itemview.vTvCardTitle
    }
}