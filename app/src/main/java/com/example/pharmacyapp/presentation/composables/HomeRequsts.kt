package com.example.pharmacyapp.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pharmacyapp.R
import com.example.pharmacyapp.data.model.pharmacyinfoItem
import com.example.pharmacyapp.presentation.viewmodels.HomeRequestViewmodel
import com.example.pharmacyapp.utilis.constants

@Composable
fun HomeRequsts(model:HomeRequestViewmodel= hiltViewModel(),onclick: (Int) -> Unit) {
    val state by model.pharmacydata.collectAsState()

    PharmList(data = state){
        onclick(it)


    }



}



@Composable
fun Pharmbody(data:pharmacyinfoItem,onclick:(Int)->Unit){


    Row (modifier = Modifier
        .padding(horizontal = 20.dp, vertical = 30.dp)
        .fillMaxWidth(),horizontalArrangement = Arrangement.Center){
        Text(text = data.doingBusinessAs ?:"No Name" , color = colorResource(id = R.color.primarycolor), modifier = Modifier.clickable {
            onclick(data.pharmacyId)
        })


    }



}

@Composable
fun PharmList(data: List<pharmacyinfoItem?>,onclick: (Int) -> Unit){
    LazyColumn(modifier = Modifier.padding(top = 50.dp)) {
        items(data){
            Pharmbody(it!!,onclick)
        }

    }

}
