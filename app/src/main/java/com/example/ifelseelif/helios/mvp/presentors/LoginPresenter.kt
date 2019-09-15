package com.example.ifelseelif.helios.mvp.presentors

import android.text.Editable
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.ifelseelif.helios.mvp.views.LoginView
import com.example.ifelseelif.helios.network.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {

    var service: RetrofitService = RetrofitService.create()

    fun onSubmit(login: Editable?, password: Editable?) {

        CoroutineScope(Main).launch {
            viewState.showLoading()
            try {
                withContext(IO) {
                    val response = service.register(login, password)
                    withContext(Main) {
                        if (response.await().isSuccessful) {
                            viewState.showSuccess()
                        } else {
                            viewState.showError()
                        }
                        viewState.showNoLoading()
                    }
                }
            } catch (e: Throwable) {
                e.printStackTrace()
                viewState.showToast("smth wrong")
                viewState.showNoLoading()
            }
        }
    }


}