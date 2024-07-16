package com.example.pharmacyapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pharmacyapp.data.model.UserInfo
import com.example.pharmacyapp.data.model.pharmacyinfoItem
import com.example.pharmacyapp.data.repo.HomeRequstes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeRequestViewmodel @Inject constructor(
    private val repository: HomeRequstes
):ViewModel() {


   private val _pharmacydata = MutableStateFlow<List<pharmacyinfoItem?>>(emptyList())
    val pharmacydata: StateFlow<List<pharmacyinfoItem?>> get() = _pharmacydata

    init {
        getpharmaciesrequest("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0YXNrMjAyNCIsImV4cCI6MTcyMTE1OTE4NCwiaWF0IjoxNzIxMTM3NTg0fQ.rCP4rj7rZI9QPFS8ljsOz_9w2IYoMbEWQwQSh2Mc6QajMs3dQHOykMYOUpLQwVpX-V--nZs1RADeaokUSKrcZA")
    }


    fun getpharmaciesrequest(token: String){
        try {
        viewModelScope.launch (Dispatchers.IO) {

            val response = repository.getPharmacies(token)
            if (response.isSuccessful && response.body() != null) {
                _pharmacydata.value = response.body()!!
            }
        }
            }
        catch (e: Exception) {
                println("pharmacydata fail")
                println("pharmacydata : ${e.message}")
            }






        }
    }



