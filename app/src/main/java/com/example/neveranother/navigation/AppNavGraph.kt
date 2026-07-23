package com.example.neveranother.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.neveranother.models.FitViewModel
import com.example.neveranother.screens.*
import com.example.neveranother.ui.theme.NeverAnotherTheme

/*
@Composable
fun AppNavGraph(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
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
        navigation(
            startDestination = "Fit2",
            route = "Fit_flow"
        ){
            composable("Fit2"){ backStackEntry ->
                val viewModel: FitViewModel = viewModel(backStackEntry)
                FitVideoGuideScreen(
                    navController=navController,
                    viewModel = viewModel,
                    onContinueClick = {navController.navigate("Fit4")},
                ) }
            composable("Fit3"){backStackEntry ->
                val viewModel: FitViewModel = viewModel(backStackEntry)
                Fit3ScanScreen(
                    navController=navController,
                    viewModel = viewModel,
                    onStartScan = {},

                    ) }

            composable("Fit4"){ backStackEntry ->
                val viewModel: FitViewModel = viewModel(backStackEntry)
                Fit4MeasurementsScreen(
                    navController=navController,
                    upper = 90,
                    lower = 70,
                    span = 20,
                    height = 10,
                    viewModel = viewModel,
                    onContinue = {navController.navigate("kurv")}
                )}
        }

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
 */
/*
/**
 * AppNavGraph definerer navigationen i hele appen.
 * Her styres hvilke skærme der vises, og hvordan data (via ViewModels) deles mellem dem.
 */
@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        // Home
        composable("home") {
            HomeScreen(
                navController = navController,
                onCreateBraClick = { navController.navigate("home2") },
                onReadMoreClick = { navController.navigate("about") }
            )
        }

        composable("home2") {
            ChooseBraScreen(
                navController = navController,
                onBraSelected = { navController.navigate("Fit") }
            )
        }

        composable("Fit") {
            FitScreen(
                navController = navController,
                onManualClick = { navController.navigate("Fit2") },
                on3dClick = { navController.navigate("Fit3") }
            )
        }

        // ⭐ FIT FLOW ⭐
        navigation(
            startDestination = "Fit2",
            route = "fit_flow"
        ) {

            composable("Fit2") { backStackEntry ->
                val viewModel: FitViewModel = viewModel(backStackEntry)
                FitVideoGuideScreen(
                    navController = navController,
                    viewModel = viewModel,
                    onContinueClick = { navController.navigate("Fit4") }
                )
            }

            composable("Fit3") { backStackEntry ->
                val viewModel: FitViewModel = viewModel(backStackEntry)
                Fit3ScanScreen(
                    navController = navController,
                    viewModel = viewModel,
                    onStartScan = {}
                )
            }

            composable("Fit4") { backStackEntry ->
                val viewModel: FitViewModel = viewModel(backStackEntry)
                Fit4MeasurementsScreen(
                    navController = navController,
                    viewModel = viewModel,
                    onContinue = { navController.navigate("kurv") }
                )
            }
        }

        // Kurv
        composable("kurv") {
            KurvScreen(navController = navController)
        }

        composable("kurv3") {
            PaymentScreen(
                navController = navController,
                onContinue = { navController.navigate("kurv8") }
            )
        }

        composable("kurv8") {
            OrderConfirmedScreen(navController = navController)
        }

        // Profil
        composable("profile") {
            ProfileScreen(
                navController = navController,
                onMeasurementsClick = {},
                onOrderStatusClick = { navController.navigate("profile3") },
                onSettingsClick = {}
            )
        }

        composable("profile2") {
            Profile2Screen(
                onBackClick = { navController.navigate("profile") },
                onStartScan = {}
            )
        }

        composable("profile3") {
            OrderStatusScreen(navController)
        }

        composable("about") {
            AboutUsScreen(navController = navController)
        }
    }
}

 */

/**
 * AppNavGraph definerer navigationen i hele appen.
 * Her styres hvilke skærme der vises, og hvordan data (via ViewModels) deles mellem dem.
 */
@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        // HOME
        composable("home") {
            HomeScreen(
                navController = navController,
                onCreateBraClick = { navController.navigate("home2") },
                onReadMoreClick = { navController.navigate("about") }
            )
        }

        composable("home2") {
            ChooseBraScreen(
                navController = navController,
                onBraSelected = { navController.navigate("Fit") }
            )
        }

        composable("Fit") {
            FitScreen(
                navController = navController,
                // ⭐ VIGTIGT: Navigér ind i fit_flow, ikke direkte til Fit2/Fit3
                onManuelClick = { navController.navigate("fit_flow") },
                on3dClick = { navController.navigate("Fit3") }
            )
        }

        // ⭐ FIT FLOW – her deles ViewModel korrekt ⭐
        navigation(
            startDestination = "Fit2",
            route = "fit_flow"
        ) {

            composable("Fit2") { backStackEntry ->
                // Vi henter backStackEntry for hele "fit_flow" for at dele den samme ViewModel på tværs af skærme
                val parentEntry = androidx.compose.runtime.remember(backStackEntry) {
                    navController.getBackStackEntry("fit_flow")
                }
                val viewModel: FitViewModel = viewModel(parentEntry)

                FitVideoGuideScreen(
                    navController = navController,
                    viewModel = viewModel,
                    onContinueClick = { navController.navigate("Fit4") }
                )
            }

            composable("Fit3") { backStackEntry ->
                // Samme mønster her for at få fat i den fælles ViewModel
                val parentEntry = androidx.compose.runtime.remember(backStackEntry) {
                    navController.getBackStackEntry("fit_flow")
                }
                val viewModel: FitViewModel = viewModel(parentEntry)

                Fit3ScanScreen(
                    navController = navController,
                    viewModel = viewModel,
                    onStartScan = {}
                )
            }

            composable("Fit4") { backStackEntry ->
                // Her modtager Fit4MeasurementsScreen de indtastede data fra ViewModel
                val parentEntry = androidx.compose.runtime.remember(backStackEntry) {
                    navController.getBackStackEntry("fit_flow")
                }
                val viewModel: FitViewModel = viewModel(parentEntry)

                Fit4MeasurementsScreen(
                    navController = navController,
                    viewModel = viewModel,
                    onContinue = { navController.navigate("kurv") }
                )
            }
        }

        // KURV / CHECKOUT
        composable("kurv") {
            KurvScreen(navController = navController)
        }

        composable("kurv3") {
            PaymentScreen(
                navController = navController,
                onContinue = { navController.navigate("kurv8") }
            )
        }

        composable("kurv8") {
            OrderConfirmedScreen(navController = navController)
        }

        // PROFIL
        composable("profile") {
            ProfileScreen(
                navController = navController,
                onMeasurementsClick = {},
                onOrderStatusClick = { navController.navigate("profile3") },
                onSettingsClick = {}
            )
        }

        composable("profile2") {
            Profile2Screen(
                navController = navController,
                onBackClick = { navController.navigate("profile") },
                onStartScan = {}
            )
        }

        composable("profile3") {
            OrderStatusScreen(navController)
        }

        composable("about") {
            AboutUsScreen(navController = navController)
        }
    }
}
