package com.example.neveranother.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.neveranother.ui.theme.Burgundy

@Composable
fun ProgressStep(isActive: Boolean) {
    Box(
        modifier = Modifier
            .size(18.dp)
            .background(
                if (isActive) Burgundy else Color.Transparent,
                CircleShape
            )
            .border(2.dp, Burgundy, CircleShape)
    )
}
