package com.example.ifelseelif.helios

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.ifelseelif.helios.mvp.views.LoginView

class MainActivity : MvpAppCompatActivity(), LoginView{
    override fun showErrorPassword() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorLogin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginByVK() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginByGoogle() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun forgotPassword() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
