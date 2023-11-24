package com.test.data.remote

import com.test.common.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
        private val client=OkHttpClient()
        private val retrofit:Retrofit=Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        fun <T> buildWebService(webService:Class<T>): T{
                return retrofit.create(webService)
        }
}