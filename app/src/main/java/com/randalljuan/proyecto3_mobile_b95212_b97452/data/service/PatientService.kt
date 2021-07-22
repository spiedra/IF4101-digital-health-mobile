package com.randalljuan.proyecto3_mobile_b95212_b97452.data.service

import android.content.Context
import android.util.Log
import com.randalljuan.proyecto3_mobile_b95212_b97452.core.RetrofitHelper
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.PatientModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.ResponseModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.utility.Utils
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PatientService {

    private val retrofit = RetrofitHelper.getRetrofit()

    fun getPersonalInformation(idCard: String) {
        val call =
            retrofit.create(DigitalHealthApiClient::class.java).getPersonalInformation(idCard)
        call.enqueue(object : Callback<PatientModel> {
            override fun onResponse(call: Call<PatientModel>, response: Response<PatientModel>) {
                if (response.code() == 200) {
                    val patientInfo = response.body()!!
                    patientInfo.idCard?.let { Log.d("Pretty Printed JSON :", it) }
                } else {
                    Log.d("Pretty Printed JSON else:", "f")
                }
            }

            override fun onFailure(call: Call<PatientModel>, t: Throwable) {
                Log.d("FAILURE:", t.cause.toString() + "  " + t.message + "  " + t.localizedMessage)
            }
        })
    }

    fun signUp(requestBody: RequestBody, context: Context) {
        val call =
            retrofit.create(DigitalHealthApiClient::class.java).signUpPatient(requestBody)
        call.enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if (response.body()?.value!!) {
                    Utils.showToast(context, "Successfully registered")
                } else {
                    Utils.showToast(context, "ID Card already exists")
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Log.d("FAILURE:", t.cause.toString() + "  " + t.message + "  " + t.localizedMessage)
            }
        })
    }

    fun updatePatien(requestBody: RequestBody, context: Context) {
        val call =
            retrofit.create(DigitalHealthApiClient::class.java)
                .updatePersonalInformation(requestBody)
        call.enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if (response.body()?.value!!) {
                    Utils.showToast(context, "Successfully updated")
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Log.d("FAILURE:", t.cause.toString() + "  " + t.message + "  " + t.localizedMessage)
            }
        })
    }
}