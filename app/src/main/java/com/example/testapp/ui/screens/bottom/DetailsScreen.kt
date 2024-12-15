package com.example.testapp.ui.screens.bottom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.R
import com.example.testapp.uikit.button.MyButton
import com.example.testapp.uikit.common.BlackColor
import com.example.testapp.uikit.common.WhiteColor

@Composable
fun DetailsScreen(
    cardId: Int? = null,
    onIconBackClick: () -> Unit = {},
) {

    val cardText =
        "Lorem ipsum dolor sit amet consectetur. Turpis purus eu fermentum imperdiet massa semper. Cras eu rutrum amet mauris ac maecenas orci ut sem. Ut odio facilisis id feugiat. Diam et purus nulla interdum tortor laoreet ac neque neque. Pharetra mauris mattis in venenatis. Orci facilisi duis mi ultrices amet eget nulla."
    if (cardId == null) {
        Text("Invalid card ID")
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteColor),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(R.drawable.card_bg1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BlackColor.copy(alpha = 0.38F))
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "DAY 1",
                        fontSize = 14.sp,
                        color = WhiteColor,
                        fontWeight = FontWeight.Normal
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
                                .clickable (onClick = onIconBackClick),
                            painter = painterResource(R.drawable.arrow),
                            contentDescription = null,
                            tint = WhiteColor
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = cardText,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = BlackColor.copy(alpha = 0.7F)
                )
                Text(
                    text = cardText,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = BlackColor.copy(alpha = 0.7F)
                )
                Text(
                    text = cardText,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = BlackColor.copy(alpha = 0.7F)
                )
            }
        }
        MyButton(
            modifier = Modifier
                .padding(vertical = 24.dp, horizontal = 16.dp),
            buttonText = "Training"
        )
    }
}

@Composable
@Preview
private fun DetailsScreenPreview() {
    DetailsScreen(cardId = 1)
}