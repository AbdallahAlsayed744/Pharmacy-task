package com.example.pharmacyapp.data.repo

import com.example.pharmacyapp.data.model.MYaddrequest
import retrofit2.Response

interface AddItemRequest {

    suspend fun addItem(
        token: String,
        pharmacyId: Int,
        returnRequestId: Int,
        ndc: String,
        description: String,
         manufacturer :String,
         packageSize :String,
         requestType :String,
         name :String,
         strength :String,
         dosage :String,
         fullQuantity:String,
         partialQuantity :String,
         expirationDate :String,
         statusPENDING:String,
         lotNumber :String,

    ): Response<MYaddrequest>
}