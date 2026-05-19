package com.example.neveranother.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ApproachLayoutModifierNode
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.neveranother.screens.*

@Composable
fun AppNavGraph(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        //Home
        composable("home"){HomeScreen() }
        composable("home2"){ChooseBraScreen() }

        //Fit
        composable("Fit"){FitScreen()}
        composable("Fit2"){FitVideoGuideScreen()}
        composable("Fit3"){Fit3ScanScreen()}

        //Kurv / Checkout
        composable("Kurv"){KurvScreen()}
        composable("Kurv3"){PaymentScreen()}
        composable("Kurv8"){OrderConfirmedScreen()}

        //Profil
        composable("profile"){ProfileScreen()}
        composable("profile2"){MeasurementsScreen()}
        composable("profile3"){OrderStatusScreen()}

    }

}


