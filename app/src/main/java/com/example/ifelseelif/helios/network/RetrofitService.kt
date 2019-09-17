package com.example.ifelseelif.helios.network

import android.text.Editable
import com.example.ifelseelif.helios.db.pojo.Person
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("/api/auth")
    fun loginUp(
        @Query("login") login: Editable?,
        @Query("password") password: Editable?
    ): Deferred<Response<Person>>

    companion object {
        fun create(): RetrofitService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(RetrofitService::class.java)
        }

        private const val BASE_URL = "https://helios-service.herokuapp.com"
    }
}