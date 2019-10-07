package com.example.ifelseelif.helios.network

import com.example.ifelseelif.helios.db.pojo.Person
import com.example.ifelseelif.helios.db.pojo.UserDetails
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("api/oauth")
    fun loginUp(
        @Query("authorization_code") code: String?
    ): Call<Person>


    @GET("/api/user")
    fun getUserDetails(@Query("access_token") access_token: String): Deferred<Response<UserDetails>>

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