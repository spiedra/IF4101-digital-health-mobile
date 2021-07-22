package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.randalljuan.proyecto3_mobile_b95212_b97452.R

class AppointmentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment_details)

        val parameters = this.intent.extras
        if (parameters != null) {
            (findViewById<TextView>(R.id.tvPatientName)).text = parameters.getString("PatientName")
            (findViewById<TextView>(R.id.tvSpecialty)).text = parameters.getString("Specialty")
            (findViewById<TextView>(R.id.tvHealthCenter)).text = parameters.getString("HealthCenter")
            (findViewById<TextView>(R.id.tvAppDate)).text = parameters.getString("Date")
            (findViewById<TextView>(R.id.tvDescripApp)).text = parameters.getString("Description")
        }
    }
}