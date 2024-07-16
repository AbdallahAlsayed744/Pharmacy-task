package com.example.pharmacyapp.data.repo

import com.example.pharmacyapp.data.model.user
import com.example.pharmacyapp.data.remote.Api
import retrofit2.Response


interface UserLogin {

    suspend fun login(username: String, password: String): Response<user>


}