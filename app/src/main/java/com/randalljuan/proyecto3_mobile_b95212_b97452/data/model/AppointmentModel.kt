package com.randalljuan.proyecto3_mobile_b95212_b97452.data.model

import com.google.gson.annotations.SerializedName

data class AppointmentModel(
    @SerializedName("patientCard")
    val patientCard: String?,
    @SerializedName("patientName")
    val patientName: String?,
    @SerializedName("healthCenter")
    val healthCenter: String?,
    @SerializedName("date")
    val date: String?,
    @SerializedName("specialityType")
    val specialityType: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("appointmentID")
    val appointmentID: Int?
)
