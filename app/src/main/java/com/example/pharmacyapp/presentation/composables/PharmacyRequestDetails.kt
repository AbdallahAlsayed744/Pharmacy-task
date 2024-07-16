package com.example.pharmacyapp.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pharmacyapp.data.model.ReturnRequestX
import com.example.pharmacyapp.presentation.viewmodels.pharmacydetailsViewmodel

@Composable
fun PharmacyRequestDetails(model:pharmacydetailsViewmodel= hiltViewModel(),id:Int) {

    val state by model.pharmacydata.collectAsState()

    model.getpharmaciesrequest(token ="Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0YXNrMjAyNCIsImV4cCI6MTcyMTE1OTE4NCwiaWF0IjoxNzIxMTM3NTg0fQ.rCP4rj7rZI9QPFS8ljsOz_9w2IYoMbEWQwQSh2Mc6QajMs3dQHOykMYOUpLQwVpX-V--nZs1RADeaokUSKrcZA",id)

    state?.let {
        pharmacydetails(data = it)
    }




}

@Composable
fun pharmacydetails(data:ReturnRequestX){

    Column(modifier = Modifier
        .padding(top = 30.dp)
        .fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){

        Text(text ="Id:${data.id}")
        Text(text ="Status:${data.returnRequestStatus}")
        Text(text ="Services Type:${data.serviceType}")
        Text(text ="CreatedAt:${data.createdAt}")



    }





}