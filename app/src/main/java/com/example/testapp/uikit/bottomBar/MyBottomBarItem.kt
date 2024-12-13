package com.example.testapp.uikit.bottomBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.uikit.common.GreenColor
import com.example.testapp.uikit.common.UnSelectedIconColor

@Composable
fun MyBottomBarItem(
    icon: Int = 0,
    iconSize: Dp = 32.dp,
    label: String = "",
    labelSize: TextUnit = 12.sp,
    isSelected: Boolean = false,
    onClick: () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = Modifier
            .padding(vertical = 6.dp)
            .clickable (
                interactionSource = interactionSource,
                indication = rememberRipple(),
                onClick = onClick,
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(iconSize),
            tint = if (isSelected) GreenColor else UnSelectedIconColor
        )
        Text(
            text = label,
            fontSize = labelSize,
            color = if (isSelected) GreenColor else UnSelectedIconColor
        )
    }
}

@Composable
@Preview
private fun MyBottomBarItemPreview(){
    MyBottomBarItem()
}
