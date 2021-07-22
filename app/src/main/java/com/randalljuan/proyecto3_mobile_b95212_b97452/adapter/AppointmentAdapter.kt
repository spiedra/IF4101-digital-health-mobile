package com.randalljuan.proyecto3_mobile_b95212_b97452.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.AppointmentModel

class AppointmentAdapter(private val appointments:List<AppointmentModel>, private var OnAppointmentClickListener :AppointmentAdapter.AppointmentClickListener)
    : RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder>() {

    interface AppointmentClickListener {
        fun onAppointmentClicked(position: Int)
    }

    class AppointmentViewHolder(val item: View): RecyclerView.ViewHolder(item){
        val lblDate= item.findViewById(R.id.lblAppointmentDate) as TextView
        val lblHealthCenter= item.findViewById(R.id.lblHealthCenter) as TextView
        var ivAppointment= item.findViewById(R.id.iv_appointment) as ImageView

        fun bindAppointment(appointment: AppointmentModel){
            ivAppointment.setImageResource(R.drawable.ic_medical_app)
            lblDate.text=appointment.date
            lblHealthCenter.text=appointment.healthCenter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        val item= LayoutInflater.from(parent.context)
            .inflate(R.layout.appointment_item,parent,false) as CardView
        return AppointmentViewHolder(item)
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        val currentItem=appointments[position]
        holder.item.setOnClickListener{
            OnAppointmentClickListener.onAppointmentClicked(position)
        }
        holder.bindAppointment(currentItem)
    }

    override fun getItemCount()= appointments.size

}