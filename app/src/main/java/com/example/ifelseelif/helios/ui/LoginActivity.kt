package com.example.ifelseelif.helios.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.example.ifelseelif.helios.R
import com.example.ifelseelif.helios.core.UrlsHolder
import com.example.ifelseelif.helios.mvp.presentors.LoginPresenter
import com.example.ifelseelif.helios.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : MvpAppCompatActivity(), LoginView {


    override fun showError() {
        Log.i("bad", "1")
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showNoLoading() {
        progressBar.visibility = View.INVISIBLE
    }


    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var presenter: LoginPresenter

    override fun showSuccess() {
        Log.i("good", "1")
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
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                showToast("No application can handle this request Please install a webbrowser")
            }
        }
    }


}


