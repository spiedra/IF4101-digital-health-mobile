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
            retrofit.create(DigitalHealthApiClient::class.java).getAllergyByCard("1-1818-0999")
        call.enqueue(object : Callback<List<AllergyModel>> {
            override fun onResponse(
                call: Call<List<AllergyModel>>,
                response: Response<List<AllergyModel>>
            ) {
                /*
                if((response.body()){
                    Toast.makeText(this@AllergyActivity,"No se han encontrado alergias",Toast.LENGTH_LONG)
                }
                 */
                recView.apply {
                    val adaptador = AllergyAdapter(response.body()!!,
                        object : AllergyAdapter.AllergyClickListener {
                            override fun onAllergyClicked(position: Int) {

                                val intent =
                                    Intent(this@AllergyActivity, AllergyDetailsActivity::class.java)
                                intent.putExtra(
                                    "AllergyType",
                                    response.body()!![position]?.allergyType!!
                                )
                                intent.putExtra(
                                    "DiagnosticDate",
                                    response.body()!![position]?.diagnosticDate!!
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


}