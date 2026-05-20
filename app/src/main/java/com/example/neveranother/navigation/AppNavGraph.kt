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
                onReadMoreClick = {},
                onCreateBraClick = {navController.navigate("home2")},
            ) }
        composable("home2"){
            ChooseBraScreen(
                onBraSelected = {navController.navigate("Fit")},
            ) }

        //Fit
        composable("Fit"){
            Fitscreen(
                onManuelClick = {navController.navigate("Fit2")},
                on3dClick = {navController.navigate("Fit3")},
            )
        }
        composable("Fit2"){
            FitVideoGuideScreen(
                onUpperClick = {},
                onLowerClick = {},
                onSpanClick = {},
                onHeightClick = {},
                onContinueClick = {navController.navigate("Fit4")},
            ) }
        composable("Fit3"){
            Fit3ScanScreen(
                onStartScan = {},

            ) }

        composable("Fit4"){
            Fit4MeasurementsScreen(
                upper = 0,
                lower = 0,
                span = 0,
                height = 0,
                onContinue = {navController.navigate("KurvScreen")}
            )}


        //Kurv / Checkout
        composable("Kurv") {KurvScreen()}
        composable("Kurv"){
            InputField(
                label = "",
                value = "",
                showCalendarIcon = false
            )}

        composable("Kurv3"){
            PaymentScreen(
                onContinue = {navController.navigate("Kurv8")}
            ) }
        composable("Kurv8"){OrderConfirmedScreen() }

        //Profil
        composable("profile"){
            ProfileScreen(
                onMeasurementsClick = {},
                onOrderStatusClick = {navController.navigate("profile3")},
                onSettingsClick = {},
            ) }
        composable("profile2"){
            Profile2Screen(
                onBackClick = {navController.navigate("profile")},
                onStartScan = {},
            ) }
        composable("profile3"){OrderStatusScreen() }

    }

}

@Preview(showBackground = true)
@Composable
fun AppNavGraphPreview() {
    NeverAnotherTheme {
        AppNavGraph()
    }
}


