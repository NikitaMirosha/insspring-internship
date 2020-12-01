package com.insspring.nikita_internship.productlist

import android.animation.ArgbEvaluator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.insspring.nikita_internship.R


class ProductListActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var adapter: Adapter
    lateinit var models: List<TestModel>
    var colors: Array<Int>? = null
    var argbEvaluator = ArgbEvaluator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        models = ArrayList()
        (models as ArrayList<TestModel>).add(
            TestModel(
                R.drawable.pic_orange,
                "Orange",
                "This is Orange"
            )
        )
        (models as ArrayList<TestModel>).add(
            TestModel(
                R.drawable.pic_lemon,
                "Lemon",
                "This is Lemon"
            )
        )
        (models as ArrayList<TestModel>).add(
            TestModel(
                R.drawable.pic_apple,
                "Apple",
                "This is Apple"
            )
        )
        (models as ArrayList<TestModel>).add(
            TestModel(
                R.drawable.pic_orange,
                "Orange Again",
                "This is Orange Again"
            )
        )

        adapter = Adapter(models, this)
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = adapter
        viewPager.setPadding(130, 0, 130, 0)

        val colors_temp = arrayOf(
            resources.getColor(R.color.colorGray),
            resources.getColor(R.color.colorPrimaryDark),
            resources.getColor(R.color.colorOrange),
            resources.getColor(R.color.colorWhite)
        )

        colors = colors_temp

        viewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (position < (adapter.getCount() - 1) && position < (colors!!.size - 1)) {
                    viewPager.setBackgroundColor(
                        argbEvaluator.evaluate(
                            positionOffset,
                            colors?.get(position),
                            colors?.get(position + 1)
                        ) as Int
                    )
                } else {
                    viewPager.setBackgroundColor(colors!![colors!!.size - 1])
                }
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })

    }
}