package com.example.ifelseelif.helios.mvp.models

import com.example.ifelseelif.helios.db.AppDatabase
import com.example.ifelseelif.helios.db.PersonDao
import com.example.ifelseelif.helios.db.pojo.Person
import com.example.ifelseelif.helios.service.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LoginModel {


    private val personDao: PersonDao =
        AppDatabase.getInstance(App.applicationContext()).getPersonDao()

    fun saveTokens(body: Person?) {
        CoroutineScope(IO).launch {
            deleteAllTokens()
            if (body != null) {
                personDao.insert(body)
            }
        }
    }

    private fun deleteAllTokens() {
        personDao.deleteAll(personDao.getInfo())
    }

}

