package com.test.data.remote

import com.test.common.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager(baseUrl:String) {
        private val retrofit:Retrofit by lazy {
                Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(OkHttpClient())
                        .build()
        }
        fun <T> buildWebService(webService:Class<T>): T{
                return retrofit.create(webService)
        }
}