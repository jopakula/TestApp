package com.example.testapp.ui.screens.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.uikit.common.BlackColor
import com.example.testapp.uikit.common.WhiteColor

@Composable
fun DetailsScreen(
    cardId: Int? = null,
) {
    if (cardId == null) {
        Text("Invalid card ID")
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = WhiteColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Details for $cardId",
            fontSize = 24.sp,
            color = BlackColor
        )
    }
}

@Composable
@Preview
private fun DetailsScreenPreview(){
    DetailsScreen()
}