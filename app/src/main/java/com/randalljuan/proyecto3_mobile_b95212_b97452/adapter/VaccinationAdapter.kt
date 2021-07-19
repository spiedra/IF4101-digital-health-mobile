package com.randalljuan.proyecto3_mobile_b95212_b97452.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.VaccinationModel

class VaccinationAdapter (private val vaccines: Array<VaccinationModel>):
    RecyclerView.Adapter<VaccinationAdapter.VaccinationViewHolder>() {


    class VaccinationViewHolder(val item: View): RecyclerView.ViewHolder(item){
        val lblVaccinationType= item.findViewById(R.id.lblVaccinationType) as TextView
        val lblVaccinationDate= item.findViewById(R.id.lblVaccinationDate) as TextView

        fun bindVaccination(vaccination:VaccinationModel){
            lblVaccinationType.text=vaccination.vaccinationType
            lblVaccinationDate.text=vaccination.latestVaccineDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccinationViewHolder {
       val item=LayoutInflater.from(parent.context)
           .inflate(R.layout.vaccine_item,parent,false) as LinearLayout

        return VaccinationViewHolder(item)
    }

    override fun onBindViewHolder(holder: VaccinationViewHolder, position: Int) {
        val currentItem=vaccines[position]
        holder.bindVaccination(currentItem)
    }

    override fun getItemCount()=vaccines.size
}