package com.insspring.nikita_internship.productlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.insspring.nikita_internship.R

class Adapter : PagerAdapter {

    private lateinit var models: List<TestModel>
    private lateinit var layoutInflater: LayoutInflater
    private lateinit var context: Context

    constructor(models: List<TestModel>, context: Context) : super() {
        this.models = models
        this.context = context
    }


    override fun getCount(): Int {
        return models.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        var view: View = layoutInflater.inflate(R.layout.item, container, false)

        var imageView: ImageView
        var title: TextView
        var desc: TextView

        imageView = view.findViewById(R.id.image)
        title = view.findViewById(R.id.title)
        desc = view.findViewById(R.id.desc)

        models.get(position).image?.let { imageView.setImageResource(it) }
        title.text = models.get(position).title
        desc.text = models.get(position).desc

        container.addView(view, 0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}