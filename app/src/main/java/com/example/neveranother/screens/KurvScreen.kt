package com.example.neveranother.screens

import androidx.compose.foundation.background

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.neveranother.navigation.BottomNavigationBar



import com.example.neveranother.R

// Baggrundsfarven
val BackgroundColor = Color(0xFFFAF5F2)

// Mørkerød farve
val Burgundy = Color(0xFF6A1B1A)

// Lys cirkelfarve til den aktive side i bundmenuen
val LightCircle = Color(0xFFEFDFD5)

//Beyza
@Composable
fun KurvScreen(navController: NavController) {
    var fornavn by remember { mutableStateOf("") }
    var efternavn by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefon by remember { mutableStateOf("") }
    var fodselsdato by remember { mutableStateOf("") }
    var adresse by remember { mutableStateOf("") }
    var postnummer by remember { mutableStateOf("") }
    var by by remember { mutableStateOf("") }
    var land by remember { mutableStateOf("") }

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
                text = "KURV",
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .background(Burgundy, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "1", color = Color.White, fontSize = 13.sp)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Dine oplysninger", fontSize = 20.sp, color = Color.Black)
            }
            Spacer(modifier = Modifier.height(20.dp))


            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),       // ← centrér i Column
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProgressDot(isActive = true)
                ProgressLine()
                ProgressDot(isActive = false)
                ProgressLine()
                ProgressDot(isActive = false)
                ProgressLine()
                ProgressDot(isActive = false)
            }
            Spacer(modifier = Modifier.height(28.dp))

            OutlinedTextField(
                value = fornavn,
                onValueChange = { fornavn = it },
                label = { Text("Fornavn") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = efternavn,
                onValueChange = { efternavn = it },
                label = { Text("Efternavn") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("E-mail") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = telefon,
                onValueChange = { if (it.all { c -> c.isDigit() }) telefon = it },
                label = { Text("Telefonnummer") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = fodselsdato,
                onValueChange = { fodselsdato = it },
                label = { Text("Fødselsdato") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Levering",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = adresse,
                onValueChange = { adresse = it },
                label = { Text("Adresse") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = postnummer,
                onValueChange = { if (it.all { c -> c.isDigit() }) postnummer = it },
                label = { Text("Postnummer") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = by,
                onValueChange = { by = it },
                label = { Text("By") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = land,
                onValueChange = { land = it },
                label = { Text("Land") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Button(
            onClick = { navController.navigate("Kurv3") },
            colors = ButtonDefaults.buttonColors(containerColor = Burgundy),
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 82.dp)
                .padding(horizontal = 36.dp)
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Fortsæt", fontSize = 22.sp, color = Color.White)
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

@Composable
fun ProgressLine() {
    Box(
        modifier = Modifier
            .height(1.dp)
            .width(60.dp)
            .background(Burgundy)
    )
}

@Composable
fun ProgressDot(isActive: Boolean) {
    Box(
        modifier = Modifier
            .size(10.dp)
            .background(
                if (isActive) Burgundy else BackgroundColor,
                CircleShape
            )
            .border(1.dp, Burgundy, CircleShape)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KurvScreenPreview() {
    KurvScreen(navController = rememberNavController())
}