package com.randalljuan.proyecto3_mobile_b95212_b97452.data.model

import com.google.gson.annotations.SerializedName

data class VaccinationModel (
    @SerializedName("VaccineType")
    val vaccinationType: String?,
    @SerializedName("FullName")
    val fullname: String?,
    @SerializedName("Description")
    val description: String?,
    @SerializedName("LattestVaccineDate")
    val latestVaccineDate: String?,
    @SerializedName("NextVaccineDate")
    val nextVaccineDate: String?
)