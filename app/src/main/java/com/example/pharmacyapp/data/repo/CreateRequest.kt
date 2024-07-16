package com.example.pharmacyapp.data.repo

import com.example.pharmacyapp.data.model.UserReturnRequest
import com.example.pharmacyapp.data.model.createrequest
import retrofit2.Response

interface CreateRequest {

    suspend fun createrequest(
        token:String,
        id:Int,
        servicetype:String,
        whosealerid:String
    ): Response<createrequest>
}