package com.test.data.remote

import com.test.common.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
    companion object{
        val client=OkHttpClient()
        val retrofit:Retrofit=Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        fun getPaprikaApi():CoinPaprikaApi{
            return retrofit.create(CoinPaprikaApi::class.java)
        }
    }
}