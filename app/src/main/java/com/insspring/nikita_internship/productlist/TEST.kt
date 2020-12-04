package com.insspring.nikita_internship.productlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.insspring.nikita_internship.R
import kotlinx.android.synthetic.main.activity_t_e_s_t.*

class TEST : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t_e_s_t)
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false
    }
}