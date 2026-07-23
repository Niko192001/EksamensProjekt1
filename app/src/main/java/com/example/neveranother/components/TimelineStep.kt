package com.example.neveranother.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neveranother.ui.theme.Burgundy

@Composable
fun TimelineStep(
    title: String,
    date: String,
    isActive: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {

        // Cirkel
        Box(
            modifier = Modifier
                .size(14.dp)
                .background(
                    if (isActive) Burgundy else Color.Transparent,
                    CircleShape
                )
                .border(
                    width = 1.dp,
                    color = Burgundy,
                    shape = CircleShape
                )
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = title,
                fontSize = 16.sp,
                color = Color.Black
            )

            if (date.isNotEmpty()) {
                Text(
                    text = date,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(20.dp))
}