package com.example.neveranother.screens

import androidx.activity.compose.ReportDrawn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import com.example.neveranother.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neveranother.components.BraProductCard

@Composable
fun ChooseBraScreen(
    onBraSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "NEVER ANOTHER",
            fontSize = 28.sp,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = ("Vælg din BH"),
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Vores BH'er er designet til at tilpasse sig din krop - ikke omvendt",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        //Produktkort 1
        BraProductCard(
            title = "The Everyday Bra",
            description = "Blød komfort til hverdagens bevægelser",
            price = "799 kr.",
            imageRes = R.drawable.bra_black,
            onClick = { onBraSelected("black") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Produktkort 2
        BraProductCard(
            title = "The Everyday Bra",
            description = "Usynlig komfort under alt",
            price = "799 kr.",
            imageRes = R.drawable.white_bra,
            onClick = { onBraSelected("white") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Vælg den ønskede farve på din BH for at fortsætte til produktion af din personligt tilpasse model.",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )

    }
}