package com.example.neveranother.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.neveranother.ui.theme.NeverAnotherTheme
import com.example.neveranother.components.PaymentOption
import com.example.neveranother.components.SummaryRow
import com.example.neveranother.navigation.BottomNavigationBar
import androidx.navigation.NavController
import com.example.neveranother.R

// Nikolaj
@Composable
fun PaymentScreen(
    navController: NavController,
    onContinue: () -> Unit

) {

    var selectedMethod by remember { mutableStateOf("MobilePay") }

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
                .padding(bottom = 170.dp)
        ) {


            Text(
                text = "",
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Betaling",
                color = Color.Black,
                fontSize = 22.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(24.dp))


            Text(
                text = "Vælg Leveringsmetode", fontSize = 16.sp,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(12.dp))

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

            Spacer(modifier = Modifier.height(32.dp))


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

            Spacer(modifier = Modifier.height(32.dp))

            //Betal knap
            Button(
                onClick = { navController.navigate("Kurv8") },

                colors = ButtonDefaults.buttonColors(containerColor = Burgundy),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Betal Nu", fontSize = 18.sp, color = Color.White)
            }
        }
        BottomNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            onHomeClick = { navController.navigate("home") },
            onFitClick = { navController.navigate("Fit") },
            onCartClick = { navController.navigate("Kurv") },
            onProfileClick = {
                navController.navigate("profile")
            }
        )


    }
}

/*
PaymentScreen viser den sidste del af checkout‑flowet, hvor brugeren vælger betalingsmetode og ser en opsummering af sin ordre.
Skærmen starter med en Box, der giver baggrund og holder bundmenuen fast nederst.
Indholdet ligger i en Column, som viser titel, betalingsvalg og ordresummering i en lodret struktur.
Brugeren kan vælge mellem fire betalingsmetoder, hvor selectedMethod styrer hvilket felt der er markeret.
Hver betalingsmulighed vises med en genbrugelig PaymentOption‑komponent, som ændrer farve og kant når den er valgt.
Under betalingsvalgene ligger en hvid opsummeringsboks, der viser pris, levering og total.
Til sidst vises en stor burgundy “BETAL NU”‑knap, som afslutter købet.
BottomNavigationBar placeres nederst, så navigationen altid er synlig.
 */

