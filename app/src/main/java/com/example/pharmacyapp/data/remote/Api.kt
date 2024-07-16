package com.example.pharmacyapp.data.remote


import com.example.pharmacyapp.data.model.AddRequest
import com.example.pharmacyapp.data.model.LoginRequest
import com.example.pharmacyapp.data.model.MYaddrequest
import com.example.pharmacyapp.data.model.UserInfo
import com.example.pharmacyapp.data.model.UserReturnRequest
import com.example.pharmacyapp.data.model.createrequest
import com.example.pharmacyapp.data.model.pharmacyinfo
import com.example.pharmacyapp.data.model.returnrequest
import com.example.pharmacyapp.data.model.user
import com.example.pharmacyapp.data.model.wholesalers
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path


interface Api {
    @Headers("Content-Type: application/json")
    @POST("auth")
    suspend fun login(
        @Body loginRequest: LoginRequest):Response<user>


    @GET("pharmacies/management")
    suspend fun getPharmacies(
        @Header("Authorization") token: String
    ): Response<pharmacyinfo>

    @GET("pharmacies/{pharmacyId}/full")
    suspend fun getfull(
        @Header("Authorization") token: String,
        @Path("pharmacyId") pharmacyId: String
    ): Response<UserInfo>

    @GET("pharmacies/{pharmacyId}/returnrequests")
    suspend fun getReturnRequests(
        @Header("Authorization") token: String,
        @Path("pharmacyId") pharmacyId: Int
    ): Response<returnrequest>

    @GET("pharmacies/{pharmacyId}/wholesalers")
    suspend fun getWholesalers(
        @Header("Authorization") token: String,
        @Path("pharmacyId") pharmacyId: String
    ): Response<wholesalers>

    @POST("pharmacies/{pharmacyId}/returnrequests")
    suspend fun submitcreaterequest(
        @Header("Authorization") token: String,
        @Path("pharmacyId") pharmacyId: Int,
        @Body returnrequest:UserReturnRequest
    ):Response<createrequest>

    @POST("pharmacies/{pharmacyId}/returnrequests/{returnRequestId}/items")
    suspend fun AddRequest(
        @Header("Authorization") token: String,
        @Path("pharmacyId") pharmacyId: Int,
        @Path("returnRequestId") returnRequestId: Int,
        @Body returnrequest: AddRequest
    ):Response<MYaddrequest>

}