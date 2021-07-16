package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.randalljuan.proyecto3_mobile_b95212_b97452.Adapter.ModuleAdapter
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.ModuleModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private var _binding: ActivityMenuBinding? = null
    private val binding get() = _binding!!


    private var moduleList = ArrayList<ModuleModel>()
    private lateinit var moduleAdapter: ModuleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        _binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.moduleList.layoutManager = LinearLayoutManager(this)

        moduleAdapter = ModuleAdapter(moduleList , object : ModuleAdapter.OptionsMenuClickListener{

            override fun onOptionsMenuClicked(position: Int) {

                performOptionsMenuClick(position)
            }
        })

        binding.moduleList.adapter = moduleAdapter
        addModules();
    }

    private fun performOptionsMenuClick(position: Int) {
        when(position){
            0 -> showGestionModule()
            1 -> showAppointmentModule()
            2 -> showVaccineModule()
            3 -> showAllergyModule()
        }
    }

    private fun showGestionModule(){
        val intent = Intent(this, GestionActivity::class.java)
        startActivity(intent)
    }
    private fun showAppointmentModule(){
        val intent = Intent(this, AppointmentActivity::class.java)
        startActivity(intent)
    }
    private fun showVaccineModule(){
        val intent = Intent(this, VaccineActivity::class.java)
        startActivity(intent)
    }
    private fun showAllergyModule(){
        val intent = Intent(this, AllergyActivity::class.java)
        startActivity(intent)
    }

    fun addModules(){
        val gestModule= ModuleModel("Gestión de datos")
        val appointmentModule= ModuleModel("Citas")
        val vaccineModule= ModuleModel("Vacunas")
        val allergiesModule= ModuleModel("Alergias")
        moduleList.add(gestModule)
        moduleList.add(appointmentModule)
        moduleList.add(vaccineModule)
        moduleList.add(allergiesModule)
        moduleAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}