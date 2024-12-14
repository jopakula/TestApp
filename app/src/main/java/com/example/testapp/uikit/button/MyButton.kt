package com.example.testapp.uikit.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.uikit.common.BlackColor
import com.example.testapp.uikit.common.GreenColor
import com.example.testapp.uikit.common.WhiteColor

enum class ButtonType {
    Default,
    Outline,
}


@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    buttonHeight: Dp = 52.dp,
    buttonBGColor: Color = GreenColor,
    buttonText: String = "Button",
    type: ButtonType = ButtonType.Default,
    roundingSize: Dp = 16.dp,
    textSize: TextUnit = 18.sp,
    textWeight: FontWeight = FontWeight.SemiBold,
    borderWidth: Dp? = 1.dp,
    borderColor: Color = GreenColor,
    shadowElevation: Dp? = null,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
) {

    val buttonColor = when (type) {
        ButtonType.Default -> buttonBGColor
        ButtonType.Outline -> WhiteColor
    }
    val textColor = when (type) {
        ButtonType.Default -> WhiteColor
        ButtonType.Outline -> BlackColor
    }


    val interactionSource = remember { MutableInteractionSource() }
    val borderModifier = if (type == ButtonType.Outline) {
        Modifier.border(
            width = borderWidth ?: 0.dp,
            color = borderColor,
            shape = RoundedCornerShape(roundingSize)
        )
    } else {
        Modifier
    }
    val shadowModifier = if (shadowElevation != null) {
        Modifier.shadow(
            elevation = shadowElevation,
            shape = RoundedCornerShape(roundingSize)
        )
    } else {
        Modifier
    }
    Row(
        modifier = modifier
            .then(shadowModifier)
            .fillMaxWidth()
            .height(buttonHeight)
            .clip(RoundedCornerShape(roundingSize))
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(),
                enabled = enabled,
                onClick = onClick,
            )
            .graphicsLayer {
                alpha = if (enabled) 1f else 0.5f
            }
            .background(
                color = buttonColor,
                shape = RoundedCornerShape(roundingSize)
            )
            .then(borderModifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = buttonText,
            color = textColor,
            fontSize = textSize,
            fontWeight = textWeight
        )
    }
}

@Composable
@Preview
private fun MyDefaultButtonPreview() {
    MyButton(
        type = ButtonType.Default
    )
}
@Composable
@Preview
private fun MyOutlineButtonPreview() {
    MyButton(
        type = ButtonType.Outline
    )
}