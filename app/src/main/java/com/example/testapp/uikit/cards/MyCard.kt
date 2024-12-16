package com.example.testapp.uikit.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.data.LessonCard
import com.example.testapp.uikit.common.BlackColor
import com.example.testapp.uikit.common.GrayColor
import com.example.testapp.uikit.common.WhiteColor

@Composable
fun MyCard(
    card: LessonCard,
    onClick: () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(
                onClick = onClick,
                interactionSource = interactionSource,
                indication = rememberRipple(),
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(card.imageRes),
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
                .fillMaxSize()
                .background(color = Color.Transparent, shape = RoundedCornerShape(16.dp)),
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 16.dp, top = 32.dp, end = 16.dp, bottom = 8.dp),
                text = card.title,
                color = WhiteColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.51f))
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
                    text = card.description,
                    color = GrayColor,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

//@Composable
//@Preview
//private fun MyCardPreview() {
//    val card =LessonCard(
//        id = 1,
//        title = "title",
//        description = "description",
//        imageRes = painterResource(R.drawable.card_bg1)
//    )
//    MyCard(
//        card =
//    )
//}
