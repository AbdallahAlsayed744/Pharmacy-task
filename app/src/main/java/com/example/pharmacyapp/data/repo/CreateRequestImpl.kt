package com.example.pharmacyapp.data.repo

import android.util.Log
import com.example.pharmacyapp.data.model.LoginRequest
import com.example.pharmacyapp.data.model.UserReturnRequest
import com.example.pharmacyapp.data.model.createrequest
import com.example.pharmacyapp.data.remote.Api
import retrofit2.Response

class CreateRequestImpl(
    private val api: Api
):CreateRequest{
    override suspend fun createrequest(
        token: String,
        id: Int,
        servicetype:String,
        whosealerid:String
    ): Response<createrequest> {
        val response =api.submitcreaterequest(token,id,returnrequest=UserReturnRequest(servicetype,whosealerid))
        if (response.isSuccessful&&response.body()!=null){
            Log.d("CreateRequestImpl", "CreateRequestImpl sucessfull")
            Log.d("CreateRequestImpl", "CreateRequestImpl: ${response.body()}")
        }
        else{
            Log.d("CreateRequestImpl", "CreateRequestImpl fail")
            Log.d("CreateRequestImpl", "CreateRequestImpl: ${response.errorBody()}")
        }

        return response

    }


}