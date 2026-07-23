package com.example.neveranother.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.neveranother.components.TimelineStep
import com.example.neveranother.navigation.BottomNavigationBar
import com.example.neveranother.ui.theme.BackgroundColor
import com.example.neveranother.ui.theme.Burgundy


// Nikolaj
@Composable
fun OrderStatusScreen(
    navController: NavController,
    ) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .padding(top = 32.dp)
                .padding(bottom = 120.dp)
        ) {
            //Titel
            Text(
                text = "Profil",
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))

            //Leveringstabel
            Box(
                modifier = Modifier
                    .align(Alignment.End)
                    .background(Burgundy, RoundedCornerShape(8.dp))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "Levering 23. Juni",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            //Ordrenummer
            Text(
                text = "#NA12546",
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(24.dp))

            //Timeline
            TimelineStep(
                title = "Ordre bekræftet",
                date = "12. Maj 2025",
                isActive = true
            )
            TimelineStep(
                title = "Pakket",
                date = "10. Juni 2025",
                isActive = true
            )
            TimelineStep(
                title = "Sendt",
                date = "",
                isActive = false
            )
            TimelineStep(
                title = "Forventet Levering",
                date = "23. Juni 2025",
                isActive = false
            )
            Spacer(modifier = Modifier.height(32.dp))

            //Knap
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Burgundy
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Se din ordre detaljer",
                    fontSize = 18.sp,
                    color = Color.White
                )
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

/*
OrderStatusScreen bygger hele siden op:
• En Box danner baggrunden og holder alt indholdet.
• Indeni ligger en Column, som viser titel, ordreinfo og timeline i en lodret liste.
• En lille label‑boks viser forventet leveringsdato.
• TimelineStep bruges flere gange til at vise ordrestatus‑punkterne.
• En stor knap nederst giver adgang til ordredetaljer.
• Til sidst placeres BottomNavigationBar fast i bunden af skærmen.
 */


