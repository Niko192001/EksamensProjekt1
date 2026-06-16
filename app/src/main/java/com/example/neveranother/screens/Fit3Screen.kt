package com.example.neveranother.screens

import android.R.attr.icon
import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.NavController
import com.example.neveranother.R
import com.example.neveranother.components.ScanInfoRow
import com.example.neveranother.navigation.BackButton
import kotlin.coroutines.coroutineContext
import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
// Ali
@Composable
fun Fit3ScanScreen(
    navController: NavController,
    onStartScan: () -> Unit
) {
    var imageBitmap by remember { mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        imageBitmap = bitmap
    }

    // gør at det er lodret
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            BackButton(navController = navController)
        }
        // Titel
        Text(
            text = "Scan din krop",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Black

        )
        Spacer(modifier = Modifier.height(8.dp))

        //Undertekst
        Text(
            text = "Få dine mål mål præcist og hurtigt med 3D scanning",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = painterResource(id = R.drawable.krop_gennemsigti),
            contentDescription = "Scan model",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)


        )

        Spacer(modifier = Modifier.height(70.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF0E6DE), RoundedCornerShape(12.dp))
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                ScanInfoRow(icon = R.drawable.ic_scan360, text = "360 scanning på få sekunder")
            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                ScanInfoRow(icon = R.drawable.ic_accuracy, text = "Præcise mål op til 97%")
            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                ScanInfoRow(icon = R.drawable.ic_privacy, text = "Dine billeder gemmes ikke")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        // Start scan knap
        Spacer(modifier = Modifier.height(100.dp))
        Button(

                onClick = { launcher.launch(null) },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6A1B1A),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "START SCAN", color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
