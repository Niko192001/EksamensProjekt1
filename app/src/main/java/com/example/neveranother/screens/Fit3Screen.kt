package com.example.neveranother.screens

import android.R.attr.icon
import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.neveranother.R
import com.example.neveranother.components.ScanInfoRow
import kotlin.coroutines.coroutineContext

@Composable
fun Fit3ScanScreen(
    onStartScan: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Titel
        Text(
            text = "Scan din krop",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))

        //Undertekst
        Text(
            text = "Få dine mål mål præcist og hurtigt med 3D scanning",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(24.dp))

        //info ikoner
        ScanInfoRow(
            icon = R.drawable.ic_scan360,
            text = "360 scanning på få sekunder"
        )
        Spacer(modifier = Modifier.height(12.dp))

        ScanInfoRow(
            icon = R.drawable.ic_accuracy,
            text = "Præcise mål op til 97%"
        )
        Spacer(modifier = Modifier.height(12.dp))

        ScanInfoRow(
            icon = R.drawable.ic_privacy,
            text = "Dine billeder gemmes ikke"
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Start scan knap
        Button(
            onClick = onStartScan,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6A1B1A),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "START SCAN"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}