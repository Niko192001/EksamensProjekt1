package com.example.neveranother.screens

import androidx.compose.foundation.background

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.neveranother.navigation.BottomNavigationBar


import com.example.neveranother.R
import com.example.neveranother.ui.theme.BackgroundColor
import com.example.neveranother.ui.theme.Burgundy
import com.example.neveranother.ui.theme.LightCircle

//Beyza
@Composable                 //Type eller Class
fun KurvScreen(navController: NavController) {
    var fornavn by rememberSaveable { mutableStateOf("") }
    var efternavn by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var telefon by rememberSaveable { mutableStateOf("") }
    var fødselsdato by rememberSaveable { mutableStateOf("") }
    var adresse by rememberSaveable { mutableStateOf("") }
    var postnummer by rememberSaveable { mutableStateOf("") }
    var by by rememberSaveable { mutableStateOf("") }
    var land by rememberSaveable { mutableStateOf("") }

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
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = efternavn,
                onValueChange = { efternavn = it },
                label = { Text("Efternavn") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("E-mail") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = telefon,
                onValueChange = { if (it.all { c -> c.isDigit() }) telefon = it },
                label = { Text("Telefonnummer") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = fødselsdato,
                onValueChange = { fødselsdato = it },
                label = { Text("Fødselsdato") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
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
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = postnummer,
                onValueChange = { if (it.all { c -> c.isDigit() }) postnummer = it },
                label = { Text("Postnummer") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = by,
                onValueChange = { by = it },
                label = { Text("By") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = land,
                onValueChange = { land = it },
                label = { Text("Land") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
            )
        }

        val isFormValid = fornavn.isNotBlank() && efternavn.isNotBlank() &&
                email.contains("@") && adresse.isNotBlank()

        Button(
            onClick = { navController.navigate("Kurv3") },
            enabled = isFormValid,
            colors = ButtonDefaults.buttonColors(
                containerColor = Burgundy,
                disabledContainerColor = Color.Gray
            ),
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