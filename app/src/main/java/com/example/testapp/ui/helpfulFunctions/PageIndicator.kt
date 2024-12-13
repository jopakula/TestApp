package com.example.testapp.ui.helpfulFunctions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testapp.uikit.common.BlackColor
import com.example.testapp.uikit.common.GrayColor

@Composable
fun PageIndicator(
    currentPage: Int,
    totalPages: Int,
    activeColor: androidx.compose.ui.graphics.Color = BlackColor,
    inactiveColor: androidx.compose.ui.graphics.Color = GrayColor,
) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(totalPages) { index ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .size(8.dp)
                    .background(
                        color = if (index == currentPage) activeColor else inactiveColor,
                        shape = CircleShape
                    )
            )
        }
    }
}
