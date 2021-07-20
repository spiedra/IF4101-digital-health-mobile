package com.randalljuan.proyecto3_mobile_b95212_b97452.data.model

import com.google.gson.annotations.SerializedName

data class AllergyModel (
    @SerializedName("AllergyType")
    val allergyType: String?,
    @SerializedName("FullName")
    val fullname: String?,
    @SerializedName("Description")
    val description: String?,
    @SerializedName("DiagnosticDate")
    val diagnosticDate: String?
    )