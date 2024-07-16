package com.example.pharmacyapp.data.repo

import com.example.pharmacyapp.data.model.returnrequest
import retrofit2.Response

interface pharmacydetails {

    suspend fun getReturnRequest(token:String,pharmacyId:Int): Response<returnrequest>
}