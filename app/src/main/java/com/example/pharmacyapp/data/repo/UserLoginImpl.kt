package com.example.pharmacyapp.data.repo

import android.util.Log
import com.example.pharmacyapp.data.model.LoginRequest
import com.example.pharmacyapp.data.model.user
import com.example.pharmacyapp.data.remote.Api
import retrofit2.Response

class UserLoginImpl(
    private val api: Api
):UserLogin{
    override suspend fun login(username: String, password: String): Response<user> {
        val response =api.login(loginRequest = LoginRequest(username, password))
        if (response.isSuccessful&&response.body()!=null){
            Log.d("UserLoginImpl", "login Sucessfull")
            Log.d("UserLoginImpl", "login: ${response.body()}")
        }
        else{
            Log.d("UserLoginImpl", "login fail")
            Log.d("UserLoginImpl", "login: ${response.errorBody()}")
        }

        return response

    }


}