package com.randalljuan.proyecto3_mobile_b95212_b97452.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.AllergyModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.VaccinationModel

class AllergyAdapter (private val allergies:List<AllergyModel>, private var OnAllergiesClickListener :AllergyAdapter.AllergyClickListener)
    :RecyclerView.Adapter<AllergyAdapter.AllergyViewHolder>(){

    interface AllergyClickListener {
        fun onAllergyClicked(position: Int)
    }

    class AllergyViewHolder(val item: View): RecyclerView.ViewHolder(item){
        val lblAllergyType= item.findViewById(R.id.lblAllergyType) as TextView
        val lblAllergyDate= item.findViewById(R.id.lblAllergyDate) as TextView
        var ivAllergy= item.findViewById(R.id.ivAllergy) as ImageView

        fun bindVaccination(allergy: AllergyModel){
            ivAllergy.setImageResource(R.drawable.ic_allergy)
            lblAllergyType.text=allergy.allergyType
            lblAllergyDate.text=allergy.diagnosticDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllergyViewHolder {
        val item= LayoutInflater.from(parent.context)
            .inflate(R.layout.allergy_item,parent,false) as CardView
        return AllergyViewHolder(item)
    }

    override fun onBindViewHolder(holder: AllergyViewHolder, position: Int) {
        val currentItem=allergies[position]
        holder.item.setOnClickListener{
            OnAllergiesClickListener.onAllergyClicked(position)
        }
        holder.bindVaccination(currentItem)
    }

    override fun getItemCount()=allergies.size
}