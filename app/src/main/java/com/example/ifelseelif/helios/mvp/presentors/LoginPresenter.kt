package com.example.ifelseelif.helios.mvp.presentors

import android.text.Editable
import com.arellomobile.mvp.MvpPresenter
import com.example.ifelseelif.helios.mvp.views.LoginView
import com.example.ifelseelif.helios.network.RetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginPresenter : MvpPresenter<LoginView>() {



    fun  onSubmit(login: Editable?, password: Editable?) {
        val service = RetrofitFactory.makeRetrofitService()
        CoroutineScope(IO).launch {
            withContext(Main){
                viewState.showLoading()
            }
            try {
                val response = service.register(login, password)
            }catch (e : Throwable){
                withContext(Main){
                    viewState.showToast("smth wrong")
                }
            }

            withContext(Main){
                viewState.showNoLoading()
                if(response.isSuccessful){
                    viewState.showSuccess()
                } else {
                    viewState.showError()
                }
            }
        }
    }


}