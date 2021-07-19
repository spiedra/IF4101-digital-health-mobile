package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.adapter.VaccinationAdapter
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.VaccinationModel

private lateinit var recView : RecyclerView

class VaccineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine)

        recView = findViewById(R.id.rv_vaccine_list)
        val datos =
            Array(50) { i -> VaccinationModel("Vacuna $i", "Randall Item $i","descripcion $i","fecha $i","fecha2 $i") }
        val adaptador = VaccinationAdapter(datos)
        recView.setHasFixedSize(true)
        recView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recView.adapter = adaptador
    }
}