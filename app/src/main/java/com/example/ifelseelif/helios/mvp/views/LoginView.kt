package com.example.ifelseelif.helios.mvp.views

import com.arellomobile.mvp.MvpView

interface LoginView : MvpView {
    fun showErrorPassword()
    fun showErrorLogin()

    fun showSuccess()

    fun loginByVK()
    fun loginByGoogle()

    fun forgotPassword()

}