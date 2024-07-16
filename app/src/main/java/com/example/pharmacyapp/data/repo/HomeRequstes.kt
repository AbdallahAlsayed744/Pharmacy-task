package com.example.pharmacyapp.data.repo

import com.example.pharmacyapp.data.model.pharmacyinfo
import retrofit2.Response

interface HomeRequstes {


    suspend fun getPharmacies(token:String): Response<pharmacyinfo>
}