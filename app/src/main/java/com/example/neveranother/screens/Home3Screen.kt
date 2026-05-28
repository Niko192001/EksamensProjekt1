package com.example.neveranother.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.neveranother.R
import com.example.neveranother.navigation.BackButton
import com.example.neveranother.navigation.BottomNavigationBar
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.graphics.ColorFilter
// Nikolaj
@Composable
fun AboutUsScreen(navController: NavController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 80.dp)
        ) {
            // Top: tilbage-knap + logo
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackButton(navController = navController)
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.logo_png),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(150.dp),

                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(Color.Black)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(16.dp))


            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .shadow(4.dp, RoundedCornerShape(12.dp))
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .padding(20.dp)
            ) {
                Column {
                    Text(
                        text = "Om os",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Never Another er en dansk virksomhed, der specialiserer sig i " +
                                "skræddersyede, bøjlefrie BH'er designet ud fra hver enkelt kvindes unikke mål. " +
                                "Deres mission er at skabe bedre pasform, højere komfort og en mere inkluderende " +
                                "oplevelse for kvinder, der ofte har svært ved at finde BH'er i deres størrelse. " +
                                "Med fokus på teknologi, kropsdiversitet og personlig tilpasning arbejder Never Another " +
                                "for at gøre det lettere og tryggere at finde en BH, der virkelig passer.",
                        fontSize = 17.sp,
                        color = Color.Black
                    )
                }
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