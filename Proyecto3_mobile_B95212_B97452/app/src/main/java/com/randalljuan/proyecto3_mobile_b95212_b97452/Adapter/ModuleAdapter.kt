package com.randalljuan.proyecto3_mobile_b95212_b97452.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.randalljuan.proyecto3_mobile_b95212_b97452.Models.Module
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.databinding.SingleItemBinding

class ModuleAdapter(private  var moduleList: List<Module>): RecyclerView.Adapter<ModuleAdapter.ViewHolder>() {

    interface OptionsMenuClickListener {
        fun onOptionsMenuClicked(position: Int)
    }

    inner class ViewHolder(val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleAdapter.ViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModuleAdapter.ViewHolder, position: Int) {
        with(holder){
            with(moduleList[position]){
                binding.moduleName.text = this.moduleName
                when (this.moduleName) {
                    "Gestión de datos" -> binding.ivModule.setImageResource(R.drawable.ic_gestion)
                    "Citas" -> binding.ivModule.setImageResource(R.drawable.ic_citas)
                    "Vacunas" ->binding.ivModule.setImageResource(R.drawable.ic_vacuna)
                    "Alergias" ->binding.ivModule.setImageResource(R.drawable.ic_alergias)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return moduleList.size
    }

}