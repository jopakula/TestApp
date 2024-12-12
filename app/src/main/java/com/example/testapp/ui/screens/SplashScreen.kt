package com.example.testapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testapp.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigationController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(2000)
        navigationController.navigate(Screens.Main.screen) {
            popUpTo(0) { inclusive = true }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Splash Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}
