package com.randalljuan.proyecto3_mobile_b95212_b97452.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.6/apiLocalhost/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

//192.168.0.5