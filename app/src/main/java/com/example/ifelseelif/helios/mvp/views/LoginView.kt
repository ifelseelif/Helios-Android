package com.example.ifelseelif.helios.mvp.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface LoginView : MvpView {

    fun showError()
    fun showSuccess()

    fun showToast(text: String)

    fun showLoading()
    fun showNoLoading()

}