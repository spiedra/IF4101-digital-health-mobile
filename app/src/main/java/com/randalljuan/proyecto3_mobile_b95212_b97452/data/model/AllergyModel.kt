package com.randalljuan.proyecto3_mobile_b95212_b97452.data.model

import com.google.gson.annotations.SerializedName

data class AllergyModel (
    @SerializedName("allergyType")
    val allergyType: String?,
    @SerializedName("fullName")
    val fullname: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("diagnosticDate")
    val diagnosticDate: String?
    )