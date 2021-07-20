package com.randalljuan.proyecto3_mobile_b95212_b97452.data.service

import android.util.Log
import android.widget.Toast
import com.google.gson.GsonBuilder
import com.randalljuan.proyecto3_mobile_b95212_b97452.core.RetrofitHelper
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.PatientModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PatientService {

    private val retrofit = RetrofitHelper.getRetrofit()

    fun getPersonalInformation(idCard: String) {
        val service = retrofit.create(DigitalHealthApiClient::class.java)
        val call = service.getPersonalInformation()
        Log.d("Pretty Printed JSON jaja:", "f")
        call.enqueue(object : Callback<List<PatientModel>>{
            override fun onResponse(call: Call<List<PatientModel>>, response: Response<List<PatientModel>>) {
                if(response.code() == 200){
                    val patientInfo = response.body()!!
                    patientInfo[0].idCard?.let { Log.d("Pretty Printed JSON :", it) }
                }else{
                    Log.d("Pretty Printed JSON else:", "f")
                }
            }
            override fun onFailure(call: Call<List<PatientModel>>, t: Throwable) {
                Log.d("Pretty Printed JSON FAILURE:", t.cause.toString() + "  "+ t.message + "  "+t.localizedMessage)
            }
        })
    }
}