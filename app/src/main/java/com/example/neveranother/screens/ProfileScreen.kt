package com.example.neveranother.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.neveranother.navigation.BottomNavigationBar
//Amira
@Composable
fun ProfileScreen(
    navController: NavController,
    // Lambda-funktioner som bruges når brugeren klikker (husk til eksamen) parametrer
    onMeasurementsClick: () -> Unit,
    onOrderStatusClick: () -> Unit,
    onSettingsClick: () -> Unit

) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""
    Scaffold(bottomBar = {
        BottomNavigationBar(

            currentRoute = currentRoute,
            onHomeClick = { navController.navigate("home") },
            onFitClick = { navController.navigate("Fit") },
            onCartClick = { navController.navigate("Kurv") },
            onProfileClick = { navController.navigate("profile") }


        )
    }
    ) { innerpadding ->


        // Column placerer elementer lodret under hinanden

        Column(
            modifier = Modifier
                .padding(innerpadding)
                // Fylder hele skærmen
                .fillMaxSize()

                // Baggrundsfarve
                .background(Color(0xFFF8F2ED))

                // Padding rundt om indholdet
                .padding(30.dp),

            // Centrerer elementerne vandret
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Overskrift / header
            Text(
                text = "PROFIL",
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Box bruges her til at lave profil-cirklen
            Box(

                modifier = Modifier

                    // Størrelse på cirklen
                    .size(90.dp)

                    // Baggrund og form
                    .background(
                        Color(0xFF7A1F2B),
                        CircleShape
                    ),

                // Centrerer teksten inde i cirklen
                contentAlignment = Alignment.Center

            ) {

                Text(
                    text = "EA",
                    color = Color.White,
                    fontSize = 28.sp
                )
            }

            Spacer(modifier = Modifier.height(30.dp))


            // Ny Column så teksten bliver venstrejusteret
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Hej Emma",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Tak fordi du er en del af",
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Never Another.",
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(28.dp))

                // Linje som deler sektionerne
                HorizontalDivider(
                    color = Color(0xFFE6D3CF)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "DINE MÅL",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Sidst opdateret 12 maj. 2026",
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Button er en klikbar knap
                Button(

                    // Lambda-funktion der kører ved klik
                    onClick = onMeasurementsClick,

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),

                    // Runde hjørner
                    shape = RoundedCornerShape(30.dp),

                    // Farver på knappen
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFEFDFD5),
                        contentColor = Color(0xFF7A1F2B)
                    )

                ) {

                    Text(
                        text = "SE MINE MÅL",
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(35.dp))

                HorizontalDivider(
                    color = Color(0xFFE6D3CF)
                )

                // Genbrugt composable til menu-punkter
                ProfileMenuItem(

                    title = "ORDRE STATUS",

                    subtitle = "Følg din ordre",

                    // Lambda-funktion
                    onClick = onOrderStatusClick
                )

                HorizontalDivider(
                    color = Color(0xFFE6D3CF)
                )

                ProfileMenuItem(

                    title = "INDSTILLINGER",

                    subtitle = "Notifikationer, adresse, betaling\nm.m",

                    onClick = onSettingsClick
                )

                HorizontalDivider(
                    color = Color(0xFFE6D3CF)
                )
            }


        }
    }
}

// Genbrugbart composable til menu-sektionerne
@Composable
fun ProfileMenuItem(

    title: String,
    subtitle: String,

    // Lambda-funktion ved klik
    onClick: () -> Unit

) {

    // TextButton gør hele området klikbart
    TextButton(

        onClick = onClick,

        modifier = Modifier.fillMaxWidth()

    ) {


        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 18.dp),

            verticalAlignment = Alignment.CenterVertically

        ) {

            Column(

                // weight gør at teksten tager den ledige plads
                modifier = Modifier.weight(1f),

                horizontalAlignment = Alignment.Start

            ) {

                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = subtitle,
                    color = Color.Black
                )
            }
        }
    }
}



//Koden laver en profilside i Jetpack Compose ved hjælp af composables som Column,
// Row, Box, Text og Button. Column bruges til at placere elementer lodret, mens Row placerer
// elementer vandret. Modifier bruges til at styre layout, fx størrelse, padding og baggrundsfarve.
//Profilcirklen laves med Box, hvor teksten “EA” centreres inde i cirklen.
// Knappen “SE MINE MÅL” bruger en lambda-funktion (onMeasurementsClick),
// som kører når brugeren klikker. ProfileMenuItem er et genbrugeligt composable til menu-punkterne
// som “ORDRE STATUS” og “INDSTILLINGER”.
