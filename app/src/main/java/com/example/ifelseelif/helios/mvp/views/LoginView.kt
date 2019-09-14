package com.example.ifelseelif.helios.mvp.views

import com.arellomobile.mvp.MvpView

interface LoginView : MvpView {
    fun showError()

    fun showSuccess()

    fun loginByVK()
    fun loginByGoogle()

    fun forgotPassword()

    fun showToast(text: String)

    fun showLoading()
    fun showNoLoading()

}