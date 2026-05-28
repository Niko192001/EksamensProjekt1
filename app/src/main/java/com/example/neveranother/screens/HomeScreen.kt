package com.example.neveranother.screens

import android.R.attr.top
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.neveranother.R
import com.example.neveranother.components.VideoBackground
import com.example.neveranother.navigation.BottomNavigationBar
import com.example.neveranother.ui.theme.NeverAnotherTheme
// nikolaj
@Composable
fun HomeScreen(
    navController: NavController,
    onReadMoreClick: () -> Unit,
    onCreateBraClick: () -> Unit

) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""
    Box(modifier = Modifier.fillMaxSize()) {


        VideoBackground(videoRes = R.raw.home_video)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.2f))


        )

        Column(

            modifier = Modifier
                .fillMaxSize()

                .verticalScroll(rememberScrollState())


                .padding(start = 16.dp, end = 16.dp),

            horizontalAlignment = Alignment.CenterHorizontally

        )


        {
            Image(
                painter = painterResource(id = R.drawable.logo_png),
                contentDescription = "Model med BH",
                modifier = Modifier
                    .fillMaxWidth()

                    .height(150.dp),
                contentScale = ContentScale.FillWidth
            )

            //Header
            Text(
                text = "Din krop er unik!\nSkal din BH ikke også være det?",
            Spacer(modifier = Modifier.height(20.dp))

            //Header
            Text(
                text = "Din krop er unik! \n Skal din BH ikke også være det?",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(12.dp))
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "En skræddersyet bh til din krop og dine behov",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                textAlign = TextAlign.Left

            )

            //Billede

            Spacer(modifier = Modifier.height(70.dp))

            //Knapper

            Button(
                onClick = onReadMoreClick,
                modifier = Modifier
                    .width(180.dp)
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

                    .width(180.dp)
                    .align(Alignment.Start),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6A1B1A) //Mørk rød farve som vores wireframe
                )
            )
            {
                Text("MÅL OP TIL DIN BH", color = Color.White)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onReadMoreClick,
                modifier = Modifier
                    .width(180.dp)
                    .align(Alignment.Start),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6A1B1A) // Mørk rød farve som vores prototype
                )
            ) {
                Text("OM OS", color = Color.White)
                Text("MÅL OP TIL DIN BH")
            }

        }
        BottomNavigationBar(

            modifier = Modifier.align(Alignment.BottomCenter),
            currentRoute = currentRoute,

            onHomeClick = { navController.navigate("home") },
            onFitClick = { navController.navigate("Fit") },
            onCartClick = { navController.navigate("Kurv") },
            onProfileClick = { navController.navigate("profile") }


        )
    }
}

/*
HomeScreen er en composable, der viser forsiden af appen og tager to callbacks: én til Læs mere og én til Lav din BH.
2. Hele layoutet ligger i en Box, så vi kan placere bundmenuen fast nederst.
3. Indholdet ligger i en Column, som scroller, så alt kan ses på små skærme.
4. Øverst viser vi NEVER ANOTHER som brand‑header.
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
            navController = rememberNavController(),
            onReadMoreClick = {},
            onCreateBraClick = {}
        )
    }
}

