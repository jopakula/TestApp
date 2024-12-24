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

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TestResultScreen(
    navigationController: NavHostController,
    cardId: Int? = null,
    correctAnswersCount: Int,
    ) {

    val resultText = when {
        correctAnswersCount == 1 -> "Well done"
        else -> "Opps..."

    }
    val resultHint = when {
        correctAnswersCount == 1 ->  "You answered the question correctly"
        else -> "You can replay to answer correctly"

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
            text = "Test Result",
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
                if (correctAnswersCount == 1){
                    GlideImage(
                        model =  R.drawable.star1,
                        contentDescription = null,
                    )
                }
                Text(
                    text = resultHint,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = GrayColor,
                    textAlign = TextAlign.Center,
                )
            }
            Text(
                text = "$correctAnswersCount / 1",
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                color = if (correctAnswersCount > 0) GreenColor else RedColor
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (correctAnswersCount == 1){
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
                            navigationController.navigate(Screens.Main.screen){
                                popUpTo(0) { inclusive = true }
                            }
                        },
                    )
                } else {
                    MyButton(
                        buttonText = "Again",
                        onClick = {
                            navigationController.navigate(Screens.Detail.createRoute(cardId = cardId?: 0)){
                                popUpTo(Screens.Main.screen) { inclusive = false }
                            }
                        }
                    )
                    MyButton(
                        buttonText = "Finish",
                        type = ButtonType.Outline,
                        onClick = {
                            navigationController.navigate(Screens.Main.screen){
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
private fun TestResultScreenPreview(){
    TestResultScreen(
        navigationController = rememberNavController(),
        correctAnswersCount = 1
    )
}