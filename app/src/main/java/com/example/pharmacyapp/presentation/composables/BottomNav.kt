package com.example.pharmacyapp.presentation.composables

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.pharmacyapp.R
import com.example.pharmacyapp.utilis.constants

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigation(navController: NavController) {
    var select_tab by remember {
        mutableStateOf(0)
    }
    Scaffold(

        bottomBar = {
            NavigationBar(containerColor = colorResource(id =R.color.bottomnav),) {

                NavigationBarItem(selected = select_tab == 0, onClick = { select_tab = 0 }, icon = {
                    if (select_tab == 0) {

                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = "Home",
                            tint = Color.Blue

                        )

                    }
                    else {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = "Home",
                            tint = Color.Gray


                        )
                    }

                }, alwaysShowLabel = false ,label = { Text(text = "HomeRequsts", fontWeight = FontWeight.Bold , color =  Color.Blue ) })
                NavigationBarItem(selected = select_tab == 1, onClick = { select_tab = 1 }, icon = {
                    if (select_tab == 1) {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "search",
                            tint = Color.Blue

                        )

                    }
                    else {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "search",
                            tint = Color.Gray


                        )
                    }


                },  alwaysShowLabel = false,label = { Text(text = "ReturnRequest", fontWeight = FontWeight.Bold ,color = Color.Blue ) })
                NavigationBarItem(selected = select_tab == 2, onClick = { select_tab = 2 }, icon = {
                    if (select_tab == 2) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_bookmark_border_24),
                            contentDescription = "bookmark",
                            tint = Color.Blue

                        )

                    }
                    else {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_bookmark_border_24),
                            contentDescription = "bookmark",
                            tint = Color.Gray


                        )
                    }


                },  alwaysShowLabel = false,label = { Text(text = "AddItem", fontWeight = FontWeight.Bold,color =  Color.Blue ) })

            }

        }
    ) {
        when (select_tab) {
            0 -> {
                HomeRequsts(){pharmid->
                    navController.navigate("${constants.pharmdetailsscreen}/${pharmid}")
                }
            }

            1 -> {
                DisplayData(){
                    navController.navigate(constants.Additem)

                }


            }

            2 -> {
                EditData()
            }
        }

    }



}