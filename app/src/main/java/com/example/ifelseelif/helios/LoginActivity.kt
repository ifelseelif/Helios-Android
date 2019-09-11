package com.example.ifelseelif.helios

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button.setOnClickListener {
            println(1)
        }

        helpHelios.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(R.string.helpHelios.toString()))
            startActivity(intent)
        }
    }


}
