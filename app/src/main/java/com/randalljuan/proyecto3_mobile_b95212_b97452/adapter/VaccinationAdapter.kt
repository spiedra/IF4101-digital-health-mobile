package com.randalljuan.proyecto3_mobile_b95212_b97452.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.VaccinationModel

class VaccinationAdapter (private val vaccines: List<VaccinationModel>,
                          private var onVaccinesClickListener: VaccinationAdapter.VaccinesClickListener
):
    RecyclerView.Adapter<VaccinationAdapter.VaccinationViewHolder>() {

    interface VaccinesClickListener {
        fun onVaccinesClicked(position: Int)
    }

    class VaccinationViewHolder(val item: View): RecyclerView.ViewHolder(item){
        val lblVaccinationType= item.findViewById(R.id.lblVaccinationType) as TextView
        val lblVaccinationDate= item.findViewById(R.id.lblVaccinationDate) as TextView
        var ivVaccine= item.findViewById(R.id.ivVaccine) as ImageView
        fun bindVaccination(vaccination:VaccinationModel){
            ivVaccine.setImageResource(R.drawable.ic_vaccine)
            lblVaccinationType.text=vaccination.vaccinationType
            lblVaccinationDate.text=vaccination.latestVaccineDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccinationViewHolder {
       val item=LayoutInflater.from(parent.context)
           .inflate(R.layout.vaccine_item,parent,false) as CardView

        return VaccinationViewHolder(item)
    }

    override fun onBindViewHolder(holder: VaccinationViewHolder, position: Int) {
        val currentItem=vaccines[position]
        holder.item.setOnClickListener{
            onVaccinesClickListener.onVaccinesClicked(position)
        }


        holder.bindVaccination(currentItem)
    }

    override fun getItemCount()=vaccines.size
}