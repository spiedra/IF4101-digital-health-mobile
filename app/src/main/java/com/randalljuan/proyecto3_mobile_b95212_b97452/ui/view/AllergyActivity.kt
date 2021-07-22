package com.randalljuan. proyecto3_mobile_b95212_b97452.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.adapter.AllergyAdapter
import com.randalljuan.proyecto3_mobile_b95212_b97452.core.RetrofitHelper
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.AllergyModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.service.DigitalHealthApiClient
import com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view.AllergyDetailsActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var recView: RecyclerView

class AllergyActivity : AppCompatActivity() {
    val retrofit = RetrofitHelper.getRetrofit()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allergy)
        recView =  findViewById(R.id.rv_allergy_list)
        val call =
            retrofit.create(DigitalHealthApiClient::class.java).getAllergyByCard("4-0123-0876")
        call.enqueue(object : Callback<List<AllergyModel>> {
            override fun onResponse(
                call: Call<List<AllergyModel>>,
                response: Response<List<AllergyModel>>
            ) {
                var aux: List<AllergyModel>?=response.body()
                if (aux != null) {
                    isEmpty(aux)
                }
                recView.apply {
                    val adaptador = AllergyAdapter(response.body()!!,
                        object : AllergyAdapter.AllergyClickListener {
                            override fun onAllergyClicked(position: Int) {

                                val intent =
                                    Intent(this@AllergyActivity, AllergyDetailsActivity::class.java)
                                intent.putExtra(
                                    "AllergyType",
                                    response.body()!![position].allergyType!!
                                )
                                intent.putExtra(
                                    "DiagnosticDate",
                                    response.body()!![position].diagnosticDate!!
                                )
                                intent.putExtra(
                                    "Description",
                                    response.body()!![position].description!!
                                )
                                startActivity(intent)
                            }
                        })
                    recView.setHasFixedSize(true)
                    recView.layoutManager =
                        LinearLayoutManager(
                            this@AllergyActivity,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                    recView.adapter = adaptador
                }
            }
            override fun onFailure(call: Call<List<AllergyModel>>, t: Throwable) {
                Log.d("FAILURE:", t.cause.toString() + "  " + t.message + "  " + t.localizedMessage)
            }
        })
    }
    fun isEmpty(lista: List<AllergyModel>){
        if(lista.isEmpty()){
            Toast.makeText(this,"No se han encontrado alergias", Toast.LENGTH_LONG)
        }
    }
}

