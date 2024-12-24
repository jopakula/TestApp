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
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import com.example.testapp.data.storage.lessonCards
import com.example.testapp.navigation.Screens
import com.example.testapp.ui.helpfulFunctions.ChangeStatusBarColor
import com.example.testapp.uikit.button.MyButton
import com.example.testapp.uikit.common.BlackColor
import com.example.testapp.uikit.common.WhiteColor

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailsScreen(
    navigationController: NavHostController,
    cardId: Int? = null,
    onIconBackClick: () -> Unit = {},
) {
    val card = lessonCards.find { it.id == cardId }

    val interactionSource = remember { MutableInteractionSource() }
    if (cardId == null) {
        Text("Invalid card ID")
        return
    }

    ChangeStatusBarColor(color = BlackColor, isIconsLight = true)

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
                GlideImage(
                    modifier = Modifier
                        .fillMaxWidth(),
                    model = card?.imageRes ?: 1,
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
                        text = card?.title ?: "Title",
                        fontSize = 22.sp,
                        color = WhiteColor,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
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
                    text = card?.description ?: "Description",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = BlackColor.copy(alpha = 0.7F)
                )
            }
        }
        MyButton(
            modifier = Modifier
                .padding(vertical = 24.dp, horizontal = 16.dp),
            buttonText = "Training",
            onClick = {
                navigationController.navigate(Screens.Test.createRoute(cardId = cardId)){}
            }
        )
    }
}

@Composable
@Preview
private fun DetailsScreenPreview() {
    DetailsScreen(
        cardId = 1,
        navigationController = rememberNavController()
    )
}