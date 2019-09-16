package com.example.ifelseelif.helios.ui

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.ifelseelif.helios.R

class MainActivity : MvpAppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}
