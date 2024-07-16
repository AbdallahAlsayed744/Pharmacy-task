package com.example.pharmacyapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pharmacyapp.data.model.ReturnRequestX
import com.example.pharmacyapp.data.model.pharmacyinfoItem
import com.example.pharmacyapp.data.repo.pharmacydetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class pharmacydetailsViewmodel @Inject constructor(
    private val repository: pharmacydetails
): ViewModel()
{
    private val _pharmacydata = MutableStateFlow<ReturnRequestX?>(null)
    val pharmacydata: StateFlow<ReturnRequestX?> get() = _pharmacydata

    fun getpharmaciesrequest(token: String,pharmacyid: Int){
        try {
            viewModelScope.launch (Dispatchers.IO) {

                val response = repository.getReturnRequest(token,pharmacyid)
                if (response.isSuccessful && response.body() != null) {
                    _pharmacydata.value = response.body()!!.content[0].returnRequest
                }
            }
        }
        catch (e: Exception) {
            println("pharmacydata fail")
            println("pharmacydata : ${e.message}")
        }






    }


}