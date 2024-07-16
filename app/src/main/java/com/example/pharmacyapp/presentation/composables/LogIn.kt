package com.example.pharmacyapp.presentation.composables

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pharmacyapp.R
import com.example.pharmacyapp.presentation.viewmodels.LoginViewmodel
import com.example.pharmacyapp.utilis.constants

@Composable
fun LogIn(model: LoginViewmodel = hiltViewModel(),navController: NavController){

    val state by model.mytokken.collectAsState()
    val context=LocalContext.current

    LoginBody(onPasswordchange = model::onPasswordChange, onEmailchange = model::onEmailChange){
        model.login()
        if (state!=null){
            navController.navigate(constants.HomeScreen)

        }
        else{
            Toast.makeText(context,"Enter Valid Email and Password",Toast.LENGTH_SHORT).show()
        }

    }



}


@Composable
fun LoginBody(onPasswordchange:(String)->Unit,onEmailchange:(String)->Unit,onclick:()->Unit){

    Column(modifier = Modifier
        .padding(top = 40.dp)
        .fillMaxSize()) {


        Image(painter = painterResource(id = R.drawable.pharmacylogo2), modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .align(Alignment.CenterHorizontally),contentDescription = "")


        Text(text = "Username", modifier = Modifier
            .padding(top = 40.dp, start = 30.dp)
            .fillMaxWidth() ,fontSize = 22.sp,color = colorResource(
            id = R.color.black)
        )

        Mytextfield(modifier = Modifier
            .padding(start = 30.dp)
            .fillMaxWidth(0.9f), hint = "Enter User name"){
            onEmailchange(it)

        }

        Text(text = "Password", modifier = Modifier
            .padding(top = 10.dp, start = 30.dp)
            .fillMaxWidth() ,fontSize = 22.sp,color = colorResource(
            id = R.color.black)
        )

        MytextfieldPassword(modifier = Modifier
            .padding(start = 30.dp)
            .fillMaxWidth(0.9f), hint = "Enter Password"){
            onPasswordchange(it)

        }

        Text(text = "Forget Password", modifier = Modifier
            .padding(top = 5.dp, end = 34.dp)
            .fillMaxWidth() , textAlign = TextAlign.End,fontSize = 16.sp,color = colorResource(
            id = R.color.primarycolor), fontWeight = FontWeight.Bold)


        Button(onClick = {
         onclick()
        }, shape = RoundedCornerShape(15.dp),colors = ButtonDefaults.buttonColors(
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

            Text(text = "Log In", fontSize = 20.sp)
        }

        Text(text = "or sign up with", modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth() , textAlign = TextAlign.Center,fontSize = 16.sp,color = colorResource(
            id = R.color.black) )


        Row(modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),horizontalArrangement = Arrangement.Center) {

            Text(text = "Don't have an account?", modifier = Modifier
                , textAlign = TextAlign.Center,fontSize = 16.sp,color = colorResource(
                    id = R.color.black) )
            Spacer(modifier = Modifier.width(5.dp))

            Text(text = "Sign Up", modifier = Modifier
                , textAlign = TextAlign.Center, fontWeight = FontWeight.Bold,fontSize = 16.sp,color = colorResource(
                    id = R.color.primarycolor) )


        }

    }

}


@Composable
fun Mytextfield(model: LoginViewmodel = hiltViewModel(), modifier: Modifier = Modifier, hint: String, ontextchange:(String)->Unit) {


    Box(modifier = modifier.padding(vertical = 15.dp)) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(4.dp, RoundedCornerShape(10.dp))
                .clip(AbsoluteRoundedCornerShape(15.dp)),
            value = model.email,
            placeholder = {
                Text(text = hint)
            },
            onValueChange = {
                ontextchange(it)
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
fun MytextfieldPassword(model: LoginViewmodel = hiltViewModel(), modifier: Modifier = Modifier, hint: String, onpasswordchange:(String)->Unit) {

    var showPassword by remember { mutableStateOf(false) }


    Box(modifier = modifier.padding(vertical = 15.dp)) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(4.dp, RoundedCornerShape(10.dp))
                .clip(AbsoluteRoundedCornerShape(15.dp)),
            value = model.password,
            placeholder = {
                Text(text = hint)
            },
            onValueChange = {

                onpasswordchange(it)
            },
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {

                    Icon(
                        painter = painterResource(id = if (showPassword) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24), contentDescription ="Toggle Password Visibility"

                    )



                }
            },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun SignInScreenPreview() {
//    LoginBody(onPasswordchange = {}){
//
//    }
//}
