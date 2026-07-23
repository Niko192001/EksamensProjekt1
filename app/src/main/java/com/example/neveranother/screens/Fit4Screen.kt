package com.example.neveranother.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.neveranother.ui.theme.BackgroundColor
import com.example.neveranother.R
import com.example.neveranother.components.MeasurementRow
import com.example.neveranother.models.FitViewModel
import com.example.neveranother.navigation.BackButton
import com.example.neveranother.navigation.BottomNavigationBar

/**
 * Fit4MeasurementsScreen viser en oversigt over de beregnede eller indtastede mål.
 * Den bruger en delt FitViewModel til at vise data fra de foregående skærme i fit-flowet.
 */
@Composable
fun Fit4MeasurementsScreen(
    navController: NavController,
    viewModel: FitViewModel,
    onContinue: () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(BackgroundColor)) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(bottom = 80.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                BackButton(navController = navController)
            }
            Text(
                text = "Dine Mål",
                color = Color.Black,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Vi har beregnet dine personlige mål",
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(24.dp))

            Image(
                painter = painterResource(id = R.drawable.sortbh),
                contentDescription = "Body measurement illustration",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            MeasurementRow("Upper Circumference", "${viewModel.upperValue} cm")
            Spacer(modifier = Modifier.height(12.dp))
            MeasurementRow("Lower Circumference", "${viewModel.lowerValue} cm")
            Spacer(modifier = Modifier.height(12.dp))
            MeasurementRow("Breast Span", "${viewModel.spanValue} cm")
            Spacer(modifier = Modifier.height(12.dp))
            MeasurementRow("Breast Height", "${viewModel.heightValue} cm")

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Sidst opdateret 12. Maj 2025",
                color = Color.Black,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Dine mål er sikre hos os",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(50.dp))

            Button(
                onClick = onContinue,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6A1B1A),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Videre til Kurv")
            }
        }

        BottomNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            onHomeClick = { navController.navigate("home") },
            onFitClick = { navController.navigate("Fit") },
            onCartClick = { navController.navigate("Kurv") },
            onProfileClick = { navController.navigate("profile") }
        )
    }
}