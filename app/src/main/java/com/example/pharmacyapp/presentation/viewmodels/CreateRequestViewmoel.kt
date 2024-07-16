package com.example.pharmacyapp.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pharmacyapp.data.model.PharmacyX
import com.example.pharmacyapp.data.model.UserInfo
import com.example.pharmacyapp.data.repo.CreateRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateRequestViewmoel @Inject constructor(
    private val repo: CreateRequest
): ViewModel() {

    var servicetype by mutableStateOf("")
        private set
    var whosealerid by mutableStateOf("")
        private set

    private val _mytokken = MutableStateFlow<PharmacyX?>(null)
    val mytokken: StateFlow<PharmacyX?> get() = _mytokken

    fun onMyserviceChange(myservice: String) {
        servicetype = myservice
    }

    fun onMysealeridChange(mywhoselid: String) {
        whosealerid= mywhoselid
    }

    fun submitrequest (token:String,id:Int) {
        try {
            viewModelScope.launch(Dispatchers.IO) {

                val response = repo.createrequest(token,id,servicetype,whosealerid)
//                Log.d(LoginViewmodel.TAG,"email:$email password:$password")
                if (response.isSuccessful && response.body() != null) {
                    _mytokken.value = response.body()!!.pharmacy
                }
            }
        } catch (e: Exception) {
            println("submit request fail")
            println("submitrequest: ${e.message}")
        }


    }

}