package com.example.pharmacyapp.data.repo

import android.util.Log
import com.example.pharmacyapp.data.model.returnrequest
import com.example.pharmacyapp.data.remote.Api
import retrofit2.Response

class pharmacydetailsimpl(
    private val api: Api
):pharmacydetails {
    override suspend fun getReturnRequest(
        token: String,
        pharmacyId: Int
    ): Response<returnrequest> {
        val response =api.getReturnRequests(token,pharmacyId)
        if (response.isSuccessful&&response.body()!=null){
            Log.d("pharmacydetailsimpl", "pharmacydetailsimplSucessfull")
            Log.d("pharmacydetailsimpl", "pharmacydetailsimpl: ${response.body()}")
        }
        else{
            Log.d("pharmacydetailsimpl", "pharmacydetailsimplfail")
            Log.d("pharmacydetailsimpl", "pharmacydetailsimpl: ${response.body()}")
        }

        return response


    }
}