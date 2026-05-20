package com.example.neveranother.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Baggrundsfarven
val BackgroundColor = Color(0xFFFAF5F2)

// Mørkerød farve
val Burgundy = Color(0xFFF3F3F3)

// Lys cirkelfarve til den aktive side i bundmenuen
val LightCircle = Color(0xFFEFDFD5)

@Composable
fun KurvScreen() {

    // Box bruges som den store container for hele siden.
    // Den gør det nemt at placere indhold, knap og bundnavigation oven på hinanden.
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {

        // Denne Column indeholder alt det indhold, som skal kunne scrolles.
        Column(
            modifier = Modifier
                .fillMaxSize()

                // Denne linje gør siden scrollbar.
                .verticalScroll(rememberScrollState())

                // Luft fra venstre og højre side
                .padding(horizontal = 24.dp)

                // Luft fra toppen
                .padding(top = 32.dp)

                // Ekstra luft nederst, så indhold ikke ligger bag knap og bundnavigation
                .padding(bottom = 170.dp)
        ) {

            // Titel øverst på siden
            Text(
                text = "KURV",
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Første step: Dine oplysninger
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {

                // Mørkerød cirkel med tallet 1
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .background(Burgundy, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "1",
                        color = Color.White,
                        fontSize = 13.sp
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Dine oplysninger",
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Progress-linje med 4 punkter
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 72.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Første punkt er aktivt
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(Burgundy, CircleShape)
                )

                ProgressLine()

                // Punkt 2
                EmptyProgressDot()

                ProgressLine()

                // Punkt 3
                EmptyProgressDot()

                ProgressLine()

                // Punkt 4
                EmptyProgressDot()
            }

            Spacer(modifier = Modifier.height(28.dp))

            // Inputfelter
            InputField(
                label = "Fornavn",
                value = "Emma"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputField(
                label = "Efternavn",
                value = "Andersen"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputField(
                label = "E-mail",
                value = "emma.andersen@hotmail.com"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputField(
                label = "Telefonnummer",
                value = "+45 12 34 56 78"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputField(
                label = "Fødselsdato",
                value = "12/05-2000",
                showCalendarIcon = true
            )

            // Her laver vi ekstra indhold, så du kan teste scroll.
            // Senere kan vi erstatte dette med Levering, Pakkeshop, Adresse osv.
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Levering",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputField(
                label = "Adresse",
                value = "Svanemøllevej 42 3.th"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputField(
                label = "Postnummer",
                value = "2100"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputField(
                label = "By",
                value = "København Ø"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputField(
                label = "Land",
                value = "Danmark"
            )
        }

        // Fortsæt-knappen ligger fast nederst.
        // Den scroller ikke med siden.
        Button(
            onClick = {
                // Her kan vi senere skrive navigation til næste side
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Burgundy
            ),
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 82.dp)
                .padding(horizontal = 36.dp)
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Fortsæt",
                fontSize = 22.sp,
                color = Color.White
            )
        }

        // Bundnavigation ligger fast nederst.
        BottomNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

// Denne funktion laver ét inputfelt.
// Vi genbruger den, så vi ikke skal skrive samme design igen og igen.
@Composable
fun InputField(
    label: String,
    value: String,
    showCalendarIcon: Boolean = false
) {
    Column {

        // Label over inputfeltet
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(7.dp))

        // Selve inputboksen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(8.dp)
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = value,
                fontSize = 15.sp,
                color = Color.Black
            )

            // Kalenderikon vises kun på fødselsdato-feltet
            if (showCalendarIcon) {
                Icon(
                    imageVector = Icons.Outlined.CalendarToday,
                    contentDescription = "Kalender",
                    tint = Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(20.dp)
                )
            }
        }
    }
}

// Lille linje mellem progress-punkterne
@Composable
fun ProgressLine() {
    Box(
        modifier = Modifier
            .height(1.dp)
            .width(45.dp)
            .background(Burgundy)
    )
}

// Tom progress-prik
@Composable
fun EmptyProgressDot() {
    Box(
        modifier = Modifier
            .size(8.dp)
            .background(BackgroundColor, CircleShape)
            .border(1.dp, Burgundy, CircleShape)
    )
}

// Bundnavigationen nederst
@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(BackgroundColor)
            .border(1.dp, Color.Black),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Outlined.Home,
            contentDescription = "Hjem",
            modifier = Modifier.size(30.dp),
            tint = Color.Black
        )

        // Midlertidigt bruger vi Home-ikon til Fit.
        // Senere kan vi skifte det ud med jeres eget målebåndsikon.
        Icon(
            imageVector = Icons.Outlined.Home,
            contentDescription = "Fit",
            modifier = Modifier.size(30.dp),
            tint = Color.Black
        )

        // Kurv er aktiv side, derfor får den en lys cirkel bag sig
        Box(
            modifier = Modifier
                .size(42.dp)
                .background(LightCircle, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "Kurv",
                modifier = Modifier.size(29.dp),
                tint = Color.Black
            )
        }

        Icon(
            imageVector = Icons.Outlined.Person,
            contentDescription = "Profil",
            modifier = Modifier.size(31.dp),
            tint = Color.Black
        )
    }
}