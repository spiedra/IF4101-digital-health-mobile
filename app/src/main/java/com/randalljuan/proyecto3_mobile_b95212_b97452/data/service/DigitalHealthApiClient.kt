package com.randalljuan.proyecto3_mobile_b95212_b97452.data.service

import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.AppointmentModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.PatientModel
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface DigitalHealthApiClient {
    // Login
    @POST("/api/LogIn/LogIn")
    fun validatePatientLogin(@Body params: RequestBody): String

    // Patient
    @GET("/api/Patient/GetPersonalInformation")
    fun getPersonalInformation(@Query("idCard") idCard: String): Response<PatientModel>

    @PUT("/api/Patient/UpdatePersonalInformation")
    fun updatePersonalInformation(@Body params: RequestBody)

    // Appointment
    @GET("/api/Appointment/GetAppointmentByCard")
    fun getAppointmentByCard(@Query("patientCardId") patientCardId: String): Response<AppointmentModel>
}