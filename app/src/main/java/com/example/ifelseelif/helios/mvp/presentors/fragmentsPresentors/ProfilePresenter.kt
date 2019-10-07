package com.example.ifelseelif.helios.mvp.presentors.fragmentsPresentors

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.ifelseelif.helios.db.AppDatabase
import com.example.ifelseelif.helios.db.PersonDao
import com.example.ifelseelif.helios.mvp.views.fragments.ProfileFragmentView
import com.example.ifelseelif.helios.network.RetrofitService
import com.example.ifelseelif.helios.service.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@InjectViewState
class ProfilePresenter : MvpPresenter<ProfileFragmentView>() {
    private val service: RetrofitService = RetrofitService.create()
    private val personDao: PersonDao =
        AppDatabase.getInstance(App.applicationContext()).getPersonDao()
    fun onRefresh() {
        CoroutineScope(Dispatchers.IO).launch {
            Log.e("1", service.getUserDetails(personDao.getInfo()[0].accessToken).toString())
            personDao.deleteAll(personDao.getInfo())

        }
    }


}