package com.example.zomato.BottomNavigation.Pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Dining(modifier: Modifier = Modifier) {

    Column(modifier= Modifier.fillMaxSize().background(color = Color.Magenta),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "DiningScreen", color = Color.White, fontWeight = FontWeight.Bold, fontSize =40.sp)
    }

}