package com.insspring.nikita_internship

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.insspring.nikita_internship.R.*
import kotlinx.android.synthetic.main.activity_main.*
import orangeapplication.main.model.ProductModel
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import orangeapplication.main.back.BackActivity
import orangeapplication.main.view.ProductView
import presenter.ProductPresenter

class MainActivity : MvpAppCompatActivity(), ProductView {

    @InjectPresenter // аннотация для получения экземпляра Presenter
    lateinit var productPresenter: ProductPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        initListener()

    }

    private fun initListener() {
        val backBtn = findViewById<ImageView>(id.vIvBackArrow)
        backBtn.setOnClickListener { openBackActivity() }

    }

    private fun openBackActivity() {
        val intent = Intent(this, BackActivity::class.java)
        startActivity(intent)

    }

    override fun updateProduct(product: ProductModel) {
        val spannableBestSeller = SpannableString(product.bestSeller ?: "")
        spannableBestSeller.setSpan(StyleSpan(Typeface.BOLD), 0, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        vTvProductName.text = product.productName ?: ""
        vTvProductInfo.text = product.productInfo ?: ""
        vTvBestSeller.text = spannableBestSeller
        vTvPrice.text = product.price ?: ""

        val tagModel = "Product Model: "
        Log.d(tagModel, product.toString())
    }

    override fun updateImage() {
        vIvBackArrow.setImageDrawable(ContextCompat.getDrawable(this, drawable.ic_arrow))
        vIvHeart.setImageDrawable(ContextCompat.getDrawable(this, drawable.ic_heart))
        vIvBag.setImageDrawable(ContextCompat.getDrawable(this, drawable.ic_bag))
        vIvUserOne.setImageDrawable(ContextCompat.getDrawable(this, drawable.ic_user))
        vIvUserTwo.setImageDrawable(ContextCompat.getDrawable(this, drawable.ic_user))
        vIvUserThree.setImageDrawable(ContextCompat.getDrawable(this, drawable.ic_user))
        vIvStar.setImageDrawable(ContextCompat.getDrawable(this, drawable.ic_star))

    }

}
