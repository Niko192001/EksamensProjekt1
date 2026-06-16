    package com.example.neveranother.screens

    import android.R.attr.onClick
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.gestures.scrollable
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.rememberScrollState
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.foundation.text.KeyboardOptions
    import androidx.compose.foundation.verticalScroll
    import androidx.compose.material3.Button
    import androidx.compose.material3.ButtonDefaults
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.OutlinedTextField
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
    import androidx.navigation.NavController
    import com.example.neveranother.navigation.BackButton
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.text.input.KeyboardType
    import com.example.neveranother.components.VideoDialog
    import com.example.neveranother.navigation.BottomNavigationBar

/// Ali
var upperValue by mutableStateOf("")
    var lowerValue by mutableStateOf("")
    var spanValue by mutableStateOf("")
    var heightValue by mutableStateOf("")
    @Composable
    fun FitVideoGuideScreen(
        navController: NavController,
        onUpperClick: () -> Unit,
        onLowerClick: () -> Unit,
        onSpanClick: () -> Unit,
        onHeightClick: () -> Unit,
        onContinueClick: () -> Unit
    ) {
        var selectedVideo by remember { mutableStateOf<Int?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor)
                .padding(16.dp)
                .padding(bottom = 80.dp)
                .verticalScroll(rememberScrollState())
        ) {
            BackButton(navController = navController)

            Text(
                text = "Video Guide",
                color = Color.Black,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Se hvordan måler selv korrekt",
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(20.dp))


            VideoGuideRow(
                title = "Upper Circumference",
                thumbnailRes = R.drawable.thum1_1,
                onClick = { selectedVideo = R.raw.guide_video }
            )
            OutlinedTextField(
                value = upperValue,
                onValueChange = { if (it.all { c -> c.isDigit() }) upperValue = it },
                label = { Text("cm") },

                modifier = Modifier.width(210.dp),
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(20.dp))


            VideoGuideRow(
                title = "Lower Circumference",
                thumbnailRes = R.drawable.thum2_2,
                onClick = { selectedVideo = R.raw.guide_video }
            )
            OutlinedTextField(
                value = lowerValue,
                onValueChange = { if (it.all { c -> c.isDigit() }) lowerValue = it },
                label = { Text("cm") },

                modifier = Modifier.width(210.dp),
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(20.dp))


            VideoGuideRow(
                title = "Breast Span",
                thumbnailRes = R.drawable.thum3_3,
                onClick = { selectedVideo = R.raw.guide_video }
            )
            OutlinedTextField(
                value = spanValue,
                onValueChange = { if (it.all { c -> c.isDigit() }) spanValue = it },
                label = { Text("cm") },

                modifier = Modifier.width(210.dp),
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(20.dp))


            VideoGuideRow(
                title = "Breast height",
                thumbnailRes = R.drawable.thum4_4,
                onClick = { selectedVideo = R.raw.guide_video }
            )
            OutlinedTextField(
                value = heightValue,
                onValueChange = { if (it.all { c -> c.isDigit() }) heightValue = it },
                label = { Text("cm") },
                modifier = Modifier.width(210.dp),

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
                Text(text = "FORTSÆT")
            }

            Spacer(modifier = Modifier.height(10.dp))
        }

        BottomNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            onHomeClick = { navController.navigate("home") },
            onFitClick = { navController.navigate("Fit") },
            onCartClick = { navController.navigate("Kurv") },
            onProfileClick = { navController.navigate("profile") }
        )
        /*
        Hvis selectedVideo ikke er null → koden inde i if‑blokken bliver kørt

        • Hvis selectedVideo er null → koden bliver sprunget over
         */
        if (selectedVideo != null) {
            VideoDialog(
                videoRes = selectedVideo!!,
                onDismiss = { selectedVideo = null }
            )
        }
    }
}
