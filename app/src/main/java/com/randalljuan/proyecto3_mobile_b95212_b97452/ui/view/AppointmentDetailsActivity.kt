package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.randalljuan.proyecto3_mobile_b95212_b97452.R

class AppointmentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment_details)

        val parameters = this.intent.extras
        if (parameters != null) {
            val tvPatientName=(findViewById(R.id.tvPatientName) as TextView).setText(parameters.getString("PatientName"))
            val tvEspecialidad=(findViewById(R.id.tvSpecialty) as TextView).setText(parameters.getString("Specialty"))
            val tvHealthCenter=(findViewById(R.id.tvHealthCenter) as TextView).setText(parameters.getString("HealthCenter"))
            val tvDate=(findViewById(R.id.tvAppDate) as TextView).setText(parameters.getString("Date"))
            val tvdescription=(findViewById(R.id.tvDescripApp) as TextView).setText(parameters.getString("Description"))
        }
    }
}