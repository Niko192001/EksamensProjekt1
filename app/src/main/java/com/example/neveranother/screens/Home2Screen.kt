package com.example.neveranother.screens

import androidx.activity.compose.ReportDrawn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import com.example.neveranother.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.neveranother.components.BraProductCard
import com.example.neveranother.components.VideoBackground
import com.example.neveranother.navigation.BackButton
import com.example.neveranother.navigation.BottomNavigationBar

// Nikolaj


@Composable
fun ChooseBraScreen(
    navController: NavController,
    onBraSelected: (String) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {

        // Video baggrund
        VideoBackground(videoRes = R.raw.home_video)

        // Mørk
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.2f))
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
                .verticalScroll(rememberScrollState())


        ) {

            Image(
                painter = painterResource(id = R.drawable.logo_png),
                contentDescription = "Never Another Logo",
                modifier = Modifier

                    .fillMaxWidth()

                    .height(100.dp),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = ("Vælg din BH"),
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Vores BH'er er designet til at tilpasse sig din krop - ikke omvendt",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            //Produktkort 1
            BraProductCard(
                title = "The Everyday Bra",
                description = "Blød komfort til hverdagens bevægelser",
                price = "799 kr.",
                imageRes = R.drawable.sortbh,
                onClick = { onBraSelected("black") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            //Produktkort 2
            BraProductCard(
                title = "The Weekend Bra",
                description = "Usynlig komfort under alt",
                price = "799 kr.",
                imageRes = R.drawable.hvidbh,
                onClick = { onBraSelected("white") }
            )

            Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5E6DC), RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null,
                        tint = Color(0xFF6A1B1A),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Dine oplysninger behandles fortroligt og deles ikke med tredjeparter.",
                        fontSize = 13.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(80.dp))

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
