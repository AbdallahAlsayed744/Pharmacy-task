package com.example.pharmacyapp.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pharmacyapp.data.model.MYaddrequest
import com.example.pharmacyapp.data.model.UserInfo
import com.example.pharmacyapp.data.repo.AddItemRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRequestViewmodel @Inject constructor(
    private val repository: AddItemRequest
):ViewModel(){

    var ndc by mutableStateOf("")
        private set
    var description by mutableStateOf("")
        private set

    var manufacturer by mutableStateOf("")
        private set
    var packageSize by mutableStateOf("")
        private set

    var requestType by mutableStateOf("")
        private set
    var name by mutableStateOf("")
        private set

    var strength by mutableStateOf("")
        private set
    var dosage  by mutableStateOf("")
        private set
    var fullQuantity by mutableStateOf("")
        private set
    var partialQuantity by mutableStateOf("")
        private set

    var expirationDate by mutableStateOf("")
        private set
    var statusPENDING by mutableStateOf("")
        private set

    var lotNumber by mutableStateOf("")
        private set



    private val _mytokken = MutableStateFlow<MYaddrequest?>(null)
    val mytokken: StateFlow<MYaddrequest?> get() = _mytokken

    fun onNDCChange(myndc: String) {
        ndc = myndc
    }

    fun onDescriptionChange(myDescription: String) {
        description = myDescription
    }



    fun onManfuctrurChange(mymanfucturer: String) {
        manufacturer = mymanfucturer
    }

    fun onPakagesizee(mypakagesize: String) {
        packageSize = mypakagesize
    }



    fun onRequesttypeChange(myREquesttype: String) {
        requestType = myREquesttype
    }

    fun onNameChange(myname: String) {
        name = myname
    }



    fun onStrengthChange(myStrength: String) {
        strength = myStrength
    }

    fun onDosageChange(myDosage: String) {
        dosage = myDosage
    }


    fun onFullquntatyChange(myfullquntaty: String) {
        fullQuantity = myfullquntaty
    }

    fun onPartialqunatiatyChange(myPartialqunatity: String) {
        partialQuantity = myPartialqunatity
    }

    fun onExperiationdateChange(myExperiationdate: String) {
        expirationDate = myExperiationdate
    }



    fun onstatusPENDINGChange(mystatusPENDING: String) {
        statusPENDING = mystatusPENDING
    }

    fun onlotNumberChange(mylotNumber: String) {
        lotNumber = mylotNumber
    }



    fun addRequest(token: String, id: Int,requstid:Int){
        try {
            viewModelScope.launch(Dispatchers.IO) {

              val response= repository.addItem(token,id,requstid,ndc,description,manufacturer,packageSize,requestType,name,strength,dosage,fullQuantity,partialQuantity,expirationDate,statusPENDING,lotNumber)

                if (response.isSuccessful&& response.body() != null) {
                    _mytokken.value = response.body()!!
                }


            }
        } catch (e: Exception) {
            println("add request fail")
            println("addRequest: ${e.message}")
        }
    }


}