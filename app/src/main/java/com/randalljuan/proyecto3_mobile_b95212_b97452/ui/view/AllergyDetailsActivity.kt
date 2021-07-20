package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.randalljuan.proyecto3_mobile_b95212_b97452.R

class AllergyDetailsActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allergy_details)

        val parameters = this.intent.extras
        if (parameters != null) {
            val tvVaccineType=(findViewById(R.id.tvAlergyType) as TextView).setText(parameters.getString("AllergyType"))
            val tvDiagnosticDate=(findViewById(R.id.tvDiagnosticDate) as TextView).setText(parameters.getString("DiagnosticDate"))
            val tvdescription=(findViewById(R.id.tvDescriptionAllergy) as TextView).setText(parameters.getString("Description"))
        }
    }
}