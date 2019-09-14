package com.example.ifelseelif.helios.network

import android.text.Editable
import android.widget.EditText
import com.example.ifelseelif.helios.dataBase.pojo.Person
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("/api/auth")
    fun register(
        @Query("login")  login : Editable?,
        @Query("password")  password : Editable?
    ) : Response<Person>

}