package com.example.neveranother.components

import android.hardware.lights.Light
import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neveranother.screens.Burgundy

@Composable
fun PaymentOption(
    title: String,
    isSelected: Boolean,
    iconRes: Int,
    onClick: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(
                if(isSelected) Color(0XFFEFDFD5) else Color.White,
                RoundedCornerShape(10.dp)
            )
            .border(
                width = if(isSelected) 2.dp else 1.dp,
                color = if(isSelected) Burgundy else Color.LightGray,
                shape =  RoundedCornerShape(10.dp)
            )
            .clickable{onClick()}
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = title,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
    Spacer(modifier = Modifier.height(12.dp))
}
