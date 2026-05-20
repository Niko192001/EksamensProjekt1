package com.example.neveranother.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neveranother.components.ProgressStep
import com.example.neveranother.components.SummaryRow
import com.example.neveranother.screens.Burgundy
import com.example.neveranother.screens.BackgroundColor
import com.example.neveranother.screens.BottomNavigationBar

@Composable
fun OrderConfirmedScreen() {

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
                .padding(bottom = 120.dp)
        ) {
            // Titel
            Text(
                text = "Ordre bekræftet",
                fontSize = 22.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(24.dp))

            //ProgressBar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProgressStep(isActive = true)
                ProgressStep(isActive = true)
                ProgressStep(isActive = true)
                ProgressStep(isActive = true)
            }
            Spacer(modifier = Modifier.height(40.dp))

            //Stor cirkel med checkmark

            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(
                        Color(0xFF6A1B1A),
                        CircleShape
                    ),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "✓",
                    fontSize = 52.sp,
                    color = Color.White
                )
            }



            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Tak for din ordre!",
                fontSize = 26.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Vi har modtaget din ordre og er igang med at pakke den",
                fontSize = 15.sp,
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(32.dp))

            //Opsummeringsboks
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                    .padding(20.dp)
            ) {
                SummaryRow("Ordrenummer", "#NA123546")
                SummaryRow("Dato", "12. Maj 2025")
                SummaryRow("Levering", "6 uger")
            }
            Spacer(modifier = Modifier.height(32.dp))

            //Knapper
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(1.dp, Burgundy, RoundedCornerShape(12.dp))
            ) {
                Text(text = "Fortsæt til shop", fontSize = 18.sp, color = Burgundy)
            }
        }
        BottomNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

/*
OrderConfirmedScreen bygger hele “Ordre bekræftet”-siden op.
Den starter med en Box, som giver baggrund og placerer bundmenuen.
Indeni ligger en Column, der viser titel, progress‑indikator, checkmark‑ikon og tak‑besked i en lodret struktur.
En Row med fire ProgressStep‑komponenter viser, at alle ordretrin er fuldført.
Den store burgundy cirkel med “✓” giver en visuel bekræftelse på ordren.
En hvid opsummeringsboks viser ordrenummer, dato og levering.
Til sidst ligger to knapper: “Se min ordre” og “Fortsæt til shop”.
BottomNavigationBar placeres nederst, så navigationen altid er synlig.
 */