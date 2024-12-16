package com.example.testapp.ui.screens.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.testapp.R
import com.example.testapp.navigation.Screens
import com.example.testapp.uikit.common.GreenColor
import com.example.testapp.uikit.common.WhiteColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    navigationController: NavHostController,
) {
    var progress by remember { mutableStateOf(0f) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            for (i in 0..100) {
                progress = i / 100f
                delay(20)
            }
            delay(100)
            navigationController.navigate(Screens.Onboarding1.screen) {
                popUpTo(0) { inclusive = true }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteColor),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .padding(50.dp)
                .size(180.dp),
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
        )
        LinearProgressIndicator(
            modifier = Modifier
                .width(200.dp)
                .height(6.dp)
                .clip(shape = RoundedCornerShape(4.dp)),
            progress = progress,
            color = GreenColor
        )
    }
}

@Composable
@Preview
private fun SplashScreenPreview(){
    SplashScreen(navigationController = rememberNavController())
}
