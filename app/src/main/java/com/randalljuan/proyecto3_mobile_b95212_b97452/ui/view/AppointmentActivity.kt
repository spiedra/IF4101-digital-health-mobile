package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.adapter.AllergyAdapter
import com.randalljuan.proyecto3_mobile_b95212_b97452.adapter.AppointmentAdapter
import com.randalljuan.proyecto3_mobile_b95212_b97452.core.RetrofitHelper
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.AllergyModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.AppointmentModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.VaccinationModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.service.DigitalHealthApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var recView: RecyclerView

class AppointmentActivity : AppCompatActivity() {
    val retrofit = RetrofitHelper.getRetrofit()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        recView =  findViewById(R.id.rv_appointment_list)
        val call =
            retrofit.create(DigitalHealthApiClient::class.java).getAppointmentByCard("1-1818-0555")
        call.enqueue(object : Callback<List<AppointmentModel>> {
            override fun onResponse(
                call: Call<List<AppointmentModel>>,
                response: Response<List<AppointmentModel>>
            ) {
                /*
                if((response.body()){
                    Toast.makeText(this@AllergyActivity,"No se han encontrado alergias",Toast.LENGTH_LONG)
                }
                 */
                recView.apply {
                    val adaptador = AppointmentAdapter(response.body()!!,
                        object : AppointmentAdapter.AppointmentClickListener {
                            override fun onAppointmentClicked(position: Int) {
                                val intent =
                                    Intent(this@AppointmentActivity, AppointmentDetailsActivity::class.java)
                                intent.putExtra(
                                    "PatientName",
                                    response.body()!![position]?.patientName!!
                                )
                                intent.putExtra(
                                    "HealthCenter",
                                    response.body()!![position]?.healthCenter!!
                                )
                                intent.putExtra(
                                    "Date",
                                    response.body()!![position]?.date!!
                                )
                                intent.putExtra(
                                    "Specialty",
                                    response.body()!![position]?.specialityType!!
                                )
                                intent.putExtra(
                                    "Description",
                                    response.body()!![position]?.description!!
                                )
                                startActivity(intent)
                            }
                        })
                    recView.setHasFixedSize(true)
                    recView.layoutManager =
                        LinearLayoutManager(
                            this@AppointmentActivity,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                    recView.adapter = adaptador
                }
            }
            override fun onFailure(call: Call<List<AppointmentModel>>, t: Throwable) {
                Log.d("FAILURE:", t.cause.toString() + "  " + t.message + "  " + t.localizedMessage)
            }
        })
    }
}