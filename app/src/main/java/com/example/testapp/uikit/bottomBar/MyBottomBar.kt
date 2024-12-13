package com.example.testapp.uikit.bottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.R
import com.example.testapp.uikit.common.BlackColor

@Composable
fun MyBottomBar(
    selectedTab: Int = 0,
    onTabSelected: (Int) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(BlackColor)
        ,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.Top
    ) {
        MyBottomBarItem(
            icon = R.drawable.home,
            label = "Main",
            isSelected = selectedTab == 0,
            onClick = { onTabSelected(0) }
        )
        MyBottomBarItem(
            icon = R.drawable.profile,
            label = "Profile",
            isSelected = selectedTab == 1,
            onClick = { onTabSelected(1) }
        )
        MyBottomBarItem(
            icon = R.drawable.fire,
            label = "Training",
            isSelected = selectedTab == 2,
            onClick = { onTabSelected(2) }
        )
        MyBottomBarItem(
            icon = R.drawable.settings,
            label = "Settings",
            isSelected = selectedTab == 3,
            onClick = { onTabSelected(3) }
        )
    }
}

@Composable
@Preview
private fun MyBottomBarPreview(){
    MyBottomBar(selectedTab = 0)
}