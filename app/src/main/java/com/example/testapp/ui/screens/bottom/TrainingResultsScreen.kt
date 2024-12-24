package com.example.testapp.ui.screens.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.testapp.R
import com.example.testapp.navigation.Screens
import com.example.testapp.ui.helpfulFunctions.ChangeStatusBarColor
import com.example.testapp.uikit.button.ButtonType
import com.example.testapp.uikit.button.MyButton
import com.example.testapp.uikit.common.BlackColor
import com.example.testapp.uikit.common.GrayColor
import com.example.testapp.uikit.common.GreenColor
import com.example.testapp.uikit.common.RedColor
import com.example.testapp.uikit.common.WhiteColor
import com.example.testapp.uikit.common.YellowColor

enum class MyResult {
    BAD,
    GOOD,
    EXCELLENT,
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TrainingResultsScreen(
    navigationController: NavHostController,
    correctAnswersCount: Int = 0,
) {
    val result = when {
        correctAnswersCount >= 4 -> MyResult.EXCELLENT
        correctAnswersCount >= 2 -> MyResult.GOOD
        else -> MyResult.BAD
    }
    val resultText = when {
        correctAnswersCount >= 4 -> "Well done"
        correctAnswersCount >= 2 -> "Can be better"
        else -> "Opps..."
    }
    val resultHint = when {
        correctAnswersCount >= 4 -> "You answered all the questions correctly"
        correctAnswersCount >= 2 -> "You can replay to answer everything correctly"
        else -> "Your answers are not enough to go further"
    }
    val resultImage = when {
        correctAnswersCount >= 4 -> R.drawable.star3
        correctAnswersCount >= 2 -> R.drawable.star2
        else -> R.drawable.star1
    }
    ChangeStatusBarColor(color = WhiteColor, isIconsLight = false)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteColor),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            modifier = Modifier
                .padding(start = 16.dp, top = 64.dp, end = 16.dp, bottom = 16.dp),
            text = "Training",
            fontSize = 34.sp,
            fontWeight = FontWeight.ExtraBold,
            color = BlackColor
        )
        HorizontalDivider()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 60.dp),
                    text = resultText,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = BlackColor,
                    textAlign = TextAlign.Center,
                )
                GlideImage(
                    model = resultImage,
                    contentDescription = null,
                )
                Text(
                    text = resultHint,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = GrayColor,
                    textAlign = TextAlign.Center,
                )
            }
            Text(
                text = "$correctAnswersCount / 6",
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                color = when (result){
                    MyResult.EXCELLENT -> GreenColor
                    MyResult.GOOD -> YellowColor
                    MyResult.BAD -> RedColor
                }
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (result == MyResult.EXCELLENT) {
                    Text(
                        modifier = Modifier
                            .padding(bottom = 10.dp),
                        text = "Now you can move on to the next lesson",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = GrayColor,
                        textAlign = TextAlign.Center,
                    )
                    MyButton(
                        buttonText = "Finish",
                        onClick = {
                            navigationController.navigate(Screens.Training.screen) {
                                popUpTo(0) { inclusive = true }
                            }
                        },
                    )
                } else {
                    MyButton(
                        buttonText = "Again",
                        onClick = {
                            navigationController.navigate(Screens.TrainingTest.screen) {
                                popUpTo(0) { inclusive = true }
                            }
                        }
                    )
                    MyButton(
                        buttonText = "Finish",
                        type = ButtonType.Outline,
                        onClick = {
                            navigationController.navigate(Screens.Training.screen) {
                                popUpTo(0) { inclusive = true }
                            }
                        },
                    )
                }
            }
        }
    }
}


@Composable
@Preview
private fun TrainingResultsScreenPreview() {
    TrainingResultsScreen(navigationController = rememberNavController())
}
