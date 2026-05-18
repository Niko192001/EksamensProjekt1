package com.example.neveranother.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
import com.example.neveranother.R
import com.example.neveranother.components.MeasurementRow

@Composable
fun Fit4MeasurementsScreen(
    upper: Int,
    lower: Int,
    span: Int,
    height: Int,
    onContinue: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Titel
        Text(
            text = "Dine Mål",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Vi har beregnet dine personlige mål",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(24.dp))

        //Illustration
        Image(
            painter = painterResource(id = R.drawable.body_measure_illustration),
            contentDescription = "Body measurement illustration",
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        //mål
        MeasurementRow(label = "Upper Circumference", value = "$upper cm")
        Spacer(modifier = Modifier.height(12.dp))

        MeasurementRow(label = "Lower Circumference", value = "$lower cm")
        Spacer(modifier = Modifier.height(12.dp))

        MeasurementRow(label = "Breast Span", value = "$span cm")
        Spacer(modifier = Modifier.height(12.dp))

        MeasurementRow(label = "Breast Height", value = "$height cm")

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Sidst opdateret 12. Maj 2025",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Dine mål er sikre hos os",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        //Produktkort (placeholder)
        Image(
            painter = painterResource(id = R.drawable.bra_black),
            contentDescription = "Bra product",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        //Knappen
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
        Spacer(modifier = Modifier.height(16.dp))
    }
}