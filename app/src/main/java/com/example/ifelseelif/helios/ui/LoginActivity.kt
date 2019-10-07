package com.example.ifelseelif.helios.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.example.ifelseelif.helios.R
import com.example.ifelseelif.helios.mvp.presentors.LoginPresenter
import com.example.ifelseelif.helios.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : MvpAppCompatActivity(), LoginView {

    val redirectUri: String = "heliosmobile://callback"

    override fun showError() {
        errorTextView.visibility = View.VISIBLE
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showNoLoading() {
        progressBar.visibility = View.INVISIBLE
    }

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var presenter: LoginPresenter

    override fun showSuccess() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()

        val uri = intent.data

        if (uri != null) {
            presenter.onSubmit(uri.getQueryParameter("authorization_code"))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        button.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW, Uri.parse(
                    "https://helios-service.herokuapp.com/html/external/login.html?" +
                            "redirect_uri=" + redirectUri
                )
            )
            startActivity(intent)
            errorTextView.visibility = View.INVISIBLE
        }

        helpHelios.setOnClickListener {
            errorTextView.visibility = View.INVISIBLE
            intent =
                Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://itmo-helios.herokuapp.com/external/login.html"))
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                showToast("No application can handle this request Please install a webbrowser")
            }
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }

}


