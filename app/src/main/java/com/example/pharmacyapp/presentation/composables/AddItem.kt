package com.example.pharmacyapp.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pharmacyapp.presentation.viewmodels.CreateRequestViewmoel

@Composable
fun AddItem() {

}


@Composable
fun AddBody() {

    LazyColumn(modifier = Modifier.padding(top = 40.dp)) {
        items(13) {

            Mytextfieldwhosealerid1(hint = "swdede") {

            }

        }
    }


}






@Composable
fun MytextfieldServisetypr1(
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
fun Mytextfieldwhosealerid1(
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