package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.MultiTapKeyListener
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.adapter.VaccinationAdapter
import com.randalljuan.proyecto3_mobile_b95212_b97452.core.RetrofitHelper
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.AllergyModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.AppointmentModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.VaccinationModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.service.DigitalHealthApiClient
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.service.VaccinationService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var recView: RecyclerView
private lateinit var vaccinesList2: MutableList<VaccinationModel>

class VaccineActivity : AppCompatActivity() {
    val retrofit = RetrofitHelper.getRetrofit()
    private var vaccinesList: List<VaccinationModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine)
        recView = findViewById(R.id.rv_vaccine_list)

        val call =
            retrofit.create(DigitalHealthApiClient::class.java).getVaccinationByCard("4-0123-0876")
        call.enqueue(object : Callback<List<VaccinationModel>> {
            override fun onResponse(
                call: Call<List<VaccinationModel>>,
                response: Response<List<VaccinationModel>>
            ) {
                var aux:List<VaccinationModel>?=response.body()
                if(aux!=null) {
                    isEmpty(aux)
                }
                recView.apply {
                    val adaptador = VaccinationAdapter(response.body()!!,object : VaccinationAdapter.VaccinesClickListener {
                        override fun onVaccinesClicked(position: Int) {

                            val intent = Intent(this@VaccineActivity, VaccineDetailsActivity::class.java)
                            intent.putExtra("VaccineType", response.body()!![position]?.vaccinationType!!)
                            intent.putExtra("LatestDate", response.body()!![position]?.latestVaccineDate!!)
                            intent.putExtra("NextDate", response.body()!![position]?.nextVaccineDate!!)
                            intent.putExtra("Description",response.body()!![position]?.description!!)
                            startActivity(intent)
                        }
                    })
                    recView.setHasFixedSize(true)
                    recView.layoutManager =
                        LinearLayoutManager(this@VaccineActivity, LinearLayoutManager.VERTICAL, false)
                    recView.adapter = adaptador
                }
            }
            override fun onFailure(call: Call<List<VaccinationModel>>, t: Throwable) {
                Log.d("FAILURE:", t.cause.toString() + "  " + t.message + "  " + t.localizedMessage)
            }
        })
    }
    fun isEmpty(lista: List<VaccinationModel>){
        if(lista.isEmpty()){
            Toast.makeText(this,"No se han encontrado alergias", Toast.LENGTH_LONG).show()
        }
    }
}