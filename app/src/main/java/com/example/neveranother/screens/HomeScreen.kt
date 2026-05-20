package com.example.neveranother.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.neveranother.R
import com.example.neveranother.ui.theme.NeverAnotherTheme

@Composable
fun HomeScreen(
    onReadMoreClick: () -> Unit,
    onCreateBraClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(

            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "NEVER ANOTHER",
                fontSize = 28.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            //Header
            Text(
                text = "Din krop er unik. \n Skal din BH ikke også være det?",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "En skræddersyet bh til din krop og dine behov",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

            //Billede
            Image(
                painter = painterResource(id = R.drawable.home_bra_model),
                contentDescription = "Model med BH",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(24.dp))

            //Knapper
            Button(
                onClick = onReadMoreClick,
                modifier = Modifier
                    .width(130.dp)
                    .align(Alignment.Start),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6A1B1A) // Mørk rød farve som vores prototype
                )
            ) {
                Text("LÆS MERE")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onCreateBraClick,
                modifier = Modifier
                    .width(130.dp)
                    .align(Alignment.Start),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6A1B1A) //Mørk rød farve som vores wireframe
                )
            )
            {
                Text("LAV DIN BH")
            }
            Spacer(modifier = Modifier.height(32.dp))


        }
        BottomNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

/*
HomeScreen er en composable, der viser forsiden af appen og tager to callbacks: én til Læs mere og én til Lav din BH.
2. Hele layoutet ligger i en Box, så vi kan placere bundmenuen fast nederst.
3. Indholdet ligger i en Column, som scroller, så alt kan ses på små skærme.
4. Øverst viser vi “NEVER ANOTHER” som brand‑header.
5. Derefter kommer tre tekstsektioner, som introducerer konceptet og skaber en personlig tone.
6. Under teksten vises et billede af en model, som fylder hele bredden og giver visuelt fokus.
7. Efter billedet kommer to knapper, som er mindre og placeret til venstre for at matche designet.
8. onReadMoreClick og onCreateBraClick styrer navigationen videre til næste skærme.
9. Der er Spacer() mellem elementerne for at skabe luft og bedre læsbarhed.
10. Nederst i Box ligger BottomNavigationBar, så navigationen altid er synlig uanset scroll.
 */

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    NeverAnotherTheme {
        HomeScreen(
            onReadMoreClick = {},
            onCreateBraClick = {}
        )
    }
}
