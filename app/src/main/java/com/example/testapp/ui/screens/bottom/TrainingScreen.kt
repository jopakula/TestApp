package com.example.testapp.ui.screens.bottom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.R
import com.example.testapp.ui.helpfulFunctions.ChangeStatusBarColor
import com.example.testapp.uikit.button.MyButton
import com.example.testapp.uikit.common.BlackColor
import com.example.testapp.uikit.common.GreenColor
import com.example.testapp.uikit.common.WhiteColor

@Composable
fun TrainingScreen() {
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
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 50.dp),
                text = "Here you can train in addition to lessons",
                color = GreenColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
            Image(
                modifier = Modifier
                    .size(94.dp),
                painter = painterResource(R.drawable.present_box),
                contentDescription = null
            )
            Text(
                text = "Hone your skills and gain experience",
                color = BlackColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
            MyButton(
                buttonText = "Start"
            )
        }

    }
}


@Composable
@Preview
private fun TrainingScreenPreview() {
    TrainingScreen()
}