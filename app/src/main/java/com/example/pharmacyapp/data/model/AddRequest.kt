package com.example.pharmacyapp.data.model

data class AddRequest(

val ndc: String,
val description: String,
val manufacturer :String,
val packageSize :String,
val requestType :String,
val name :String,
val strength :String,
val dosage :String,
val fullQuantity:String,
val partialQuantity :String,
val expirationDate :String,
val statusPENDING:String,
 val lotNumber :String,
)
