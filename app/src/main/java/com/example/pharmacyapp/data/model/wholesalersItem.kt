package com.example.pharmacyapp.data.model

data class wholesalersItem(
    val accountNumber: Any,
    val id: Int,
    val name: String,
    val pharmaciesLinks: List<PharmaciesLink>
)