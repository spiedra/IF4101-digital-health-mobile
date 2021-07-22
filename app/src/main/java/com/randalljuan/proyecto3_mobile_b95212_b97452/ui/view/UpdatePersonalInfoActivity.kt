package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.core.RetrofitHelper
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.PatientModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.service.DigitalHealthApiClient
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.service.PatientService
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdatePersonalInfoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnUpdate: Button
    private lateinit var tvCivilStatus: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvPhone1: TextView
    private lateinit var tvPhone2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_personal_info)
        btnUpdate = findViewById(R.id.btn_update)
        tvCivilStatus = findViewById(R.id.tvCivilStatus)
        tvAddress = findViewById(R.id.tvAddress)
        tvPhone1 = findViewById(R.id.tvPhone1)
        tvPhone2 = findViewById(R.id.tvPhone2)
        getPersonalInformation("1-1818-0555")
        setOnClickListeners(btnUpdate)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_update -> {
                PatientService().updatePatien(createRequestBody("1-1818-0555", tvCivilStatus.text.toString()
                    , tvAddress.text.toString(), tvPhone1.text.toString(), tvPhone2.text.toString()),this)
            }
        }
    }

    private fun getPersonalInformation(idCard: String) {
        val retrofit = RetrofitHelper.getRetrofit()
        val call =
            retrofit.create(DigitalHealthApiClient::class.java).getPersonalInformation(idCard)
        call.enqueue(object : Callback<PatientModel> {
            override fun onResponse(call: Call<PatientModel>, response: Response<PatientModel>) {
                if (response.code() == 200) {
                    val patientInfo = response.body()!!
                    tvCivilStatus.text = patientInfo.civilStatus
                    tvAddress.text = patientInfo.address
                    tvPhone1.text = patientInfo.phoneNumber1
                    tvPhone2.text = patientInfo.phoneNumber2
                } else {
                    Log.d("Pretty Printed JSON else:", "f")
                }
            }

            override fun onFailure(call: Call<PatientModel>, t: Throwable) {
                Log.d("FAILURE:", t.cause.toString() + "  " + t.message + "  " + t.localizedMessage)
            }
        })
    }

    val createRequestBody: (String, String, String, String, String) -> RequestBody =
        { idCard: String, civilStatus: String, address: String, phoneNumber1: String, phoneNumber2: String ->
            val jsonObject = JSONObject()
            jsonObject.put("idCard", idCard)
            jsonObject.put("civilStatus", civilStatus)
            jsonObject.put("address", address)
            jsonObject.put("phoneNumber1", phoneNumber1)
            jsonObject.put("phoneNumber2", phoneNumber2)
            jsonObject.toString()
                .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
        }

    val setOnClickListeners: (Button) -> Unit = { btn: Button -> btn.setOnClickListener(this) }
}