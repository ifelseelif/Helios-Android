package com.example.ifelseelif.helios

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.ifelseelif.helios.core.UrlsHolder
import com.example.ifelseelif.helios.mvp.presentors.LoginPresenter
import com.example.ifelseelif.helios.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : MvpAppCompatActivity(), LoginView {
    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showNoLoading() {
        progressBar.visibility = View.INVISIBLE
    }

    @InjectPresenter
    lateinit var presenter: LoginPresenter

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

    override fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button.setOnClickListener {
            presenter.onSubmit(loginInput.text, passwordInput.text)
        }

        helpHelios.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(UrlsHolder.getHelpHelios()))
            if( intent.resolveActivity(packageManager) != null ){
                startActivity(intent)
            } else {
                showToast("No application can handle this request Please install a webbrowser")
            }
        }
    }




}


