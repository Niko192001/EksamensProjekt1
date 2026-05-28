package com.example.neveranother.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.neveranother.R
import com.example.neveranother.screens.BackgroundColor
import com.example.neveranother.screens.LightCircle

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,

    currentRoute: String = "",

    onHomeClick: () -> Unit = {},
    onFitClick: () -> Unit = {},
    onCartClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},


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



        Box(
            modifier = Modifier
                .size(42.dp)
                .then(
                    if (currentRoute == "home") Modifier.background(LightCircle, CircleShape)
                    else Modifier
                )
                .clickable { onHomeClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.Home,
                contentDescription = "Hjem",
                modifier = Modifier.size(30.dp),
                tint = Color.Black
            )
        }

        Box(
            modifier = Modifier
                .size(42.dp)
                .then(
                    if (currentRoute == "Fit") Modifier.background(LightCircle, CircleShape)
                    else Modifier
                )
                .clickable { onFitClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.fit_ikon),
                contentDescription = "Fit",
                modifier = Modifier.size(30.dp),
                tint = Color.Black
            )
        }





        Box(
            modifier = Modifier
                .size(42.dp)
                .then(
                    if (currentRoute == "Kurv") Modifier.background(LightCircle, CircleShape)
                    else Modifier
                )
                .clickable { onCartClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "Kurv",
                modifier = Modifier
                    .size(29.dp)
                    .clickable { onCartClick() },
                tint = Color.Black
            )
        }

        Box(
            modifier = Modifier
                .size(42.dp)
                .then(
                    if (currentRoute == "profile") Modifier.background(LightCircle, CircleShape)
                    else Modifier
                )
                .clickable { onProfileClick() },
            contentAlignment = Alignment.Center

        ) {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "profile",
                modifier = Modifier
                    .size(31.dp)
                    .clickable { onProfileClick() },

                tint = Color.Black
            )
        }
    }
}

