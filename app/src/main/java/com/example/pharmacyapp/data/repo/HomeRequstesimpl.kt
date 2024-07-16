package com.example.pharmacyapp.data.repo

import android.util.Log
import com.example.pharmacyapp.data.model.LoginRequest
import com.example.pharmacyapp.data.model.pharmacyinfo
import com.example.pharmacyapp.data.remote.Api
import retrofit2.Response

class HomeRequstesimpl(
    private val api: Api
):HomeRequstes {
    override suspend fun getPharmacies(token:String): Response<pharmacyinfo> {
        val response =api.getPharmacies(token)
        if (response.isSuccessful&&response.body()!=null){
            Log.d("HomerequestsImpl", "Homerequests Sucessfull")
            Log.d("HomerequestsImpl", "Homerequests: ${response.body()}")
        }
        else{
            Log.d("HomerequestsImpl", "Homerequests fail")
            Log.d("HomerequestsImpl", "Homerequests: ${response.body()}")
        }

        return response

    }


}
