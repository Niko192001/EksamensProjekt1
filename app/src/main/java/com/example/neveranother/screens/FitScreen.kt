package com.example.neveranother.screens

import android.accessibilityservice.GestureDescription
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.Color
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


import androidx.compose.runtime.Composable
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.tooling.preview.Preview
import com.example.neveranother.ui.theme.NeverAnotherTheme
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Fitscreen(
    onManuelClick: () -> Unit,
    on3dClick: () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FIT")},

                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "tilbage")
                    }



                }
            )
        }
    ) { innerpadding  ->
        Column(
            modifier = Modifier
                .padding(innerpadding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Find din perfekte pasform", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "For at finde den BH der passer bedst til dig, skal vi bruge dine mål.",
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text("Hvordan vil du oplyse dine mål?", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))

            OptionCard(
                title = "Skriv dine mål ind",
                description = "Indtast dine mål manuelt, så vi kan finde den bedste pasform til dig.",
                onClick = onManuelClick
            )
            Spacer(modifier = Modifier.height(16.dp))
            OptionCard(
                title = "Scan din krop",
                description = "Brug vores scanning til at få dine mål præcist og hurtigt.",
                onClick = on3dClick
            )
        } }
}

@Composable
fun OptionCard(title: String, description: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F0EC))
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(56.dp).background(Color(0xFFE8DDD5), CircleShape))
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(description, fontSize = 13.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FitscreenPreview() {
    NeverAnotherTheme {
        Fitscreen(
            onManuelClick = {},
            on3dClick = {}
        )
    }
}