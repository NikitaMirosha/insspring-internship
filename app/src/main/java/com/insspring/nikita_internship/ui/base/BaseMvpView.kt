package com.delivery.ui.base

import moxy.MvpView

interface BaseMvpView : MvpView {
    fun showMessage(resId: Int)
    fun showMessage(msg: String?)
    fun hideKeyboard()
    fun handleRestError(e: Throwable)

    fun showProductCantBeReadyDueToTime()
}