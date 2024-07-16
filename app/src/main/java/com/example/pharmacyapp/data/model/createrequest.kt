package com.example.pharmacyapp.data.model

data class createrequest(
    val createdAt: String,
    val dateDispatched: Any,
    val dateFulfilled: Any,
    val disbursements: Any,
    val id: Int,
    val pharmacy: PharmacyX,
    val preferredDate: Any,
    val returnRequestStatus: String,
    val returnRequestStatusLabel: String,
    val serviceFee: Any,
    val serviceType: String,
    val updatedAt: String
)