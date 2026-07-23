package com.example.neveranother.screens

import android.accessibilityservice.GestureDescription
import android.widget.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.neveranother.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.neveranother.components.BottomNavBar
import androidx.compose.material3.*
import androidx.compose.material3.AlertDialogDefaults.containerColor

import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.Composable
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.neveranother.ui.theme.BackgroundColor
import com.example.neveranother.navigation.BackButton
import com.example.neveranother.navigation.BottomNavigationBar

// Ali

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitScreen(
    navController: NavController,
    onManuelClick: () -> Unit,
    on3dClick: () -> Unit
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""

    // det er en måde at grupper det på ligesom at bruge fx box
    Scaffold(
        containerColor = BackgroundColor,
        // det er en måde at lave en bar i toppen og have ting i toppe fx som back knap
        topBar = {

            CenterAlignedTopAppBar(
                title = { Text("FIT", color = Color.Black) },
                navigationIcon = {
                    BackButton(navController = navController)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = BackgroundColor,


                    ),
            )
        },


        bottomBar = {
            Modifier
                .background(BackgroundColor)
            BottomNavigationBar(
                currentRoute = currentRoute,
                onHomeClick = { navController.navigate("home") },
                onFitClick = { navController.navigate("Fit") },
                onCartClick = { navController.navigate("Kurv") },
                onProfileClick = { navController.navigate("profile") }


            )
        }

    ) { innerpadding ->
        Column(

            modifier = Modifier
                .padding(innerpadding)
                .background(BackgroundColor)
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Text(
                "Find din perfekte pasform",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Beskrivelse
            Text(
                "For at finde den BH der passer bedst til dig, skal vi bruge dine mål.",
                textAlign = TextAlign.Center,
                color = Color.Black,

                )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                "Hvordan vil du oplyse dine mål?",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(70.dp))
            // OptionCard 1
            OptionCard(
                title = "Skriv dine mål ind",
                description = "Indtast dine mål manuelt, så vi kan finde den bedste pasform til dig.",
                onClick = onManuelClick,
                imageRes = R.drawable.fit_ikon,

                )
            Spacer(modifier = Modifier.height(50.dp))
            // OptionCard 2
            OptionCard(
                title = "Scan din krop",
                description = "Brug vores scanning til at få dine mål præcist og hurtigt.",
                onClick = on3dClick,
                imageRes = R.drawable.krop_ikon,

                )

        }


    }


}

// Her er funktionerne
@Composable
fun OptionCard(title: String, description: String, imageRes: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()

            .shadow(80.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),

        colors = CardDefaults.cardColors(containerColor = Color.White)

    ) {
        Row(modifier = Modifier.padding(40.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(Color(0xFFE8DDD5), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                // Ikon
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier.size(45.dp)
                )
            }
            Spacer(
                modifier = Modifier
                    .width(16.dp)
                    .shadow(500.dp)
            )
            // Tekster
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
                Text(description, fontSize = 13.sp, color = Color.Black)

            }
        }
    }
}

// det der gør vi ka se den i preview
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun FitScreenPreview() {
    FitScreen(
        navController = rememberNavController(),
        onManuelClick = {},
        on3dClick = {}
    )
}


