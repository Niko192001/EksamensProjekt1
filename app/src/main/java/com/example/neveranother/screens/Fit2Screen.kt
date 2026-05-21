package com.example.neveranother.screens

import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neveranother.R
import com.example.neveranother.components.VideoGuideRow

@Composable
fun FitVideoGuideScreen(
    onUpperClick: () -> Unit,
    onLowerClick: () -> Unit,
    onSpanClick: () -> Unit,
    onHeightClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Video Guide",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Se hvordan måler selv korrekt",
            style = MaterialTheme.typography.bodyMedium
        )
        // den skaber plads mellem tingene
        Spacer(modifier = Modifier.height(24.dp))
// video boxen
        VideoGuideRow(
            title = "Upper Circumference",
            thumbnailRes = R.drawable.thumb_upper,
            onClick = onUpperClick
        )
        Spacer(modifier = Modifier.height(12.dp))

        VideoGuideRow(
            title = "Lower Circumference",
            thumbnailRes = R.drawable.thumb_lower,
            onClick = onLowerClick
        )
        Spacer(modifier = Modifier.height(12.dp))

        VideoGuideRow(
            title = "Breast Span",
            thumbnailRes = R.drawable.thumb_span,
            onClick = onSpanClick
        )
        Spacer(modifier = Modifier.height(12.dp))

        VideoGuideRow(
            title = "Breast height",
            thumbnailRes = R.drawable.thumb_height,
            onClick = onHeightClick
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onContinueClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6A1B1A), // Den mørkerøde farve til vores knap
                contentColor = Color.White
            )
        ) {
            Text(text = "FORTSÆT")
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
