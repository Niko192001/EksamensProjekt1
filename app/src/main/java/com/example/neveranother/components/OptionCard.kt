package com.example.neveranother.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OptionCard(
    title: String,
    description: String,
    imageRes: Int,
    onClick: () -> Unit
)
{
    Card(
        modifier = Modifier
            .fillMaxWidth()

            .shadow(80.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),

        colors = CardDefaults.cardColors(containerColor = Color.White)

    ) {
        Row(modifier = Modifier.padding(40.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(Color(0xFFE8DDD5), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                // Ikon
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier.size(45.dp)
                )
            }
            Spacer(
                modifier = Modifier
                    .width(16.dp)
                    .shadow(500.dp)
            )
            // Tekster
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
                Text(description, fontSize = 13.sp, color = Color.Black)

            }
        }
    }
}