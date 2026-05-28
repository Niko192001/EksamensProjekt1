package com.example.neveranother.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.ui.res.painterResource



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.neveranother.R
import com.example.neveranother.components.VideoDialog
import com.example.neveranother.components.VideoGuideRow
import com.example.neveranother.navigation.BackButton
import com.example.neveranother.navigation.BottomNavigationBar
@Composable
fun VideoGuideRow(
    title: String,
    thumbnailRes: Int,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()

            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = thumbnailRes),
            contentDescription = title,
            modifier = Modifier
                .size(width = 110.dp, height = 70.dp),


        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                color = Color(0xFF6A1B1A),
                style = MaterialTheme.typography.titleMedium

            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFFE0E0E0))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "CM",
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "Se guide",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF6A1B1A)
                )
            }
        }
    }
}
