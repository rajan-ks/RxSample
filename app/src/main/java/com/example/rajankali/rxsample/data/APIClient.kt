package com.example.rajankali.rxsample.data

import com.example.rajankali.rxsample.dto.User
import com.example.rajankali.rxsample.dto.UserResponse
import retrofit2.Call
import retrofit2.http.Query


/**
 * Created by rajan.kali on 7/25/2017.
 * Retro Client
 */
interface APIClient {

    @retrofit2.http.GET("api/users")
    fun query(@Query("page") page : Int): Call<UserResponse>

    /**
     * Companion object for the factory
     */
    companion object Factory {
        fun create(): APIClient {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .baseUrl("https://reqres.in/")
                    .build()

            return retrofit.create(APIClient::class.java);
        }
    }
}