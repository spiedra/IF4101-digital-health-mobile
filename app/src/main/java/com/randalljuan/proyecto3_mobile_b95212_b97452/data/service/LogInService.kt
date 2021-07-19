package com.randalljuan.proyecto3_mobile_b95212_b97452.data.service

import com.randalljuan.proyecto3_mobile_b95212_b97452.core.RetrofitHelper
import okhttp3.RequestBody

class LogInService {

    private val retrofit = RetrofitHelper.getRetrofit()

    fun checksCredentials(requestBody: RequestBody): String {
        val response = retrofit.create(DigitalHealthApiClient::class.java).validatePatientLogin(requestBody)
        return response.body()?: String()
    }
}