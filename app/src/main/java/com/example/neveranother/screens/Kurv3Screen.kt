package com.example.neveranother.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.neveranother.R
import com.example.neveranother.components.PaymentOption
import com.example.neveranother.components.SummaryRow
import com.example.neveranother.navigation.BottomNavigationBar
import com.example.neveranother.ui.theme.BackgroundColor
import com.example.neveranother.ui.theme.Burgundy
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

/**
 * PaymentScreen håndterer betalingsdelen af checkout-flowet.
 * Her vælger brugeren betalingsmetode, accepterer vilkår og gennemfører købet.
 */
@Composable
fun PaymentScreen(
    navController: NavController,
    onContinue: () -> Unit // Denne kan bruges hvis man vil styre navigation udefra
) {
    // State til at holde styr på valgt betalingsmetode
    var selectedMethod by rememberSaveable { mutableStateOf("MobilePay") }
    
    // State til checkbox (handelsbetingelser)
    var acceptedTerms by rememberSaveable { mutableStateOf(false) }
    
    // State til at vise loading-cirkel ved betaling
    var isLoading by rememberSaveable { mutableStateOf(false) }
    
    // CoroutineScope bruges til at køre "delay" (timer) uden at blokere appen
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
                .padding(top = 32.dp)
                .padding(bottom = 170.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Betaling",
                color = Color.Black,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Vælg Betalingsmetode",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(12.dp))

            // Betalingsmuligheder
            PaymentOption(
                title = "MobilePay",
                iconRes = R.drawable.mobilepay,
                isSelected = selectedMethod == "MobilePay",
                onClick = { selectedMethod = "MobilePay" }
            )
            PaymentOption(
                title = "Dankort/Visa",
                iconRes = R.drawable.danvisa,
                isSelected = selectedMethod == "Visa",
                onClick = { selectedMethod = "Visa" }
            )
            PaymentOption(
                title = "Klarna",
                iconRes = R.drawable.klarna,
                isSelected = selectedMethod == "Klarna",
                onClick = { selectedMethod = "Klarna" }
            )
            PaymentOption(
                title = "Apple Pay",
                iconRes = R.drawable.applepay,
                isSelected = selectedMethod == "ApplePay",
                onClick = { selectedMethod = "ApplePay" }
            )

            // Sikkerheds-info række
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Sikkerhed",
                    tint = Color.Gray,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Sikker betaling krypteret med SSL",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Ordre-resumé boks
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                    .padding(20.dp)
            ) {
                SummaryRow("The Everyday Bra", "799 Kr")
                SummaryRow("Levering", "39 kr")
                SummaryRow("I alt", "838 DKK")
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Checkbox til handelsbetingelser
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { acceptedTerms = !acceptedTerms }
                    .padding(vertical = 8.dp)
            ) {
                Checkbox(
                    checked = acceptedTerms,
                    onCheckedChange = { acceptedTerms = it }
                )
                Text(
                    text = "Jeg accepterer handelsbetingelserne",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Betal-knap med loading logik
            Button(
                onClick = {
                    scope.launch {
                        isLoading = true
                        delay(1500.milliseconds) // Vi venter 1.5 sekund for at simulere betalingsgodkendelse
                        isLoading = false
                        navController.navigate("Kurv8")
                    }
                },
                // Knappen er kun aktiv hvis man har accepteret vilkår og ikke er ved at loade
                enabled = acceptedTerms && !isLoading,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Burgundy,
                    disabledContainerColor = Color.Gray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                if (isLoading) {
                    // Viser den snurrende cirkel i stedet for tekst
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier.size(24.dp),
                        strokeWidth = 2.dp
                    )
                } else {
                    Text(text = "Betal Nu", fontSize = 18.sp, color = Color.White)
                }
            }
        } // Her lukker Column, så navigationen nedenfor kan ligge frit i Boxen

        // Bundmenuen placeres nederst i Boxen
        BottomNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            onHomeClick = { navController.navigate("home") },
            onFitClick = { navController.navigate("Fit") },
            onCartClick = { navController.navigate("Kurv") },
            onProfileClick = { navController.navigate("profile") }
        )
    }
}
