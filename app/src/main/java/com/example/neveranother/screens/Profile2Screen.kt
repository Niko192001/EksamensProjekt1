package com.example.neveranother.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neveranother.R
import com.example.neveranother.ui.theme.BackgroundColor
import com.example.neveranother.ui.theme.Burgundy
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.neveranother.navigation.BottomNavigationBar

//Amira
@Composable
fun Profile2Screen(
    navController: NavController,
    onBackClick: () -> Unit,
    onStartScan: () -> Unit
) {
    // Den her linje viser man hvilken side man er på
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""

    Scaffold(
        bottomBar = {
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
            .fillMaxSize()
            .background(BackgroundColor)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(15.dp))

        // Row placerer elementer vandret
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            // IconButton laver en klikbar ikon-knap
            IconButton(onClick = onBackClick) {
                Icon(
                    // Vælger tilbage-pil ikonet
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Tilbage"
                )
            }
        }
        //Titel øverst
        Text(
            text = "PROFIL",
            fontSize = 16.sp,
            color = Color.Black

        )

        Spacer(modifier = Modifier.height(20.dp))

        // Box bruges til at placere fluebenet i midten
        Box(
            modifier = Modifier
                .size(100.dp)
                .border(
                    width = 1.dp,
                    color = Burgundy,
                    shape = CircleShape
                )
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "✓",
                fontSize = 42.sp,
                color = Color(0xFF6A1B1A)
            )
        }


        Spacer(modifier = Modifier.height(30.dp))

        // Overskrift
        Text(
            text = "Dine mål er klar",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Tak! Vi har nu dine præcise mål.",
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(25.dp))

        // Image composable viser billedet fra drawable
        Image(
            painter = painterResource(
                id = R.drawable.full_body_illustration
            ),
            contentDescription = "Målinger",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        // weight(1f) skubber knappen ned mod bunden
        Spacer(modifier = Modifier.weight(1f))


        // Opdatere mål knappen
        Button(

            // Lambda-funktion når brugeren klikker
            onClick = onStartScan,
            modifier = Modifier

                .fillMaxWidth()
                .height(52.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Burgundy,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "OPDATERE MINE MÅL"
            )
        }


        Spacer(modifier = Modifier.height(16.dp))


    }
}
}


/*
 koden laver en anden profilside i Jetpack Compose. Column bruges til at
 placere alt indhold lodret på siden, mens Row bruges til tilbage-pilen øverst.
 Modifier styrer layoutet, fx størrelse, padding og baggrundsfarve.
Tilbage-pilen laves med IconButton og Icon, hvor Icons.Outlined.ArrowBack
 er et indbygget ikon fra Compose. Fluebenet i midten laves med Box, som bruges til at
 centrere teksten inde i cirklen.
Billedet vises med Image, hvor painterResource henter billedet fra
 drawable-mappen. Nederst bruges en Button til “OPDATERE MINE MÅL”.
  Når brugeren klikker på knappen, kører lambda-funktionen onStartScan.
 */