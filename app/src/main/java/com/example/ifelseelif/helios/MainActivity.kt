package com.example.ifelseelif.helios

import android.os.Bundle
import android.widget.Button
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.ifelseelif.helios.R.string.enter
import com.example.ifelseelif.helios.mvp.views.LoginView

class MainActivity : MvpAppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
