package com.example.neveranother.screens

import androidx.activity.compose.ReportDrawn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import com.example.neveranother.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neveranother.components.BraProductCard
import com.example.neveranother.ui.theme.NeverAnotherTheme

@Composable
fun ChooseBraScreen(
    onBraSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "NEVER ANOTHER",
            fontSize = 28.sp,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = ("Vælg din BH"),
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Vores BH'er er designet til at tilpasse sig din krop - ikke omvendt",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        //Produktkort 1
        BraProductCard(
            title = "The Everyday Bra",
            description = "Blød komfort til hverdagens bevægelser",
            price = "799 kr.",
            imageRes = R.drawable.bra_black,
            onClick = { onBraSelected("black") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Produktkort 2
        BraProductCard(
            title = "The Weekend Bra",
            description = "Usynlig komfort under alt",
            price = "799 kr.",
            imageRes = R.drawable.white_bra,
            onClick = { onBraSelected("white") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Vælg den ønskede farve på din BH for at fortsætte til produktion af din personligt tilpasse model.",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )

    }
}

/*
1. ChooseBraScreen viser produktvalget, hvor brugeren vælger hvilken BH‑model og farve de vil gå videre med.
2. Skærmen tager én parameter: onBraSelected, som kaldes med farven, når brugeren trykker på et produktkort.
3. Layoutet er bygget som en Column, der scroller, så alt indhold kan ses på alle skærmstørrelser.
4. Øverst vises NEVER ANOTHER som brand‑header for at skabe genkendelighed.
5. Derefter kommer en titel og en kort beskrivelse, der forklarer formålet med skærmen.
6. Der er god afstand mellem elementerne via Spacer, så layoutet føles luftigt og let at læse.
7. Brugeren præsenteres for to BraProductCard‑komponenter, som viser hver sin farvevariant.
8. Når brugeren trykker på et kort, kaldes onBraSelected("black") eller "white", så næste skærm ved hvilken farve der er valgt.
9. Produktkortene viser titel, beskrivelse, pris og billede, så brugeren får et klart visuelt valg.
10. Nederst er der en forklarende tekst, der guider brugeren videre i flowet og sætter forventninger til næste trin.
 */