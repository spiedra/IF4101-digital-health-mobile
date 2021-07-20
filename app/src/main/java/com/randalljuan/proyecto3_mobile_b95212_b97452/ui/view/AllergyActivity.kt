package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.adapter.AllergyAdapter
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.AllergyModel

private lateinit var recView : RecyclerView
private lateinit var allergyList: List<AllergyModel>

class AllergyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allergy)
            recView = findViewById(R.id.rv_alergy_list)
             allergyList=
                List(50) { i -> AllergyModel("Alergia $i", "Randall Item $i","descripcion $i","fecha $i") }
            val adaptador = AllergyAdapter(allergyList, object : AllergyAdapter.AllergyClickListener{
                override fun onAllergyClicked(position: Int) {
                    performOnVaccineClick(position)
                }
            })
            recView.setHasFixedSize(true)
            recView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            recView.adapter = adaptador
        }
        fun performOnVaccineClick(position:Int) {

            val intent = Intent(this, AllergyDetailsActivity::class.java)
            intent.putExtra("AllergyType", allergyList[position].allergyType)
            intent.putExtra("DiagnosticDate", allergyList[position].diagnosticDate)
            intent.putExtra("Description", allergyList[position].description)
            startActivity(intent)
        }
    }