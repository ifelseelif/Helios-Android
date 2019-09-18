package com.example.ifelseelif.helios.mvp.presentors

import android.text.Editable
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.ifelseelif.helios.mvp.models.LoginModel
import com.example.ifelseelif.helios.mvp.views.LoginView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {

    private val model : LoginModel = LoginModel()

    fun onSubmit(login: Editable?, password: Editable?) {

        CoroutineScope(Main).launch {
            viewState.showLoading()
            try {
                withContext(IO) {
                    val response = model.loginUp(login, password)
                    withContext(Main) {
                        if (response.isSuccessful) {
                            viewState.showSuccess()
                            model.saveTokens(response.body())
                        } else {
                            viewState.showError()
                        }
                        viewState.showNoLoading()
                    }
                }
            } catch (e: Throwable) {
                viewState.showToast("smth wrong")
                viewState.showNoLoading()
            }
        }
    }

    fun containsToken(){
        CoroutineScope(IO).launch {
            if(model.isHaveToken()){
                viewState.showSuccess()
            }
        }
    }



}