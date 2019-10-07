package com.example.ifelseelif.helios.mvp.presentors

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.ifelseelif.helios.db.pojo.Person
import com.example.ifelseelif.helios.mvp.models.LoginModel
import com.example.ifelseelif.helios.mvp.views.LoginView
import com.example.ifelseelif.helios.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {

    private val service: RetrofitService = RetrofitService.create()
    private val model: LoginModel = LoginModel()

    fun onSubmit(code: String?) {
        viewState.showLoading()
        service.loginUp(code).enqueue(object : Callback<Person> {
            override fun onFailure(call: Call<Person>, t: Throwable) {
                viewState.showError()
            }

            override fun onResponse(call: Call<Person>, response: Response<Person>) {
                if (response.isSuccessful) {
                    model.saveTokens(response.body())
                    viewState.showNoLoading()
                    viewState.showSuccess()
                } else {
                    viewState.showNoLoading()
                }
            }
        })

    }
}


