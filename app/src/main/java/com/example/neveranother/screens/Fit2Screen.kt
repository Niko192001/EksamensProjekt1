package com.example.neveranother.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.neveranother.ui.theme.BackgroundColor
import com.example.neveranother.R
import com.example.neveranother.components.VideoGuideRow
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import com.example.neveranother.components.VideoDialog
import com.example.neveranother.models.FitViewModel
import com.example.neveranother.navigation.BottomNavigationBar
// Ali
/**
 * FitVideoGuideScreen lader brugeren indtaste deres mål manuelt med videoguides som hjælp.
 * Den opdaterer den delte FitViewModel, så målene kan gemmes og vises senere i flowet.
 */
@Composable
fun FitVideoGuideScreen(
    navController: NavController,
    viewModel: FitViewModel,
    onContinueClick: () -> Unit
) {
    var selectedVideo by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Indtast dine mål her",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Upper Circumference
        VideoGuideRow(
            title = "Upper Circumference",
            thumbnailRes = R.drawable.thumb_1,
            onClick = { selectedVideo = R.raw.guide_video }
        )

        OutlinedTextField(
            value = viewModel.upperValue,
            onValueChange = { if (it.all { c -> c.isDigit() }) viewModel.upperValue = it },
            label = { Text("cm") },
            modifier = Modifier.width(210.dp),
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Lower Circumference
        VideoGuideRow(
            title = "Lower Circumference",
            thumbnailRes = R.drawable.thumb_2,
            onClick = { selectedVideo = R.raw.guide_video }
        )

        OutlinedTextField(
            value = viewModel.lowerValue,
            onValueChange = { if (it.all { c -> c.isDigit() }) viewModel.lowerValue = it },
            label = { Text("cm") },
            modifier = Modifier.width(210.dp),
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Breast Span
        VideoGuideRow(
            title = "Breast Span",
            thumbnailRes = R.drawable.thum3_3,
            onClick = { selectedVideo = R.raw.guide_video }
        )

        OutlinedTextField(
            value = viewModel.spanValue,
            onValueChange = { if (it.all { c -> c.isDigit() }) viewModel.spanValue = it },
            label = { Text("cm") },
            modifier = Modifier.width(210.dp),
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Breast Height
        VideoGuideRow(
            title = "Breast Height",
            thumbnailRes = R.drawable.thumb_4,
            onClick = { selectedVideo = R.raw.guide_video }
        )

        OutlinedTextField(
            value = viewModel.heightValue,
            onValueChange = { if (it.all { c -> c.isDigit() }) viewModel.heightValue = it },
            label = { Text("cm") },
            modifier = Modifier.width(210.dp),
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = onContinueClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6A1B1A),
                contentColor = Color.White
            )
        ) {
            Text("Fortsæt")
        }
    }

    // Video dialog
    if (selectedVideo != null) {
        VideoDialog(
            videoRes = selectedVideo!!,
            onDismiss = { selectedVideo = null }
        )
    }
}
