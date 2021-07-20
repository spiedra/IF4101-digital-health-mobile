package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.adapter.VaccinationAdapter
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.VaccinationModel

private lateinit var recView : RecyclerView
private lateinit var vaccinesList: List<VaccinationModel>

class VaccineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine)

        recView = findViewById(R.id.rv_vaccine_list)
         vaccinesList =
            List(50) { i -> VaccinationModel("Vacuna $i", "Randall Item $i","descripcion $i","fecha $i","fecha2 $i") }
        val adaptador = VaccinationAdapter(vaccinesList, object : VaccinationAdapter.VaccinesClickListener{
            override fun onVaccinesClicked(position: Int) {
                performOnVaccineClick(position)
            }
        })
        recView.setHasFixedSize(true)
        recView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recView.adapter = adaptador
    }

    fun performOnVaccineClick(position:Int){

        val intent = Intent(this, VaccineDetailsActivity::class.java)
         intent.putExtra("VaccineType", vaccinesList[position].vaccinationType)
        intent.putExtra("LatestDate", vaccinesList[position].latestVaccineDate)
        intent.putExtra("NextDate", vaccinesList[position].nextVaccineDate)
        intent.putExtra("Description", vaccinesList[position].description)
        startActivity(intent)
    }
}