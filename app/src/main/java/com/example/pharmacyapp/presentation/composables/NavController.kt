package com.example.pharmacyapp.presentation.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pharmacyapp.utilis.constants

@Composable
fun MyNavController(){

    val navcontroller = rememberNavController()

    NavHost(navController = navcontroller, startDestination = constants.LoginScreen){

        composable(route = constants.LoginScreen){
            LogIn(navController =navcontroller)

        }

        composable(route = constants.HomeScreen){
            HomeScreen(navController = navcontroller)
        }

        composable(route = "${constants.pharmdetailsscreen}/{pharmacyId}", arguments = listOf(
            navArgument("pharmacyId"){
                type = NavType.IntType

            }
        ))
        {
            val id = it.arguments?.getInt("pharmacyId")
            PharmacyRequestDetails(id = id!!)
        }

        composable(route=constants.Additem){
           AddItem()
        }

    }

}