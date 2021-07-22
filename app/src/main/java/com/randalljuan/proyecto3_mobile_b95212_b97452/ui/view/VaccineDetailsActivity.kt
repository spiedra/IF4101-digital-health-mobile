package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.randalljuan.proyecto3_mobile_b95212_b97452.R

class VaccineDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine_details)

        val parameters = this.intent.extras
        if (parameters != null) {
            val tvVaccineType=(findViewById(R.id.tvSpecialty) as TextView).setText(parameters.getString("VaccineType"))
            val tvLatestDate=(findViewById(R.id.tvHealthCenter) as TextView).setText(parameters.getString("LatestDate"))
            val tvnextDate=(findViewById(R.id.tvNextDate) as TextView).setText(parameters.getString("NextDate"))
            val tvdescription=(findViewById(R.id.tvDescriptionAllergy) as TextView).setText(parameters.getString("Description"))
        }
    }
}