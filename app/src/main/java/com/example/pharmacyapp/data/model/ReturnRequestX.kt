package com.example.pharmacyapp.data.model

data class ReturnRequestX(
    val createdAt: Long,
    val id: Int,
    val pharmacy: Pharmacy,
    val preferredDate: Any,
    val returnRequestStatus: String,
    val returnRequestStatusLabel: String,
    val serviceType: String
)