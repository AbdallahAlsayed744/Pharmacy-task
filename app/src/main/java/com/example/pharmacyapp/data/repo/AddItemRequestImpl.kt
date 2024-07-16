package com.example.pharmacyapp.data.repo

import android.util.Log
import com.example.pharmacyapp.data.model.AddRequest
import com.example.pharmacyapp.data.model.MYaddrequest
import com.example.pharmacyapp.data.remote.Api
import retrofit2.Response

class AddItemRequestImpl(
   private val api:Api
):AddItemRequest {

    override suspend fun addItem(
        token: String,
        pharmacyId: Int,
        returnRequestId: Int,
        ndc: String,
        description: String,
        manufacturer: String,
        packageSize: String,
        requestType: String,
        name: String,
        strength: String,
        dosage: String,
        fullQuantity: String,
        partialQuantity: String,
        expirationDate: String,
        statusPENDING: String,
        lotNumber: String
    ): Response<MYaddrequest> {
        val response =api.AddRequest(token, pharmacyId,returnRequestId, AddRequest(ndc, description, manufacturer, packageSize, requestType, name, strength, dosage, fullQuantity, partialQuantity, expirationDate, statusPENDING, lotNumber))
        if (response.isSuccessful&&response.body()!=null){
            Log.d("AddItemRequest", "AddItemRequestSucessfull")
            Log.d("AddItemRequest", "AddItemRequest: ${response.body()}")
        }
        else{
            Log.d("AddItemRequest", "pharmacydetailsimplfail")
            Log.d("AddItemRequest", "AddItemRequest: ${response.body()}")
        }

        return response

    }
}