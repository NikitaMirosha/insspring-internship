package com.delivery.ui.base

import androidx.annotation.StringRes
import moxy.MvpPresenter

abstract class BaseMvpPresenter<V : BaseMvpView> : MvpPresenter<V>() {

    protected fun showMessage(@StringRes text: Int) {
        viewState.showMessage(text)
    }

    protected fun showMessage(text: String) {
        viewState.showMessage(text)
    }
}
