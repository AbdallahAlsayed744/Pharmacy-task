package com.example.pharmacyapp.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pharmacyapp.data.model.UserInfo
import com.example.pharmacyapp.data.repo.UserLogin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewmodel @Inject constructor(
private val repository: UserLogin
): ViewModel(){

    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set

    private val _mytokken = MutableStateFlow<UserInfo?>(null)
    val mytokken: StateFlow<UserInfo?> get() = _mytokken

    fun onEmailChange(myemail: String) {
        email = myemail
    }

    fun onPasswordChange(mypassword: String) {
        password = mypassword
    }

    fun login () {
        try {
        viewModelScope.launch(Dispatchers.IO) {

                val response = repository.login(email, password)
                Log.d(TAG,"email:$email password:$password")
                if (response.isSuccessful && response.body() != null) {
                    _mytokken.value = response.body()!!.userInfo
                }
            }
            } catch (e: Exception) {
                println("login fail")
                println("login: ${e.message}")
            }


        }


    companion object{
        private const val TAG = "LoginViewmodel"
    }
}