package com.example.pharmacyapp.data.model

data class Pharmacy(
    val doingBusinessAs: String,
    val enabled: Boolean,
    val id: Int,
    val user: UserX
)