package com.randalljuan.proyecto3_mobile_b95212_b97452.data.model

import com.google.gson.annotations.SerializedName

data class VaccinationModel (
    @SerializedName("idCard")
    val idCard: String?,
    @SerializedName("vaccinationType")
    val vaccinationType: String?,
    @SerializedName("fullName")
    val fullname: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("applicationDate")
    val latestVaccineDate: String?,
    @SerializedName("nextVaccinationDate")
    val nextVaccineDate: String?
)