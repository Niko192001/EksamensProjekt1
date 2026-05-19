package com.example.neveranother.navigation

import androidx.compose.runtime.Composable
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
        composable("home"){
            HomeScreen(
                onReadMoreClick = {},
                onCreateBraClick = {},
            ) }
        composable("home2"){
            ChooseBraScreen(
                onBraSelected = {},
            ) }

        //Fit
        composable("Fit"){Fitscreen()}
        composable("Fit2"){
            FitVideoGuideScreen(
                onUpperClick = {},
                onLowerClick = {},
                onSpanClick = {},
                onHeightClick = {},
                onContinueClick = {},
            ) }
        composable("Fit3"){
            Fit3ScanScreen(
                onStartScan = {},
            ) }

        //Kurv / Checkout
        composable("Kurv"){KurvScreen() }
        composable("Kurv3"){PaymentScreen() }
        composable("Kurv8"){OrderConfirmedScreen() }

        //Profil
        composable("profile"){
            ProfileScreen(
                onMeasurementsClick = {},
                onOrderStatusClick = {},
                onSettingsClick = {},
            ) }
        composable("profile2"){
            ProfileScreen2(
                onBackClick = {},
                onStartScan = {},
            ) }
        composable("profile3"){OrderStatusScreen() }

    }

}


