package com.randalljuan.proyecto3_mobile_b95212_b97452.data.service

import android.content.Context
import android.util.Log
import com.randalljuan.proyecto3_mobile_b95212_b97452.core.RetrofitHelper
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.ResponseModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view.MenuActivity
import com.randalljuan.proyecto3_mobile_b95212_b97452.utility.Utils
import okhttp3.RequestBody
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class LoginService {

    private val retrofit = RetrofitHelper.getRetrofit()

    fun validatePatientLogIn(requestBody: RequestBody, context: Context) {
        val call =
            retrofit.create(DigitalHealthApiClient::class.java).validatePatientLogin(requestBody)
        call.enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if (response.body()?.value!!) {
                    Utils.startActivity(context, MenuActivity::class.java)
                } else {
                    Utils.showToast(context, "User not found")
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Log.d("FAILURE:", t.cause.toString() + "  " + t.message + "  " + t.localizedMessage)
            }
        })
    }
}