package com.example.neveranother.screens
git commit -am "Change in screen 2"
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp

@Composable
fun MeasurementsScreen(

    // Lambda-funktion når brugeren klikker tilbage
    onBackClick: () -> Unit,

    // Lambda-funktion til opdater-knappen
    onUpdateClick: () -> Unit

) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F2ED))
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        // Tilbage-knap
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            IconButton(
                onClick = onBackClick
            ) {

            }
        }
    }
}

