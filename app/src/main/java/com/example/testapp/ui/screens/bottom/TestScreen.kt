package com.example.testapp.ui.screens.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.testapp.R
import com.example.testapp.data.storage.lessonCards
import com.example.testapp.data.storage.questions
import com.example.testapp.navigation.Screens
import com.example.testapp.ui.helpfulFunctions.ChangeStatusBarColor
import com.example.testapp.uikit.button.ButtonType
import com.example.testapp.uikit.button.MyButton
import com.example.testapp.uikit.common.BlackColor
import com.example.testapp.uikit.common.BlueColor
import com.example.testapp.uikit.common.BlueColor2
import com.example.testapp.uikit.common.RedColor
import com.example.testapp.uikit.common.WhiteColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TestScreen(
    navigationController: NavHostController,
    cardId: Int? = null,
    onIconBackClick: () -> Unit = {},
) {
    val card = lessonCards.find { it.id == cardId }
    val question = questions.find { it.id == cardId }

    val interactionSource = remember { MutableInteractionSource() }

    var selectedAnswerIndex by remember { mutableStateOf<Int?>(null) }
    var isAnswerCorrect by remember { mutableStateOf<Boolean?>(null) }

    ChangeStatusBarColor(color = WhiteColor, isIconsLight = false)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteColor),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(WhiteColor)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = card?.title ?: "Title",
                    fontSize = 22.sp,
                    color = BlackColor,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(start = 8.dp, top = 26.dp)
                            .rotate(180f)
                            .size(18.dp)
                            .clickable(
                                onClick = onIconBackClick,
                                interactionSource = interactionSource,
                                indication = rememberRipple(),
                            ),
                        painter = painterResource(R.drawable.arrow),
                        contentDescription = null,
                        tint = BlueColor
                    )
                }
            }
        }
        HorizontalDivider()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(color = BlueColor2),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 20.dp),
                    text = question?.questionText ?: "",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = WhiteColor,
                    textAlign = TextAlign.Center,
                )
            }
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                question?.options?.forEachIndexed { index, option ->
                    MyButton(
                        buttonText = option,
                        buttonBGColor = when {
                            selectedAnswerIndex == null -> WhiteColor
                            index == question.correctAnswerIndex -> BlueColor2
                            index == selectedAnswerIndex -> RedColor
                            else -> WhiteColor
                        },
                        type = when {
                            selectedAnswerIndex == null -> ButtonType.Outline
                            index == question.correctAnswerIndex || index == selectedAnswerIndex -> ButtonType.Default
                            else -> ButtonType.Outline
                        },
                        onClick = {
                            if (selectedAnswerIndex == null) {
                                selectedAnswerIndex = index
                                isAnswerCorrect = index == question.correctAnswerIndex
                            }
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(1500)
                                val result = if (isAnswerCorrect == true) 1 else 0
                                navigationController.navigate(Screens.TestResult.createRoute(correctAnswersCount = result, cardId = cardId?: 0))
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun TestScreenPreview() {
    TestScreen(
        cardId = 1,
        navigationController = rememberNavController()
    )
}