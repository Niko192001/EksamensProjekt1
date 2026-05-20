package com.example.neveranother.screens

import android.widget.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neveranother.components.PaymentOption
import com.example.neveranother.components.SummaryRow

@Composable
fun PaymentScreen(
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
                .padding(horizontal = 24.dp)
                .padding(top = 32.dp)
                .padding(120.dp)
        ) {
            //Titel
            Text(
                text = "Kurv 3",
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Betaling",
                fontSize = 22.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(24.dp))

            //Leveringsmetode
            Text(text = "Vælg Leveringsmetode", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(12.dp))

            PaymentOption(
                title = "MobilePay",
                isSelected = selectedMethod == "MobilePay",
                onClick = { selectedMethod = "MobilePay" }
            )

            PaymentOption(
                title = "Dankort/Visa",
                isSelected = selectedMethod == "Visa",
                onClick = { selectedMethod = "Visa" }
            )

            PaymentOption(
                title = "Klarna",
                isSelected = selectedMethod == "Klarna",
                onClick = { selectedMethod = "Klarna" }
            )

            PaymentOption(
                title = "Apple Pay",
                isSelected = selectedMethod == "ApplePay",
                onClick = { selectedMethod = "ApplePay" }
            )

            Spacer(modifier = Modifier.height(32.dp))

            //Opsummering
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                    .padding(20.dp)
            ) {
                SummaryRow("The Everday Bra", "799 Kr")
                SummaryRow("Levering", "39 kr")
                SummaryRow("I alt", "838 DKK")
            }

            Spacer(modifier = Modifier.height(32.dp))

            //Betal knap
            Button(
                onClick = {},
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
            modifier = Modifier.align(Alignment.BottomCenter)
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

