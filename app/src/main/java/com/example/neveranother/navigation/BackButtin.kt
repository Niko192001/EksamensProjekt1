package com.example.neveranother.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.navigation.NavController



import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint


@Composable
fun BackButton (navController: NavController){
    IconButton(onClick = { navController.popBackStack() }) {
        Icon (imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Tilbage",
            tint = Color.Black
        )

    }
}