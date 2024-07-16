@file:JvmName("CreateReturnRequestScreenKt")

package com.example.pharmacyapp.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pharmacyapp.R
import com.example.pharmacyapp.presentation.viewmodels.CreateRequestViewmoel
import com.example.pharmacyapp.utilis.constants

@Composable
fun DisplayData(model: CreateRequestViewmoel= hiltViewModel(),onclick: () -> Unit) {
        val state by model.mytokken.collectAsState()

    Text(text = "Hello")

        SubmitBody(
            onServiseTypechange = model::onMyserviceChange,
            onWholesalerid = model::onMysealeridChange
        ) {
            model.submitrequest(
                token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0YXNrMjAyNCIsImV4cCI6MTcyMTE1OTE4NCwiaWF0IjoxNzIxMTM3NTg0fQ.rCP4rj7rZI9QPFS8ljsOz_9w2IYoMbEWQwQSh2Mc6QajMs3dQHOykMYOUpLQwVpX-V--nZs1RADeaokUSKrcZA",
                192
            )

        }
        if (state != null) {
         onclick()
        }

}


    @Composable
    fun SubmitBody(
        onServiseTypechange: (String) -> Unit,
        onWholesalerid: (String) -> Unit,
        onclick: () -> Unit
    ) {

        Column(
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


//        Image(painter = painterResource(id = R.drawable.pharmacylogo2), modifier = Modifier
//            .fillMaxWidth()
//            .height(50.dp)
//            .align(Alignment.CenterHorizontally),contentDescription = "")


            Text(
                text = "Service Type", modifier = Modifier
                    .padding(top = 40.dp, start = 30.dp)
                    .fillMaxWidth(), fontSize = 22.sp, color = colorResource(
                    id = R.color.black
                )
            )

            MytextfieldServisetypr(
                modifier = Modifier
                    .padding(start = 30.dp)
                    .fillMaxWidth(0.9f), hint = "Enter Service Type"
            ) {
                onServiseTypechange(it)

            }

            Text(
                text = "WholesalerId", modifier = Modifier
                    .padding(top = 10.dp, start = 30.dp)
                    .fillMaxWidth(), fontSize = 22.sp, color = colorResource(
                    id = R.color.black
                )
            )

            Mytextfieldwhosealerid(
                modifier = Modifier
                    .padding(start = 30.dp)
                    .fillMaxWidth(0.9f), hint = "Enter WholesalerId"
            ) {
                onWholesalerid(it)

            }

//        Text(text = "Forget Password", modifier = Modifier
//            .padding(top = 5.dp, end = 34.dp)
//            .fillMaxWidth() , textAlign = TextAlign.End,fontSize = 16.sp,color = colorResource(
//            id = R.color.primarycolor), fontWeight = FontWeight.Bold)
//

            Button(
                onClick = {
                    onclick()
                }, shape = RoundedCornerShape(15.dp), colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(
                        id = R.color.primarycolor
                    ),
                    contentColor = Color.White

                ), modifier = Modifier
                    .padding(top = 50.dp, start = 100.dp)
                    .fillMaxWidth(0.7f)
                    .height(50.dp)
            )
            {

                Text(text = "Submit", fontSize = 20.sp)
            }
//
//        Text(text = "or sign up with", modifier = Modifier
//            .padding(top = 5.dp)
//            .fillMaxWidth() , textAlign = TextAlign.Center,fontSize = 16.sp,color = colorResource(
//            id = R.color.black) )
//
//
//        Row(modifier = Modifier
//            .padding(top = 20.dp)
//            .fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
//
//            Text(text = "Don't have an account?", modifier = Modifier
//                , textAlign = TextAlign.Center,fontSize = 16.sp,color = colorResource(
//                    id = R.color.black) )
//            Spacer(modifier = Modifier.width(5.dp))
//
//            Text(text = "Sign Up", modifier = Modifier
//                , textAlign = TextAlign.Center, fontWeight = FontWeight.Bold,fontSize = 16.sp,color = colorResource(
//                    id = R.color.primarycolor) )
//        }

        }

    }


    @Composable
    fun MytextfieldServisetypr(
        model: CreateRequestViewmoel = hiltViewModel(),
        modifier: Modifier = Modifier,
        hint: String,
        onServiseTypechange: (String) -> Unit
    ) {


        Box(modifier = modifier.padding(vertical = 15.dp)) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp, RoundedCornerShape(10.dp))
                    .clip(AbsoluteRoundedCornerShape(15.dp)),
                value = model.servicetype,
                placeholder = {
                    Text(text = hint)
                },
                onValueChange = {
                    onServiseTypechange(it)
                },

                maxLines = 1,
                prefix = {

                },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    Color.Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

    }

    @Composable
    fun Mytextfieldwhosealerid(
        model: CreateRequestViewmoel = hiltViewModel(),
        modifier: Modifier = Modifier,
        hint: String,
        onwhosealeridchange: (String) -> Unit
    ) {

        var showPassword by remember { mutableStateOf(false) }


        Box(modifier = modifier.padding(vertical = 15.dp)) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp, RoundedCornerShape(10.dp))
                    .clip(AbsoluteRoundedCornerShape(15.dp)),
                value = model.whosealerid,
                placeholder = {
                    Text(text = hint)
                },
                onValueChange = {

                    onwhosealeridchange(it)
                },
//            trailingIcon = {
//                IconButton(onClick = { showPassword = !showPassword }) {
//
//                    Icon(
//                        painter = painterResource(id = if (showPassword) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24), contentDescription ="Toggle Password Visibility"
//
//                    )
//
//
//
//                }
//            },
//            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                maxLines = 1,
                prefix = {

                },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    Color.Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

    }

