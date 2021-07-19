package com.randalljuan.proyecto3_mobile_b95212_b97452.data.service

import android.util.Log
import com.google.gson.GsonBuilder
import com.randalljuan.proyecto3_mobile_b95212_b97452.core.RetrofitHelper

class AppointmentService {

    private val retrofit = RetrofitHelper.getRetrofit()

    fun getAppointments(idCard: String){
        val service = retrofit.create(DigitalHealthApiClient::class.java)
        val response = service.getAppointmentByCard(idCard)

        if(response.isSuccessful){
            val gson = GsonBuilder().setPrettyPrinting().create()
            val prettyJson = gson.toJson(
                    response.body()
                        ?.string() // About this thread blocking annotation : https://github.com/square/retrofit/issues/3255

            )
            Log.d("Pretty Printed JSON :", prettyJson)
        }
    }
}