package com.example.testapp.ui.screens.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.testapp.R
import com.example.testapp.navigation.Screens
import com.example.testapp.ui.helpfulFunctions.PageIndicator
import com.example.testapp.uikit.button.MyButton
import com.example.testapp.uikit.common.WhiteColor

@Composable
fun Onboarding1Screen(
    navigationController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteColor)
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(R.drawable.onboarding1_small),
            contentDescription = null,
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier,
                text = "Dive into the 30 day challenge",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Practice every day for a month",
                fontSize = 18.sp,
            )
        }
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyButton(
                onClick = { navigationController.navigate(Screens.Onboarding2.screen) },
                buttonText = "Next"
            )
            PageIndicator(
                currentPage = 0,
                totalPages = 2,
            )
        }
    }
}

@Composable
@Preview
private fun Onboarding1ScreenPreview() {
    Onboarding1Screen(navigationController = rememberNavController())
}