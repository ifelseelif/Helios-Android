package com.example.ifelseelif.helios.mvp.models

import android.text.Editable
import com.example.ifelseelif.helios.App
import com.example.ifelseelif.helios.db.AppDatabase
import com.example.ifelseelif.helios.db.PersonDao
import com.example.ifelseelif.helios.db.pojo.Person
import com.example.ifelseelif.helios.network.RetrofitService
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginModel {

    private val service: RetrofitService = RetrofitService.create()
    private val personDao: PersonDao =
        AppDatabase.getInstance(App.applicationContext()).getPersonDao()

    suspend fun loginUp(login: Editable?, password: Editable?): Response<Person> {
        return service.loginUp(login, password).await()
    }

    suspend fun saveTokens(body: Person?) {
        withContext(IO) {
            if (body != null) {
                personDao.insert(body)
            }
        }
    }

    fun isHaveToken(): Boolean {
        return personDao.getInfo().isNotEmpty()
    }

}

