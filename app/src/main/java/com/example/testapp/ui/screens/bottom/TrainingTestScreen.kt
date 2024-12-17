package com.example.testapp.ui.screens.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.testapp.navigation.Screens
import com.example.testapp.ui.viewModels.TrainingTestViewModel
import com.example.testapp.uikit.button.ButtonType
import com.example.testapp.uikit.button.MyButton
import com.example.testapp.uikit.common.BlackColor
import com.example.testapp.uikit.common.GreenColor
import com.example.testapp.uikit.common.RedColor
import com.example.testapp.uikit.common.WhiteColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TrainingTestScreen(
    navigationController: NavHostController,
) {
    val viewModel: TrainingTestViewModel = remember { TrainingTestViewModel() }
    val currentQuestion = viewModel.currentQuestion
    val currentQuestionId = viewModel.currentQuestionId.value
    val correctAnswersCount = viewModel.correctAnswersCount.value
    var selectedAnswerIndex by remember { mutableStateOf<Int?>(null) }

    LaunchedEffect(currentQuestionId) {
        selectedAnswerIndex = null
    }

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
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(color = GreenColor),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 20.dp),
                    text = currentQuestion?.questionText?: "",
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
                currentQuestion?.options?.forEachIndexed { index, option ->
                    MyButton(
                        buttonText = option,
                        buttonBGColor = when {
                            selectedAnswerIndex == null -> WhiteColor
                            index == currentQuestion.correctAnswerIndex -> GreenColor
                            index == selectedAnswerIndex -> RedColor
                            else -> WhiteColor
                        },
                        type = when {
                            selectedAnswerIndex == null -> ButtonType.Outline
                            index == currentQuestion.correctAnswerIndex || index == selectedAnswerIndex -> ButtonType.Default
                            else -> ButtonType.Outline
                        },
                        onClick = {
                            if (selectedAnswerIndex == null) {
                                selectedAnswerIndex = index
                                val isCorrect = index == currentQuestion.correctAnswerIndex
                                viewModel.markAnswer(isCorrect)
                                CoroutineScope(Dispatchers.Main).launch{
                                    delay(1000)
                                    if (viewModel.isLastQuestion()) {
                                        navigationController.navigate(Screens.TrainingResult.createRoute(correctAnswersCount = viewModel.correctAnswersCount.value))
                                    } else {
                                        viewModel.moveToNextQuestion()
                                    }
                                }
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
private fun TrainingTestScreenPreview() {
    TrainingTestScreen(
        navigationController = rememberNavController()
    )
}