package com.randalljuan.proyecto3_mobile_b95212_b97452.data.service


import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.AllergyModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.AppointmentModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.PatientModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.ResponseModel
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.model.VaccinationModel
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface DigitalHealthApiClient {
    // Login
    @POST("api/LogIn/LogIn")
    fun validatePatientLogin(@Body params: RequestBody): Call<ResponseModel>

    // Patient
    @GET("api/Patient/GetPersonalInformation")
    fun getPersonalInformation(@Query("idCard") patientCardId: String): Call<PatientModel>

    @PUT("api/Patient/UpdatePersonalInformation")
    fun updatePersonalInformation(@Body params: RequestBody)

    // Appointment
    @GET("api/Appointment/GetAppointmentByCard")
    fun getAppointmentByCard(@Query("patientCardId") patientCardId: String): Call<List<AppointmentModel>>

    //Vaccination
    @GET("api/Vaccination/GetPatientVaccines")
    fun getVaccinationByCard(@Query("IdCard") IdCard: String): Call<List<VaccinationModel>>

    //Allergy
    @GET("api/Allergy/GetPatientAllergies")
    fun getAllergyByCard(@Query("IdCard") IdCard: String): Call<List<AllergyModel>>
}