package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.core.RetrofitHelper
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.PatientModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.service.DigitalHealthApiClient
import com.randalljuan.proyecto3_mobile_b95212_b97452.utility.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowPersonallnfoActivity : AppCompatActivity() {

    private lateinit var tvNombre: TextView
    private lateinit var tvApellidos: TextView
    private lateinit var tvEdad: TextView
    private lateinit var tvSangre: TextView
    private lateinit var tvEstadoS: TextView
    private lateinit var tvDireccion: TextView
    private lateinit var tvNumero1: TextView
    private lateinit var tvNumero2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_personallnfo)

        tvNombre=findViewById(R.id.tvNombreP)
        tvApellidos=findViewById(R.id.tvApellidoP)
        tvEdad=findViewById(R.id.tvEdadP)
        tvSangre=findViewById(R.id.tvTipo)
        tvEstadoS =findViewById(R.id.tvEstadoCP)
        tvDireccion=findViewById(R.id.tvDireccionP)
        tvNumero1=findViewById(R.id.tvNumero1P)
        tvNumero2=findViewById(R.id.tvNumero2P)
        //
        getPersonalInformation(SessionManager.getIdCard())
    }
    private fun getPersonalInformation(idCard: String) {

        val retrofit = RetrofitHelper.getRetrofit()
        val call =
            retrofit.create(DigitalHealthApiClient::class.java).getPersonalInformation(idCard)
        call.enqueue(object : Callback<PatientModel> {
            override fun onResponse(call: Call<PatientModel>, response: Response<PatientModel>) {
                if (response.code() == 200) {
                    val patientInfo = response.body()!!
                    tvNombre.text=patientInfo.name
                    tvApellidos.text=patientInfo.lastName
                    tvEdad.text=patientInfo.age.toString()
                    tvSangre.text=patientInfo.bloodType
                    tvEstadoS.text=patientInfo.civilStatus
                    tvDireccion.text=patientInfo.address
                    tvNumero1.text=patientInfo.phoneNumber1
                    tvNumero2.text=patientInfo.phoneNumber2
                } else {
                    Log.d("Pretty Printed JSON else:", "f")
                }
            }
            override fun onFailure(call: Call<PatientModel>, t: Throwable) {
                Log.d("FAILURE:", t.cause.toString() + "  " + t.message + "  " + t.localizedMessage)
            }
        })
    }
}

