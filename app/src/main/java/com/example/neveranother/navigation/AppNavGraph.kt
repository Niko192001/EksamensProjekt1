package com.example.neveranother.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.neveranother.screens.*
import com.example.neveranother.ui.theme.NeverAnotherTheme


@Composable
fun AppNavGraph(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        //Home
        composable("home"){
            HomeScreen(
                navController=navController,
                onCreateBraClick = {navController.navigate("home2")},
                onReadMoreClick = { navController.navigate("about") },

                ) }
        composable("home2"){
            ChooseBraScreen(
                navController=navController,
                onBraSelected = {navController.navigate("Fit")},
            ) }

        //Fit
        composable("Fit"){
            FitScreen(
                navController = navController,
                onManuelClick = {navController.navigate("Fit2")},
                on3dClick = {navController.navigate("Fit3")}

            )
        }
        composable("Fit2"){
            FitVideoGuideScreen(
                navController=navController,
                onUpperClick = {},
                onLowerClick = {},
                onSpanClick = {},
                onHeightClick = {},
                onContinueClick = {navController.navigate("Fit4")},
            ) }
        composable("Fit3"){
            Fit3ScanScreen(
                navController=navController,
                onStartScan = {},

            ) }

        composable("Fit4"){
            Fit4MeasurementsScreen(
                navController=navController,
                upper = 0,
                lower = 0,
                span = 0,
                height = 0,
                onContinue = {navController.navigate("kurv")}
            )}


        //Kurv / Checkout
        composable("Kurv") {
            KurvScreen(navController = navController)
        }


        composable("Kurv3"){
            PaymentScreen(
                navController = navController,
                onContinue = {navController.navigate("Kurv8")}
            ) }
        composable("Kurv8"){OrderConfirmedScreen(
            navController=navController
        ) }

        //Profil
        composable("profile"){
            ProfileScreen(
                navController=navController,
                onMeasurementsClick = {},
                onOrderStatusClick = {navController.navigate("profile3")},
                onSettingsClick = {},
            ) }
        composable("profile2"){
            Profile2Screen(
                onBackClick = {navController.navigate("profile")},
                onStartScan = {},
            ) }
        composable("profile3"){OrderStatusScreen(navController) }

        composable("about") {
            AboutUsScreen(navController = navController)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun AppNavGraphPreview() {
    NeverAnotherTheme {
        AppNavGraph()
    }
}


